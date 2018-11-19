package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.LeagueDAO;
import project.module.League;
import project.module.Team;

@Service
public class LeagueService {

    @Autowired
    private LeagueDAO leagueDAO;

    @Transactional
    public void addLeague(League league, Team team) {
        league.setTeam(team);
        leagueDAO.save(league);
    }

    @Transactional
    public void removeLeague(long id) {
        leagueDAO.deleteById(leagueDAO.getOne(id).getId());
    }

    @Transactional
    public long getLeague(long teamId) {
        return leagueDAO.getOne(teamId).getId();
    }

    @Transactional
    public void editLeague(League league) {
        League newLeague = new League();
        newLeague.setId(league.getId());
        newLeague.setNameLeague(league.getNameLeague());
        newLeague.setTeam(league.getTeam());
        leagueDAO.save(newLeague);
    }
}
