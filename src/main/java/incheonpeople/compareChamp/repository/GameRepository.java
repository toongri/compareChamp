package incheonpeople.compareChamp.repository;

import incheonpeople.compareChamp.domain.GameData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<GameData, Long>, GameRepositoryCustom {

}
