package com.bakk.taha.leagueoflegends;

/**
 * Created by Taha on 14/01/2017.
 */

public class Match {

  private String matchMode;
  private Long matchDuration;
  private boolean winner;
  private boolean firstBlood;
  private boolean firstTower;
  private int towerKills;
  private int inhibitorKills;
  private int baronKills;
  private int dragonKills;

    public void setMatchMode(String matchMode) {this.matchMode = matchMode;}
    public void setMatchDuration(Long matchDuration) {this.matchDuration = matchDuration;}
    public void setWinner(boolean winner) {this.winner = winner;}
    public void setFirstBlood(boolean firstBlood) {this.firstBlood = firstBlood;}
    public void setFirstTower(boolean firstTower) {this.firstTower = firstTower;}
    public void setTowerKills(int towerKills) {this.towerKills = towerKills;}
    public void setInhibitorKills(int inhibitorKills) {this.inhibitorKills = inhibitorKills;}
    public void setBaronKills(int baronKills) {this.baronKills = baronKills;}
    public void setDragonKills(int dragonKills) {this.dragonKills = dragonKills;}


    public String getMatchMode() {return matchMode;}
    public Long getMatchDuration() {return matchDuration;}
    public boolean isWinner() {return winner;}
    public boolean isFirstBlood() {return firstBlood;}
    public boolean isFirstTower() {return firstTower;}
    public int getTowerKills() {return towerKills;}
    public int getInhibitorKills() {return inhibitorKills;}
    public int getBaronKills() {return baronKills;}
    public int getDragonKills() {return dragonKills;}
}
