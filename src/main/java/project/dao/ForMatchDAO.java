package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.module.ForMatches;

@Repository
public interface ForMatchDAO extends JpaRepository<ForMatches, Long> {

    @Query("select forMatch from ForMatches forMatch where forMatch.match_id =:matchId")
    ForMatches getOne(@Param("matchId") long id);

    @Modifying
    @Query("delete from ForMatches forMatch where forMatch.match_id =:matchId")
    void deleteById(@Param("matchId") long id);
}