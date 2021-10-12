package incheonpeople.compareChamp.repository;

import incheonpeople.compareChamp.domain.Champ;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Configuration
public class JpaChampRepository implements ChampRepository{

    @PersistenceContext
    private EntityManager em;

    public JpaChampRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Champ> findChampsAll() {
        return em.createQuery("select m from Champ m ", Champ.class)
                .getResultList();
    }
}
