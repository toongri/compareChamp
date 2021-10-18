package incheonpeople.compareChamp.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "data_solo_rank")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GameData {

    @EmbeddedId
    private GameDataId gameDataId;

    private int duration;
    private double version;


    @ManyToOne(targetEntity = Champ.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "CHAMP_CHAMPIONID")
    private Champ champ;

    private String lane;
    private String side;
    private String win;

    @Column(name = "DAMAGEDEALT")
    private int damageDealt;

    @Column(name = "DAMAGETAKEN")
    private int damageTaken;

    private int gold;
    private int kills;
    private int deaths;
    private int assists;
    private int G5;
    private int G6;
    private int G7;
    private int G8;
    private int G9;
    private int G10;
    private int G11;
    private int G12;
    private int G13;
    private int G14;
    private int G15;
    private int G16;
    private int G17;
    private int G18;
    private int G19;
    private int G20;
    private int G21;
    private int G22;
    private int G23;
    private int G24;
    private int G25;
    private int G26;
    private int G27;
    private int G28;
    private int G29;
    private int G30;

    public GameData(GameDataId gameDataId, int duration, double version, Champ champ, String lane, String side, String win, int damageDealt, int damageTaken, int gold, int kills, int deaths, int assists, int g5, int g6, int g7, int g8, int g9, int g10, int g11, int g12, int g13, int g14, int g15, int g16, int g17, int g18, int g19, int g20, int g21, int g22, int g23, int g24, int g25, int g26, int g27, int g28, int g29, int g30) {
        this.gameDataId = gameDataId;
        this.duration = duration;
        this.version = version;
        this.lane = lane;
        this.side = side;
        this.win = win;
        this.damageDealt = damageDealt;
        this.damageTaken = damageTaken;
        this.gold = gold;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        G5 = g5;
        G6 = g6;
        G7 = g7;
        G8 = g8;
        G9 = g9;
        G10 = g10;
        G11 = g11;
        G12 = g12;
        G13 = g13;
        G14 = g14;
        G15 = g15;
        G16 = g16;
        G17 = g17;
        G18 = g18;
        G19 = g19;
        G20 = g20;
        G21 = g21;
        G22 = g22;
        G23 = g23;
        G24 = g24;
        G25 = g25;
        G26 = g26;
        G27 = g27;
        G28 = g28;
        G29 = g29;
        G30 = g30;
        this.champ = champ;
    }

    public GameDataId getGameDataId() {
        return gameDataId;
    }

    public void setGameDataId(GameDataId gameDataId) {
        this.gameDataId = gameDataId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public int getDamageDealt() {
        return damageDealt;
    }

    public void setDamageDealt(int damageDealt) {
        this.damageDealt = damageDealt;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(int damageTaken) {
        this.damageTaken = damageTaken;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getG5() {
        return G5;
    }

    public void setG5(int g5) {
        G5 = g5;
    }

    public int getG6() {
        return G6;
    }

    public void setG6(int g6) {
        G6 = g6;
    }

    public int getG7() {
        return G7;
    }

    public void setG7(int g7) {
        G7 = g7;
    }

    public int getG8() {
        return G8;
    }

    public void setG8(int g8) {
        G8 = g8;
    }

    public int getG9() {
        return G9;
    }

    public void setG9(int g9) {
        G9 = g9;
    }

    public int getG10() {
        return G10;
    }

    public void setG10(int g10) {
        G10 = g10;
    }

    public int getG11() {
        return G11;
    }

    public void setG11(int g11) {
        G11 = g11;
    }

    public int getG12() {
        return G12;
    }

    public void setG12(int g12) {
        G12 = g12;
    }

    public int getG13() {
        return G13;
    }

    public void setG13(int g13) {
        G13 = g13;
    }

    public int getG14() {
        return G14;
    }

    public void setG14(int g14) {
        G14 = g14;
    }

    public int getG15() {
        return G15;
    }

    public void setG15(int g15) {
        G15 = g15;
    }

    public int getG16() {
        return G16;
    }

    public void setG16(int g16) {
        G16 = g16;
    }

    public int getG17() {
        return G17;
    }

    public void setG17(int g17) {
        G17 = g17;
    }

    public int getG18() {
        return G18;
    }

    public void setG18(int g18) {
        G18 = g18;
    }

    public int getG19() {
        return G19;
    }

    public void setG19(int g19) {
        G19 = g19;
    }

    public int getG20() {
        return G20;
    }

    public void setG20(int g20) {
        G20 = g20;
    }

    public int getG21() {
        return G21;
    }

    public void setG21(int g21) {
        G21 = g21;
    }

    public int getG22() {
        return G22;
    }

    public void setG22(int g22) {
        G22 = g22;
    }

    public int getG23() {
        return G23;
    }

    public void setG23(int g23) {
        G23 = g23;
    }

    public int getG24() {
        return G24;
    }

    public void setG24(int g24) {
        G24 = g24;
    }

    public int getG25() {
        return G25;
    }

    public void setG25(int g25) {
        G25 = g25;
    }

    public int getG26() {
        return G26;
    }

    public void setG26(int g26) {
        G26 = g26;
    }

    public int getG27() {
        return G27;
    }

    public void setG27(int g27) {
        G27 = g27;
    }

    public int getG28() {
        return G28;
    }

    public void setG28(int g28) {
        G28 = g28;
    }

    public int getG29() {
        return G29;
    }

    public void setG29(int g29) {
        G29 = g29;
    }

    public int getG30() {
        return G30;
    }

    public Champ getChamp() {
        return champ;
    }

    public void setChamp(Champ champ) {
        this.champ = champ;
    }

    public void setG30(int g30) {
        G30 = g30;
    }
}
