package incheonpeople.compareChamp.repository;

import incheonpeople.compareChamp.domain.Champ;
import incheonpeople.compareChamp.dto.NumNamVicPic;

import java.util.List;

public interface GameRepositoryCustom {
    List<NumNamVicPic> findChampByLane(String lane);
    List<NumNamVicPic> findChampByFightChamp(Champ champ);
}
