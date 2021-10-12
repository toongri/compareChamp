package incheonpeople.compareChamp.repository;

import incheonpeople.compareChamp.domain.Champ;

import java.util.List;
import java.util.Optional;

public interface ChampRepository {
    List<Champ> findChampsAll();
}
