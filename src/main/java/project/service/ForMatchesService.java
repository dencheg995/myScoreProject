package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.ForMatchDAO;
import project.module.ForMatches;

@Service
public class ForMatchesService {

    @Autowired
    private ForMatchDAO forMatchDAO;

    @Transactional
    public void addID(ForMatches forMatches) {
        forMatchDAO.save(forMatches);
    }

    @Transactional
    public void removeTableForMatces(long id) {
        forMatchDAO.deleteById(id);
    }
}
