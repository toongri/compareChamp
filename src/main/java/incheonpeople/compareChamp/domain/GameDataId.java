package incheonpeople.compareChamp.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import java.io.Serializable;

@Data
@Embeddable
public class GameDataId implements Serializable {
    @Column(name = "GAMEID")
    private long gameId;

    @Column(name = "PARTICIPANTID")
    private int inGameNumber;
}
