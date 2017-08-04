package mvs.controller;

import mvs.config.AppConfig;
import mvs.model.User;
import mvs.service.SecurityService;
import mvs.service.UserService;
import mvs.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by quangminh on 27/06/2017.
 */
@Controller
public class UserController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserService userService;
    @Autowired
    SecurityService securityService;
    @Autowired
    UserValidator userValidator;


    @GetMapping("/users/edit")
    public String editUser(Model model) {
        model.addAttribute("user", userService.getCurentUser());

        return "profile/profile";
    }

    @PostMapping("/users/edit")
    public String save(
            @RequestParam("file") MultipartFile file,
            @ModelAttribute("user") User user,
            BindingResult result,
            RedirectAttributes redirect,
            Model model)
            throws IOException {

        user.setRoles(userService.getCurentUser().getRoles());
        if (!file.isEmpty()) {
            File dir = new File(AppConfig.getImageSrc());
            if (!dir.exists())
                dir.mkdirs();
            byte[] bytes = file.getBytes();
            Path path = Paths.get(AppConfig.getImageSrc() + file.getOriginalFilename());
            Files.write(path, bytes);
            user.setAvatar(file.getOriginalFilename());
            redirect.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
        }
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin/admin";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "error/403";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "security/login";
    }

    @GetMapping("/signup")
    public String getRegister(Model model) {
        model.addAttribute("user", new User());

        return "security/register";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/security/login";
    }

    @PostMapping("/signup/save")
    public String postRegister(
            @Valid User user,
            BindingResult result,
            Model model
    ) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "security/register";
        }

        userService.saveAndGrantRole(user);

        return "redirect:/login";


    }



}
