package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.MatchDAO;
import project.module.Match;

import java.util.List;

@Service
public class MatchService {

    @Autowired
    private MatchDAO matchDAO;

    @Autowired
    private ForMatchesService forMatchesServiceForMatchService;

    @Transactional
    public void addMatch(Match match) {
        matchDAO.save(match);
    }


    @Transactional
    public List<Match> listMatch() {
        return matchDAO.findAll();
    }

    @Transactional
    public void removeMatch(long id) {
        forMatchesServiceForMatchService.removeTableForMatces(id);
        matchDAO.deleteById(id);
    }

    @Transactional
    public void editMatch(Match match) {
        Match newMatch = new Match();
        newMatch.setId(match.getId());
        newMatch.setMatchDate(match.getMatchDate());
        newMatch.setScoreTeam1(match.getScoreTeam1());
        newMatch.setScoreTeam2(match.getScoreTeam2());
        matchDAO.save(newMatch);
    }
}
