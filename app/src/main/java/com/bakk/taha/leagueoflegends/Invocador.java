package com.bakk.taha.leagueoflegends;

/**
 * Created by Taha on 07/01/2017.
 */

public class Invocador {

    private static long summonerId;
    private String summonerName;
    private int profileIconId;
    private long summonerLevel;
    private long revisionDate;

    public long getSummonerId() {return summonerId;}
    public String getSummonerName() {return summonerName;}
    public int getProfileIconId() {return profileIconId;}
    public long getRevisionDate() {return revisionDate;}
    public long getSummonerLevel() {return summonerLevel;}

    public void setSummonerId(long summonerId) {this.summonerId = summonerId;}
    public void setSummonerName(String summonerName) {this.summonerName = summonerName;}
    public void setProfileIconId(int profileIconId) {this.profileIconId = profileIconId;}
    public void setRevisionDate(long revisionDate) {this.revisionDate = revisionDate;}
    public void setSummonerLevel(long summonerLevel) {this.summonerLevel = summonerLevel;}

    @Override
    public String toString() {
        return "Invocador{" +
                "summonerId=" + summonerId +
                ", summonerName='" + summonerName + '\'' +
                ", profileIconId=" + profileIconId +
                ", summonerLevel=" + summonerLevel +
                ", revisionDate=" + revisionDate +
                '}';
    }
}
