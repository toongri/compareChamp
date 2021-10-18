package incheonpeople.compareChamp.dto;

public class TableExplainDto {
    private String kda;
    private String avgDamage;
    private String vicRate;

    public TableExplainDto() {
        this.kda = "상대시 KDA";
        this.avgDamage = "상대시 평균 피해량";
        this.vicRate = "상대 승률";
    }

    public String getKda() {
        return kda;
    }

    public void setKda(String kda) {
        this.kda = kda;
    }

    public String getAvgDamage() {
        return avgDamage;
    }

    public void setAvgDamage(String avgDamage) {
        this.avgDamage = avgDamage;
    }

    public String getVicRate() {
        return vicRate;
    }

    public void setVicRate(String vicRate) {
        this.vicRate = vicRate;
    }
}
