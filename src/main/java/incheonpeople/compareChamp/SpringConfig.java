package incheonpeople.compareChamp;

import incheonpeople.compareChamp.repository.ChampRepository;
import incheonpeople.compareChamp.repository.JpaChampRepository;
import incheonpeople.compareChamp.service.ChampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class SpringConfig {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public ChampService champService() {
        return new ChampService(memoryRepository());
    }

    @Bean
    public ChampRepository memoryRepository() {
        return new JpaChampRepository(em);
    }
}
