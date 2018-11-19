package project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.module.Sport;

import java.nio.file.Path;

@Repository
public interface SportDAO extends JpaRepository<Sport, Long> {

    @Query("select sport from Sport sport where sport.teamId = :teamId")
    Sport getOne(@Param("teamId") long id);
}

