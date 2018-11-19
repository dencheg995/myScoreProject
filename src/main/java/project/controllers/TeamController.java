package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.module.League;
import project.module.Sport;
import project.module.Team;
import project.service.LeagueService;
import project.service.SprotService;
import project.service.TeamService;

import java.util.List;

@Controller
public class TeamController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private SprotService sprotServiceForTeam;

    @Autowired
    private LeagueService leagueServiceForTeam;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }


    @RequestMapping(value = "/addTeam", method = RequestMethod.GET)
    public String addTeam(Model model) {
        model.addAttribute("teamAttribute" , new Team());
        return "addTeam";
    }

    @RequestMapping(value = "/addTeam", method = RequestMethod.POST)
    public String addTeam(@ModelAttribute("teamAttribute") Team team, @ModelAttribute("sportAttribute") Sport sport,
                          @ModelAttribute("leagueAttribute") League league ) {
        teamService.addTeam(team);
        sprotServiceForTeam.addSport(team, sport);
        leagueServiceForTeam.addLeague(league, team);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/removeTeam/{id}" , method = RequestMethod.GET)
    public String getDelete(@PathVariable long id, Model model) {
        sprotServiceForTeam.removeSport(id);
        teamService.removeTeam(id);
        leagueServiceForTeam.removeLeague(id);
        model.addAttribute("id", id);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/editTeam", method = RequestMethod.POST)
    public String editTeam(@RequestParam(value = "idTeamChange") long idTeam,
            @RequestParam(value = "nameTeamChange") String nameTeam, Team team,
                           @RequestParam(value = "leagueChange") String nameLeague, League league) {
        team.setId(idTeam);
        team.setNameTeam(nameTeam);
        league.setId(leagueServiceForTeam.getLeague(idTeam));
        league.setNameLeague(nameLeague);
        league.setTeam(team);
        teamService.editTeam(team);
        leagueServiceForTeam.editLeague(league);
        return "redirect:/admin";
    }

}
