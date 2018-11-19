package project.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import project.module.Match;
import project.module.Sport;
import project.module.Team;
import project.module.User;
import project.service.MatchService;
import project.service.SprotService;
import project.service.TeamService;
import project.service.UserService;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private UserService userServiceDB;

    @Autowired
    private TeamService teamServiceforRest;

    @Autowired
    private SprotService sprotServiceForRest;

    @Autowired
    private MatchService matchService;


    @GetMapping("/list")
    public List<User> list() {
        return userServiceDB.listUser();
    }

    @GetMapping("/listTeam")
    public List<Team> teamList() {
        return teamServiceforRest.listTeam();
    }
    @GetMapping("/listSport")
    public List<Sport> teamSport() {
        return sprotServiceForRest.sportList();
    }

    @GetMapping("/listMatches")
    public List<Match> matchList() {
        return matchService.listMatch();
    }
}
