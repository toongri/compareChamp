package incheonpeople.compareChamp.service;

import incheonpeople.compareChamp.dto.NumNamVicPicDto;
import incheonpeople.compareChamp.dto.NumNamVicPicAmtDto;
import incheonpeople.compareChamp.dto.ForCompareChampDto;
import incheonpeople.compareChamp.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<NumNamVicPicDto> findByLane(String lane) {
        return gameRepository.findChampByLane(lane);
    }

    public List<NumNamVicPicAmtDto> findByChamp(int championId, String lane) {
        return gameRepository.findChampByFightChamp(championId, lane);
    }

    public List<ForCompareChampDto> compareByChamp(int firstChampId, int secondChampionId, String lane, double vicRate) {
        return gameRepository.findCompareData(firstChampId, secondChampionId, lane, vicRate);
    }
}
