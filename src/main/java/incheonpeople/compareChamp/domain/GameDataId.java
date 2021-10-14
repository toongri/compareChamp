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

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public int getInGameNumber() {
        return inGameNumber;
    }

    public void setInGameNumber(int inGameNumber) {
        this.inGameNumber = inGameNumber;
    }

    @Column(name = "PARTICIPANTID")
    private int inGameNumber;
}
