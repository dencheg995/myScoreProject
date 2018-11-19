package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.TeamDAO;
import project.module.Team;

import java.util.List;

@Service
@Transactional
public class TeamService {

    @Autowired
    private TeamDAO teamDAO;

    @Transactional
    public Team addTeam(Team team) {
        return teamDAO.save(team);
    }

    @Transactional
    public void removeTeam(long id) {
        teamDAO.deleteById(id);
    }

    @Transactional
    public List<Team> listTeam() {
        return teamDAO.findAll();
    }

    @Transactional
    public void editTeam(Team team) {
        Team newTeam = new Team();
        newTeam.setId(team.getId());
        newTeam.setNameTeam(team.getNameTeam());
        teamDAO.save(newTeam);
    }

    @Transactional
    public Team getTeam(long id) {
        return teamDAO.getOne(id);
    }
}

