package project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.SportDAO;
import project.module.Sport;
import project.module.Team;

import java.util.List;

@Service
public class SprotService {

    @Autowired
    private SportDAO sportDAO;

    @Transactional
    public void addSport(Team team, Sport sport) {
        sport.setTeam(team);
        sportDAO.save(sport);
    }

    @Transactional
    public void removeSport(long id) {
        sportDAO.deleteById(sportDAO.getOne(id).getId());
    }

    @Transactional
    public List<Sport> sportList() {
        return sportDAO.findAll();
    }

}
