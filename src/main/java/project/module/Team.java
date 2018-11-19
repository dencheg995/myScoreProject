package project.module;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "team", schema = "my_score", catalog = "")
public class Team implements Serializable {

    @Id
    @Column(name = "id_team", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name_team")
    private String nameTeam;

    @OneToMany(mappedBy = "team")
    @JsonManagedReference
    private Set<Sport> sportTeam = new HashSet<Sport>();


    @OneToMany(mappedBy = "team")
    @JsonManagedReference
    private Set<League> leagueTeam = new HashSet<League>();

    @OneToMany(mappedBy = "team")
    @JsonManagedReference
    private Set<ForMatches> forMatches = new HashSet<>();


    public Team() {
    }

    public Set<ForMatches> getForMatches() {
        return forMatches;
    }

    public void setForMatches(Set<ForMatches> forMatches) {
        this.forMatches = forMatches;
    }

    public Set<League> getLeagueTeam() {
        return leagueTeam;
    }

    public void setLeagueTeam(Set<League> leagueTeam) {
        this.leagueTeam = leagueTeam;
    }

    public Set<Sport> getSportTeam() {
        return sportTeam;
    }

    public void setSportTeam(Set<Sport> sportTeam) {
        this.sportTeam = sportTeam;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id= id;
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }
}
