package incheonpeople.compareChamp.repository;

import incheonpeople.compareChamp.domain.Champ;

import java.util.List;

public interface GameRepository {
    List<Champ> findChampByLane(String lane);
    List<Champ> findChampByFightChamp(Champ champ);

}
