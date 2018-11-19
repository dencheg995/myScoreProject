package project.module;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "for_matches", schema = "my_score", catalog = "")
public class ForMatches implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_for_matches")
    private long id;

    @Column(name = "match_id_match" , updatable=false, insertable = false)
    private long match_id;


    private long team_id2;

    private String teamName1;





    @ManyToOne
    @JsonBackReference
    private Team team;

    @ManyToOne
    @JsonBackReference
    private Match match;

    public ForMatches() {
    }


    public String getTeamName1() {
        return teamName1;
    }

    public void setTeamName1(String teamName1) {
        this.teamName1 = teamName1;
    }


    public long getTeam_id2() {
        return team_id2;
    }

    public void setTeam_id2(long team_id2) {
        this.team_id2 = team_id2;
    }

    public long getTeam_id() {
        return match_id;
    }

    public void setTeam_id(long team_id) {
        this.match_id = team_id;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
