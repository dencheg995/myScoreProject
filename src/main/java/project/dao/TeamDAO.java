package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.module.Team;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public interface TeamDAO extends JpaRepository<Team, Long> {



//    @PersistenceContext
//    private EntityManager em;
//
//    @Transactional
//    public long addTeam(Team team) {
//        em.persist(team);
//        return team.getId();
//    }
//
//    @Transactional
//    public void removeTeam(long id) {
//        Team team = em.find(Team.class, id);
//        em.remove(team);
//    }
//
//    @Transactional
//    public List<Team> listTeam() {
//        return em.createQuery("select team from Team team").getResultList();
//    }
}
