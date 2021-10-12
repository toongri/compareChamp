package incheonpeople.compareChamp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "info_champion")
public class Champ {
    @Id
    @Column(name = "CHAMPIONID")
    private Long id;
    @Column(name = "CHAMPION_NAME_KR")
    private String nameOfChamp;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public String getNameOfChamp() {
        return nameOfChamp;
    }

    public void setNameOfChamp(String nameOfChamp) {
        this.nameOfChamp = nameOfChamp;
    }
}
