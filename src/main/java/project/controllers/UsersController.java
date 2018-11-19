package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import project.module.*;
import project.service.RoleService;
import project.service.SprotService;
import project.service.TeamService;
import project.service.UserService;

import java.util.List;


@Controller
public class UsersController {

    @Autowired
    private UserService userServiceDB;

    @Autowired
    private RoleService roleServiceDB;

    @Autowired
    private TeamService teamServiceDB;

    @Autowired
    private SprotService sprotServiceDB;

    @RequestMapping(value = "/removeUser/{id}" , method = RequestMethod.GET)
    public String getDelete(@PathVariable long id, Model model) {
        roleServiceDB.removeRole(id);
        userServiceDB.removeUser(id);
        model.addAttribute("id", id);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin")
    public String listUsers(Model model) {
            List<Team> list = teamServiceDB.listTeam();
            List<Team> list1 = teamServiceDB.listTeam();
            model.addAttribute("list" , list);
            model.addAttribute("list1" , list1);
            model.addAttribute("userAttribute", new User());
            model.addAttribute("roleAttribute", new Role());
            model.addAttribute("teamAttribute", new Team());
            model.addAttribute("sportAttribute", new Sport());
            model.addAttribute("leagueAttribute", new League());
            model.addAttribute("matchAttribute", new Match());
            model.addAttribute("forMatchAttribute", new ForMatches());
            model.addAttribute("forMatchAttribute1", new ForMatches());
            return "admin";
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String getAdd(Model model) {
        model.addAttribute("userAttribute", new User());
        model.addAttribute("roleAttribute", new Role());
        return "/addUser";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUsers(@ModelAttribute("userAttribute") User user, @ModelAttribute("roleAttribute") Role role) {
        userServiceDB.addUser(user);
        roleServiceDB.addRole(user, role);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editUser(@PathVariable("id") Long id, Model model ) {
        model.addAttribute("changeUser", userServiceDB.getUser(id));
        return "admin";
    }

    @RequestMapping(value = "/changeUser")
    public String changeUser(@RequestParam(value = "idChange") long id,
                             @RequestParam(value = "nameChange") String name,
                             @RequestParam(value = "ageChange") int age,
                             @RequestParam(value = "loginChange") String login,
                             @RequestParam(value = "passwordChange") String password,
                             @ModelAttribute("changeUser") User profile) {

        profile.setId(id);
        profile.setName(name);
        profile.setAge(age);
        profile.setLogin(login);
        profile.setPassword(password);
        userServiceDB.changeUser(profile);
        return "redirect:/admin";
    }

}
