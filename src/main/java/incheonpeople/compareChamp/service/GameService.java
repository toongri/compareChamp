package incheonpeople.compareChamp.service;

import incheonpeople.compareChamp.dto.NumNamVicPic;
import incheonpeople.compareChamp.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<NumNamVicPic> findAll() {
        return gameRepository.findChampByLane("Bot");
    }
}
