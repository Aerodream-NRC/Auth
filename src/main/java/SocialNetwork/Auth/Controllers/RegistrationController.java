package SocialNetwork.Auth.Controllers;

import SocialNetwork.Auth.Dto.UserDto;
import SocialNetwork.Auth.Entities.UserEntity;
import SocialNetwork.Auth.Exceptions.UserAlreadyExistException;
import SocialNetwork.Auth.Services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    @Autowired
    private UserService userService;

    private ModelAndView modelAndView;

    @GetMapping("/register")
    public void showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
    }

    @PostMapping("/register")
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") @Valid UserDto userDto,
            HttpServletRequest request,
            Errors errors) {
        try {
            UserEntity registered = userService.registerNewUserAccount(userDto);
        } catch (UserAlreadyExistException uaeEx) {
            modelAndView.addObject("message", "An account for that login already exists.");
            return modelAndView;
        }

        return new ModelAndView("successRegister", "user", userDto);
    }
}