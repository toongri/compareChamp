package incheonpeople.compareChamp.dto;

import lombok.Data;

@Data
public class ForCompareChampDto {
    private Integer champNumber;
    private String champName;
    private double kda;
    private double avgDamage;
    private double vicRate;

    public ForCompareChampDto(Integer champNumber, String champName, double kda, double avgDamage, double vicRate) {
        this.champNumber = champNumber;
        this.champName = champName;
        this.kda = kda;
        this.avgDamage = avgDamage;
        this.vicRate = vicRate;
    }

    public Integer getChampNumber() {
        return champNumber;
    }

    public void setChampNumber(Integer champNumber) {
        this.champNumber = champNumber;
    }

    public String getChampName() {
        return champName;
    }

    public void setChampName(String champName) {
        this.champName = champName;
    }

    public double getKda() {
        return kda;
    }

    public void setKda(double kda) {
        this.kda = kda;
    }

    public double getAvgDamage() {
        return avgDamage;
    }

    public void setAvgDamage(double avgDamage) {
        this.avgDamage = avgDamage;
    }

    public double getVicRate() {
        return vicRate;
    }

    public void setVicRate(double vicRate) {
        this.vicRate = vicRate;
    }
}
