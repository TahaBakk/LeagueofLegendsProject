package com.bakk.taha.leagueoflegends;

/**
 * Created by Taha on 07/01/2017.
 */

public class Invocador {

    private long id;
    private String name;
    private int profileIconId;
    private long summonerLevel;
    private long revisionDate;

    public long getId() {return id;}
    public String getName() {return name;}
    public int getProfileIconId() {return profileIconId;}
    public long getRevisionDate() {return revisionDate;}
    public long getSummonerLevel() {return summonerLevel;}

    public void setId(long id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setProfileIconId(int profileIconId) {this.profileIconId = profileIconId;}
    public void setRevisionDate(long revisionDate) {this.revisionDate = revisionDate;}
    public void setSummonerLevel(long summonerLevel) {this.summonerLevel = summonerLevel;}

    @Override
    public String toString() {
        return "Invocador{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profileIconId=" + profileIconId +
                ", revisionDate=" + revisionDate +
                ", summonerLevel=" + summonerLevel +
                '}';
    }
}
