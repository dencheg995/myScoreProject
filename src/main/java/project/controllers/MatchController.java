package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.module.ForMatches;
import project.module.League;
import project.module.Match;
import project.module.Team;
import project.service.ForMatchesService;
import project.service.MatchService;
import project.service.TeamService;

@Controller
public class MatchController {

    @Autowired
    private MatchService matchService;

    @Autowired
    private ForMatchesService forMatchesService;

    @Autowired
    private TeamService teamServiceForMatch;

    @RequestMapping(value = "/addMatch", method = RequestMethod.POST)
    public String addMatch(@ModelAttribute("matchAttribute") Match match,
                           @ModelAttribute("forMatchAttribute") ForMatches forMatches
            , @ModelAttribute("forMatchAttribute1") ForMatches forMatches1) {
        Team team1 = teamServiceForMatch.getTeam(forMatches.getTeam_id());
        Team team2 = teamServiceForMatch.getTeam(forMatches.getTeam_id2());
        forMatches.setTeam(team1);
        forMatches1.setTeam(team2);
        forMatches.setMatch(match);
        forMatches1.setMatch(match);
        forMatches.setTeam_id2(team1.getId());
        forMatches1.setTeam_id2(team2.getId());
        forMatches.setTeamName1(team1.getNameTeam());
        forMatches1.setTeamName1(team2.getNameTeam());
        matchService.addMatch(match);
        forMatchesService.addID(forMatches);
        forMatchesService.addID(forMatches1);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/removeMatch/{id}", method = RequestMethod.GET)
    public String removeMatch(@PathVariable long id, Model model) {
        matchService.removeMatch(id);
        model.addAttribute("id", id);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/editMatch", method = RequestMethod.POST)
    public String editTeam(@RequestParam(value = "idMatchChange") long idTeam,
                           @RequestParam(value = "nameMatchChange1") String nameMatch1,
                           @RequestParam(value = "nameMatchChange2") String nameMatch2,
                           @RequestParam(value = "dateMatchChange") String date, Match match) {



        return "redirect:/admin";
    }

}
