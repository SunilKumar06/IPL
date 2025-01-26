package com.IndainPremierLeague.IPL.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="player_stats")
public class Player {

    @Id
    @Column(name= "name", unique = true)
    private String name;
    private String nation;
    private String role;
    private String style;
    private int age;
    private int ranking;
    private double runs;
    private double wickets;
    private String team;

    public Player() {
    }

    public Player(String name, String nation, String role, String style, int age, int ranking, double runs, double wickets, String team) {
        this.name = name;
        this.nation = nation;
        this.role = role;
        this.style = style;
        this.age = age;
        this.ranking = ranking;
        this.runs = runs;
        this.wickets = wickets;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public String getNation() {
        return nation;
    }

    public String getRole() {
        return role;
    }

    public String getStyle() {
        return style;
    }

    public int getAge() {
        return age;
    }

    public int getRanking() {
        return ranking;
    }

    public double getRuns() {
        return runs;
    }

    public double getWickets() {
        return wickets;
    }

    public String getTeam() {
        return team;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public void setRuns(double runs) {
        this.runs = runs;
    }

    public void setWickets(double wickets) {
        this.wickets = wickets;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
