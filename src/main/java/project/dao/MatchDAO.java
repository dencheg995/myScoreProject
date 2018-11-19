package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.module.Match;

@Repository
public interface MatchDAO extends JpaRepository<Match, Long> {
}
