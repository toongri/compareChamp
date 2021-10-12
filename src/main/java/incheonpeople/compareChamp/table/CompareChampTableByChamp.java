package incheonpeople.compareChamp.table;


import incheonpeople.compareChamp.domain.Champ;

import java.util.ArrayList;

public class CompareChampTableByChamp {
    private final ArrayList<Champ> champs;
    private final ArrayList<Double> winningPercentage;
    private final ArrayList<Long> amountOfGame;

    public CompareChampTableByChamp(ArrayList<Champ> champs, ArrayList<Double> winningPercentage, ArrayList<Long> amountOfGame) {
        this.champs = champs;
        this.winningPercentage = winningPercentage;
        this.amountOfGame = amountOfGame;
    }
}
