package incheonpeople.compareChamp.dto;


import lombok.Data;

@Data
public class NumNamVicPicDto {

    private Integer champNumber;
    private String champName;
    private Double victoryRate;
    private Double pickRate;

    public NumNamVicPicDto(Integer champNumber, String champName, Double victoryRate, Double pickRate) {
        this.champNumber = champNumber;
        this.champName = champName;
        this.victoryRate = victoryRate;
        this.pickRate = pickRate;
    }

    public String getChampName() {
        return champName;
    }

    public void setChampName(String champName) {
        this.champName = champName;
    }

    public Double getPickRate() {
        return pickRate;
    }

    public void setPickRate(Double pickRate) {
        this.pickRate = pickRate;
    }

    public Integer getChampNumber() {
        return champNumber;
    }

    public void setChampNumber(Integer champNumber) {
        this.champNumber = champNumber;
    }

    public Double getVictoryRate() {
        return victoryRate;
    }

    public void setVictoryRate(Double victoryRate) {
        this.victoryRate = victoryRate;
    }
}
