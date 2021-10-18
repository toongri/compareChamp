package incheonpeople.compareChamp.dto;

import lombok.Data;

@Data
public class NumVicamtDto {
    private Integer champNumber;
    private Long amountOfVictoryGame;

    public NumVicamtDto(Integer champNumber, Long amountOfVictoryGame) {
        this.champNumber = champNumber;
        this.amountOfVictoryGame = amountOfVictoryGame;
    }

    public Integer getChampNumber() {
        return champNumber;
    }

    public void setChampNumber(Integer champNumber) {
        this.champNumber = champNumber;
    }

    public Long getAmountOfVictoryGame() {
        return amountOfVictoryGame;
    }

    public void setAmountOfVictoryGame(Long amountOfVictoryGame) {
        this.amountOfVictoryGame = amountOfVictoryGame;
    }
}
