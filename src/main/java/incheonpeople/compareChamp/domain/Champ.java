package incheonpeople.compareChamp.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "info_champion")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Champ {
    @Id
    @Column(name = "CHAMPIONID")
    private int championId;//championId
    @Column(name = "CHAMPION_NAME_KR")
    private String nameOfChamp;

    public Champ(int championId, String nameOfChamp) {
        this.championId = championId;
        this.nameOfChamp = nameOfChamp;
    }

    public void setchampionId(int championId) {
        this.championId = championId;
    }
    public int getchampionId() {
        return championId;
    }

    public String getNameOfChamp() {
        return nameOfChamp;
    }

    public void setNameOfChamp(String nameOfChamp) {
        this.nameOfChamp = nameOfChamp;
    }
}
