package com.bakk.taha.leagueoflegends;

/**
 * Created by taha on 05/06/2017.
 */

public class Match {
    //matchMode,matchDuration, queueType, mapId,season,matchVersion,
    //"participants"--"stats"--,"winner","champLevel","kills","doubleKills","tripleKills", "quadraKills","pentaKills","deaths","assists", "goldEarned"
    String matchMode;
    long matchDuration;
    String queueType;
    String season;
    boolean winner;
    long champLevel;
    long kills;
    long doubleKills;
    long tripleKills;
    long quadraKills;
    long pentaKills;
    long deaths;
    long assists;
    long goldEarned;
    String matchVersion;

    public void setMatchVersion(String matchVersion) {this.matchVersion = matchVersion;}

    public void setMatchMode(String matchMode) {this.matchMode = matchMode;}
    public void setMatchDuration(long matchDuration) {this.matchDuration = matchDuration;}
    public void setQueueType(String queueType) {this.queueType = queueType;}
    public void setSeason(String season) {this.season = season;}
    public void setWinner(boolean winner) {this.winner = winner;}
    public void setChampLevel(long champLevel) {this.champLevel = champLevel;}
    public void setKills(long kills) {this.kills = kills;}
    public void setDoubleKills(long doubleKills) {this.doubleKills = doubleKills;}
    public void setTripleKills(long tripleKills) {this.tripleKills = tripleKills;}
    public void setQuadraKills(long quadraKills) {this.quadraKills = quadraKills;}
    public void setPentaKills(long pentaKills) {this.pentaKills = pentaKills;}
    public void setDeaths(long deaths) {this.deaths = deaths;}
    public void setAssists(long assists) {this.assists = assists;}
    public void setGoldEarned(long goldEarned) {this.goldEarned = goldEarned;}

    public String getMatchVersion() {return matchVersion;}
    public String getMatchMode() {return matchMode;}
    public long getMatchDuration() {return matchDuration;}
    public String getQueueType() {return queueType;}
    public String getSeason() {return season;}
    public boolean isWinner() {return winner;}
    public long getChampLevel() {return champLevel;}
    public long getKills() {return kills;}
    public long getDoubleKills() {return doubleKills;}
    public long getTripleKills() {return tripleKills;}
    public long getQuadraKills() {return quadraKills;}
    public long getPentaKills() {return pentaKills;}
    public long getDeaths() {return deaths;}
    public long getAssists() {return assists;}
    public long getGoldEarned() {return goldEarned;}

    @Override
    public String toString() {
        return "Match{" +
                "matchMode='" + matchMode + '\'' +
                ", matchDuration=" + matchDuration +
                ", queueType='" + queueType + '\'' +
                ", season='" + season + '\'' +
                ", winner=" + winner +
                ", champLevel=" + champLevel +
                ", kills=" + kills +
                ", doubleKills=" + doubleKills +
                ", tripleKills=" + tripleKills +
                ", quadraKills=" + quadraKills +
                ", pentaKills=" + pentaKills +
                ", deaths=" + deaths +
                ", assists=" + assists +
                ", goldEarned=" + goldEarned +
                ", matchVersion='" + matchVersion + '\'' +
                '}';
    }
}
