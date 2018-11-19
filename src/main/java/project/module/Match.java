package project.module;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "matches", schema = "my_score", catalog = "")
public class Match implements Serializable {

    @Id
    @Column(name = "id_match", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "scoreTeam1")
    private int scoreTeam1;

    @Column(name = "scoreTeam2")
    private int scoreTeam2;

    @Column(name = "matchDate")
    private String matchDate;

    @Column(name = "matchMonth")
    private String matchMonth;

    @Column(name = "matchTimeHours")
    private String matchTimeHours;

    @Column(name = "matchTimeMinutes")
    private String matchTimeMinutes;


    @OneToMany(mappedBy = "match",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<ForMatches> forMatchesSet = new HashSet<>();


    public Match() {
    }

    public String getMatchTimeMinutes() {
        return matchTimeMinutes;
    }

    public void setMatchTimeMinutes(String matchTimeMinutes) {
        this.matchTimeMinutes = matchTimeMinutes;
    }

    public String getMatchMonth() {
        return matchMonth;
    }

    public void setMatchMonth(String matchMonth) {
        this.matchMonth = matchMonth;
    }

    public String getMatchTimeHours() {
        return matchTimeHours;
    }

    public void setMatchTimeHours(String matchTimeHours) {
        this.matchTimeHours = matchTimeHours;
    }

    public Set<ForMatches> getForMatchesSet() {
        return forMatchesSet;
    }

    public void setForMatchesSet(Set<ForMatches> forMatchesSet) {
        this.forMatchesSet = forMatchesSet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getScoreTeam1() {
        return scoreTeam1;
    }

    public void setScoreTeam1(int scoreTeam1) {
        this.scoreTeam1 = scoreTeam1;
    }

    public int getScoreTeam2() {
        return scoreTeam2;
    }

    public void setScoreTeam2(int scoreTeam2) {
        this.scoreTeam2 = scoreTeam2;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }
}

