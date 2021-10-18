package incheonpeople.compareChamp.dto;

import lombok.Data;
import lombok.ToString;

public class ChampNumDto {
    private int firstChampNumber;
    private int secondChampNumber;
    private String lane;
    private double vicRate;

    public ChampNumDto(int firstChampNumber, int secondChampNumber, String lane, double vicRate) {
        this.firstChampNumber = firstChampNumber;
        this.secondChampNumber = secondChampNumber;
        this.lane = lane;
        this.vicRate = vicRate;
    }


    public int getSecondChampNumber() {
        return secondChampNumber;
    }

    public void setSecondChampNumber(int secondChampNumber) {
        this.secondChampNumber = secondChampNumber;
    }


    public int getFirstChampNumber() {
        return firstChampNumber;
    }

    public void setFirstChampNumber(int firstChampNumber) {
        this.firstChampNumber = firstChampNumber;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public double getVicRate() {
        return vicRate;
    }

    public void setVicRate(double vicRate) {
        this.vicRate = vicRate;
    }
}
