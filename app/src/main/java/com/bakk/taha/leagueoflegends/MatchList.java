package com.bakk.taha.leagueoflegends;

/**
 * Created by x3727349s on 13/01/17.
 */

public class MatchList {

    private long champion;
    private String lane;
    private long matchId;
    private String platformId;
    private String queue;
    private String region;
    private String role;
    private String season;
    private long timestamp;

    public long getChampion() {
        return champion;
    }

    public void setChampion(long champion) {
        this.champion = champion;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public long getMatchId() {
        return matchId;
    }

    public void setMatchId(long matchId) {
        this.matchId = matchId;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "MatchList{" +
                "champion=" + champion +
                ", lane='" + lane + '\'' +
                ", matchId=" + matchId +
                ", platformId='" + platformId + '\'' +
                ", queue='" + queue + '\'' +
                ", region='" + region + '\'' +
                ", role='" + role + '\'' +
                ", season='" + season + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
