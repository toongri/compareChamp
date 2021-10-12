package incheonpeople.compareChamp.service;

import incheonpeople.compareChamp.domain.Champ;
import incheonpeople.compareChamp.repository.ChampRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class ChampService {

    private ChampRepository champRepository;

    public ChampService(ChampRepository champRepository) {
        this.champRepository = champRepository;
    }

    public List<Champ> findChamps() {
        return champRepository.findChampsAll();
    }

}
