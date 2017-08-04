package mvs.controller;

import mvs.config.AppConfig;
import mvs.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by quangminh on 25/07/2017.
 */
@Controller
public class PostController {


    @GetMapping("/")
    public String postLine(Model model){
        return "post/list_post";
    }
    @GetMapping("/posts/upload")
    public String uploadPost(Model model){
        model.addAttribute("itPost", new Post());

        return "post/tinymce";
    }

    @PostMapping("/posts/save")
    public String save(            @RequestParam("file") MultipartFile file,
                                   @ModelAttribute("itPost") Post itPost,
                                   BindingResult result,
                                   RedirectAttributes redirect) throws IOException {
        if (!file.isEmpty()) {
            File dir = new File(AppConfig.getImageSrc());
            if (!dir.exists())
                dir.mkdirs();
            byte[] bytes = file.getBytes();
            Path path = Paths.get(AppConfig.getImageSrc() + file.getOriginalFilename());
            Files.write(path, bytes);
            itPost.setImage(file.getOriginalFilename());
            redirect.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
        }
        itPost.setCreateAt(System.currentTimeMillis());


        return "redirect:/";
    }


}
