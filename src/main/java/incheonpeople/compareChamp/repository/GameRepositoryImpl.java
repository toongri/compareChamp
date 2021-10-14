package incheonpeople.compareChamp.repository;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import incheonpeople.compareChamp.domain.Champ;
import incheonpeople.compareChamp.domain.GameData;
import incheonpeople.compareChamp.domain.QChamp;
import incheonpeople.compareChamp.dto.NumNamAmtAllDto;
import incheonpeople.compareChamp.dto.NumNamVicPic;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.querydsl.core.types.ExpressionUtils.count;
import static incheonpeople.compareChamp.domain.QChamp.champ;
import static incheonpeople.compareChamp.domain.QGameData.gameData;


@RequiredArgsConstructor    // 의존성 주입
public class GameRepositoryImpl implements GameRepositoryCustom {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GameRepositoryImpl(EntityManager em, DataSource dataSource) {
        this.em = em;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public List<NumNamVicPic> findChampByLane(String lane) {

        List<NumNamAmtAllDto> gameDataList = jpaQueryFactory
                .select(Projections.constructor(NumNamAmtAllDto.class,
                        gameData.championId,
                        gameData.champ.nameOfChamp,
                        gameData.championId.count(),
                        ExpressionUtils.as(
                                JPAExpressions
                                        .select(count(gameData.championId))
                                        .from(gameData)
                                        .where(gameData.lane.eq(lane)),
                                "studentCount")))
                .from(gameData)
                .where(gameData.lane.eq(lane))
                .groupBy(gameData.championId)
                .orderBy(gameData.championId.asc())
                .fetch();

        List<Long> longList = jpaQueryFactory
                .from(gameData)
                .where(gameData.lane.eq(lane).and(gameData.win.eq("True")))
                .groupBy(gameData.championId)
                .select(gameData.championId.count())
                .orderBy(gameData.championId.asc())
                .fetch();


        return makeChampDataByLane(gameDataList, longList);
    }

    @Override
    public List<NumNamVicPic> findChampByFightChamp(Champ champ) {
        //        List<Integer> champIdListByLane = jpaQueryFactory
//                .select(gameData.championId)
//                .distinct()
//                .from(gameData)
//                .where(gameData.lane.eq(lane))
//                .fetch();
//
//        List<ChampDto> gameDataList = jpaQueryFactory
//                .from(gameData)
//                .where(gameData.championId.in(champIdListByLane))
//                .groupBy(gameData.championId)
//                .select(Projections.constructor(ChampDto.class,
//                        gameData.championId,
//                        gameData.championId.count()))
//                .fetch();
        /*
        List<numNWinNLosDto> gameDataList = jpaQueryFactory
                .from(gameData)
                .where(gameData.lane.eq(lane))
                .groupBy(gameData.championId)
                .select(Projections.constructor(numNWinNLosDto.class,
                        gameData.championId,
                        gameData.championId.count(),
                        ExpressionUtils.as(
                                JPAExpressions
                                        .select(count(gameData.championId))
                                        .from(gameData)
                                        .where(gameData.lane.eq(lane).and(gameData.win.eq("True")))
                                        .groupBy(gameData.championId),
                                "studentCount")))
                .orderBy(gameData.championId.asc())
                .fetch();
        */
        return null;
    }

    public List<NumNamVicPic> makeChampDataByLane(List<NumNamAmtAllDto> numNAmountDtos, List<Long> longList) {
        List<NumNamVicPic> numberNVictoryRateList = new ArrayList<>();

        Iterator<NumNamAmtAllDto> iterator1 = numNAmountDtos.iterator();
        Iterator<Long> iterator2 = longList.iterator();
        NumNamAmtAllDto iterate;

        while(iterator1.hasNext() && iterator2.hasNext())
        {
            iterate = iterator1.next();
            numberNVictoryRateList.add(new NumNamVicPic(
                    iterate.getChampNumber(),
                    iterate.getChampName(),
                    (double)iterator2.next()/iterate.getamountOfGame(),
                    (double)iterate.getamountOfGame()/iterate.getAmountOfAllChampGame()* 100));
        }

        return numberNVictoryRateList;
    }
}