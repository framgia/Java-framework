package mvs.controller;

import mvs.model.User;
import mvs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by quangminh on 26/07/2017.
 */
@ControllerAdvice
public class CurrentUserController {

    @Autowired
    UserService userService;
    @ModelAttribute("currentUser")
    public User getCurrentUser(@AuthenticationPrincipal User user){
        return userService.getCurentUser();
    }
}
