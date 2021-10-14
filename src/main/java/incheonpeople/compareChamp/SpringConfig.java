package incheonpeople.compareChamp;

import com.querydsl.jpa.impl.JPAQueryFactory;
import incheonpeople.compareChamp.repository.*;
import incheonpeople.compareChamp.service.ChampService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return new ChampService(champRepository());
    }

    @Bean
    public ChampRepository champRepository() {
        return new JpaChampRepository(em);
    }

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(em);
    }
}
