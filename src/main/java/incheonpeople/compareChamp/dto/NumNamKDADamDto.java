package incheonpeople.compareChamp.dto;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;

@Data
public class NumNamKDADamDto {
    private int champNumber;
    private String champName;
    private int kill;
    private int death;
    private int assist;
    private double damageDealt;

    public NumNamKDADamDto(int champNumber, String champName, int kill, int death, int assist, double damageDealt) {
        this.champNumber = champNumber;
        this.champName = champName;
        this.kill = kill;
        this.death = death;
        this.assist = assist;
        this.damageDealt = damageDealt;
    }

    public int getChampNumber() {
        return champNumber;
    }

    public void setChampNumber(int champNumber) {
        this.champNumber = champNumber;
    }

    public String getChampName() {
        return champName;
    }

    public void setChampName(String champName) {
        this.champName = champName;
    }

    public int getKill() {
        return kill;
    }

    public void setKill(int kill) {
        this.kill = kill;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    public int getAssist() {
        return assist;
    }

    public void setAssist(int assist) {
        this.assist = assist;
    }

    public double getDamageDealt() {
        return damageDealt;
    }

    public void setDamageDealt(double damageDealt) {
        this.damageDealt = damageDealt;
    }

}
