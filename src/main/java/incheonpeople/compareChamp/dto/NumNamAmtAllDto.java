package incheonpeople.compareChamp.dto;

import lombok.Data;

@Data
public class NumNamAmtAllDto {

    private Integer champNumber;
    private String champName;
    private Long amountOfGame;
    private Long amountOfAllChampGame;

    public NumNamAmtAllDto(Integer champNumber, String champName, Long amountOfGame, Long amountOfAllChampGame) {
        this.champNumber = champNumber;
        this.champName = champName;
        this.amountOfGame = amountOfGame;
        this.amountOfAllChampGame = amountOfAllChampGame;
    }

    public String getChampName() {
        return champName;
    }

    public void setChampName(String champName) {
        this.champName = champName;
    }

    public Long getAmountOfGame() {
        return amountOfGame;
    }

    public void setAmountOfGame(Long amountOfGame) {
        this.amountOfGame = amountOfGame;
    }

    public Long getAmountOfAllChampGame() {
        return amountOfAllChampGame;
    }

    public void setAmountOfAllChampGame(Long amountOfAllChampGame) {
        this.amountOfAllChampGame = amountOfAllChampGame;
    }

    public Integer getChampNumber() {
        return champNumber;
    }

    public void setChampNumber(Integer champNumber) {
        this.champNumber = champNumber;
    }

    public Long getamountOfGame() {
        return amountOfGame;
    }

    public void setamountOfGame(Long amountOfGame) {
        this.amountOfGame = amountOfGame;
    }
}
