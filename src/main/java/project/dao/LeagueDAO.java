package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.module.League;

@Repository
public interface LeagueDAO extends JpaRepository<League, Long> {

    @Query("select league from League league where league.teamId = :teamId" )
    League getOne(@Param("teamId") long id);
}
