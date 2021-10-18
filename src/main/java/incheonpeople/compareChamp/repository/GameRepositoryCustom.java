package incheonpeople.compareChamp.repository;

import incheonpeople.compareChamp.dto.NumNamVicPicDto;
import incheonpeople.compareChamp.dto.NumNamVicPicAmtDto;
import incheonpeople.compareChamp.dto.ForCompareChampDto;

import java.util.List;

public interface GameRepositoryCustom {
    List<NumNamVicPicDto> findChampByLane(String lane);
    List<NumNamVicPicAmtDto> findChampByFightChamp(int championId, String lane);
    List<ForCompareChampDto> findCompareData(int firstChampionId, int secondChampionId, String lane, double vicRate);
}