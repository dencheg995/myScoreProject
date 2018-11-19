package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.module.User;
import project.service.RoleService;
import project.service.UserService;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/mylogin")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegist(Model model) {
        User user = new User();
        model.addAttribute("userUp", user);
        return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String regist(@ModelAttribute("userUp") @Validated User user) {
        userService.registrUser(user);
        roleService.registRole(user, "USER");
        return "redirect:/mylogin";
    }
}
