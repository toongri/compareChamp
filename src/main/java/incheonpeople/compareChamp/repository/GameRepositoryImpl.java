package incheonpeople.compareChamp.repository;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import incheonpeople.compareChamp.dto.*;
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
    @Autowired
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
    public List<NumNamVicPicDto> findChampByLane(String lane) {

        List<NumNamAmtAllDto> gameDataList = jpaQueryFactory
                .select(Projections.constructor(NumNamAmtAllDto.class,
                        gameData.champ.championId,
                        champ.nameOfChamp,
                        gameData.champ.championId.count(),
                        ExpressionUtils.as(
                                JPAExpressions
                                        .select(count(gameData.champ.championId))
                                        .from(gameData)
                                        .where(gameData.lane.eq(lane)),
                                "amountOfAllGame")))
                .from(gameData)
                .join(gameData.champ, champ)
                .where(gameData.lane.eq(lane))
                .groupBy(gameData.champ.championId, champ.nameOfChamp)
                .orderBy(gameData.champ.championId.asc())
                .fetch();
        List<NumVicamtDto> dataAbtWin = jpaQueryFactory
                .select(Projections.constructor(NumVicamtDto.class,
                        gameData.champ.championId,
                        gameData.champ.championId.count()))
                .from(gameData)
                .join(gameData.champ, champ)
                .where(gameData.lane.eq(lane).and(gameData.win.eq("True")))
                .groupBy(gameData.champ.championId)
                .orderBy(gameData.champ.championId.asc())
                .fetch();


        //return makeChampDataByLane(gameDataList, longList);
        return makeChampDataByLane(gameDataList, dataAbtWin);
    }

    @Override
    public List<NumNamVicPicAmtDto> findChampByFightChamp(int championId, String lane) {

        List<NumNamAmtAllDto> gameDataList = jpaQueryFactory
                .select(Projections.constructor(NumNamAmtAllDto.class,
                        gameData.champ.championId,
                        champ.nameOfChamp,
                        gameData.champ.championId.count(),
                        ExpressionUtils.as(
                                JPAExpressions
                                        .select(count(gameData.champ.championId))
                                        .from(gameData)
                                        .where(gameData.gameDataId.gameId.in(
                                                        JPAExpressions
                                                                .select(gameData.gameDataId.gameId)
                                                                .distinct()
                                                                .from(gameData)
                                                                .where(gameData.lane.eq(lane)
                                                                        .and(gameData.champ.championId.eq(championId))))
                                                .and(gameData.lane.eq(lane)
                                                        .and(gameData.champ.championId.ne(championId)))),
                                "amountOfAllGame")))
                .from(gameData)
                .join(gameData.champ, champ)
                .where(gameData.gameDataId.gameId.in(
                        JPAExpressions
                                .select(gameData.gameDataId.gameId)
                                .distinct()
                                .from(gameData)
                                .where(gameData.lane.eq(lane)
                                        .and(gameData.champ.championId.eq(championId))))
                        .and(gameData.lane.eq(lane)
                            .and(gameData.champ.championId.ne(championId))))
                .groupBy(gameData.champ.championId, champ.nameOfChamp)
                .orderBy(gameData.champ.championId.asc())
                .fetch();

        List<NumVicamtDto> dataAbtWin = jpaQueryFactory
                .select(Projections.constructor(NumVicamtDto.class,
                                gameData.champ.championId,
                                gameData.champ.championId.count()))
                .from(gameData)
                .join(gameData.champ, champ)
                .where(gameData.gameDataId.gameId.in(
                                JPAExpressions
                                        .select(gameData.gameDataId.gameId)
                                        .distinct()
                                        .from(gameData)
                                        .where(gameData.lane.eq(lane).and(gameData.champ.championId.eq(championId))))
                        .and(gameData.lane.eq(lane)
                                .and(gameData.champ.championId.ne(championId))
                                    .and(gameData.win.eq("True"))))
                .groupBy(gameData.champ.championId, champ.nameOfChamp)
                .orderBy(gameData.champ.championId.asc())
                .fetch();

        return makeChampDataByChamp(gameDataList, dataAbtWin);
    }

    @Override
    public List<ForCompareChampDto> findCompareData(int firstChampionId, int secondChampionId, String lane, double vicRate) {
        List<NumNamKDADamDto> gameDataList = jpaQueryFactory
                .select(Projections.constructor(NumNamKDADamDto.class,
                        gameData.champ.championId,
                        champ.nameOfChamp,
                        gameData.kills.sum(),
                        gameData.deaths.sum(),
                        gameData.assists.sum(),
                        gameData.damageDealt.avg()))
                .from(gameData)
                .join(gameData.champ, champ)
                .where(gameData.lane.eq(lane)
                        .and((gameData.champ.championId.eq(firstChampionId)
                                .or(gameData.champ.championId.eq(secondChampionId)))
                                .and(gameData.gameDataId.gameId.in(
                                        JPAExpressions
                                                .select(gameData.gameDataId.gameId)
                                                .distinct()
                                                .from(gameData)
                                                .where(gameData.lane.eq(lane).and(gameData.champ.championId.eq(firstChampionId)))))))
                .groupBy(gameData.champ.championId, champ.nameOfChamp)
                .fetch();
        swapList(gameDataList, firstChampionId);
        return makeCompareDataByChamp(gameDataList, vicRate);
    }
    public void swapList(List<NumNamKDADamDto> list, int firstChampionId) {
        if (list.get(0).getChampNumber() != firstChampionId) {
            NumNamKDADamDto temp = list.get(0);
            list.remove(0);
            list.add(temp);
        }
    }

    private List<ForCompareChampDto> makeCompareDataByChamp(List<NumNamKDADamDto> gameDataList, double vicRate) {
        List<ForCompareChampDto> toUserList = new ArrayList<>();
        Iterator<NumNamKDADamDto> iterator = gameDataList.iterator();
        NumNamKDADamDto iterate;
        double vicRateCompare;

        while (iterator.hasNext()) {
            iterate = iterator.next();
            vicRateCompare = iterator.hasNext()? vicRate : 1- vicRate;
            toUserList.add(new ForCompareChampDto(iterate.getChampNumber(),
                    iterate.getChampName(),
                    (double) (iterate.getKill() + iterate.getAssist()) / iterate.getDeath(),
                    iterate.getDamageDealt(), vicRateCompare));
        }

        return toUserList;
    }

    public List<NumNamVicPicAmtDto> makeChampDataByChamp(List<NumNamAmtAllDto> numNAmountDtos, List<NumVicamtDto> dataAbtWin) {
        List<NumNamVicPicAmtDto> numberNVictoryRateList = new ArrayList<>();
        Iterator<NumNamAmtAllDto> iterator1 = numNAmountDtos.iterator();
        Iterator<NumVicamtDto> iterator2 = dataAbtWin.iterator();
        NumNamAmtAllDto iterate1;
        NumVicamtDto iterate2 = null;
        Long amountOfGame1, amountOfGame2;
        boolean isListCorrect = true;

        while(iterator1.hasNext() && iterator2.hasNext())
        {
            iterate1 = iterator1.next();
            if(isListCorrect)
                iterate2 = iterator2.next();

            amountOfGame1 = iterate1.getamountOfGame();
            if(iterate1.getChampNumber().compareTo(iterate2.getChampNumber()) == 0){
                amountOfGame2 = iterate2.getAmountOfVictoryGame();
                isListCorrect = true;
            } else{
                isListCorrect = false;
                amountOfGame2 = 0L;
            }
            if(amountOfGame1 < 50){
                continue;
            }
            numberNVictoryRateList.add(new NumNamVicPicAmtDto(
                    iterate1.getChampNumber(),
                    iterate1.getChampName(),
                    (double)amountOfGame2/amountOfGame1,
                    (double)iterate1.getamountOfGame()/iterate1.getAmountOfAllChampGame(),
                    amountOfGame1)
            );
        }

        return numberNVictoryRateList;
    }

    public List<NumNamVicPicDto> makeChampDataByLane(List<NumNamAmtAllDto> numNAmountDtos, List<NumVicamtDto> dataAbtWin) {
        List<NumNamVicPicDto> numberNVictoryRateList = new ArrayList<>();

        Iterator<NumNamAmtAllDto> iterator1 = numNAmountDtos.iterator();
        Iterator<NumVicamtDto> iterator2 = dataAbtWin.iterator();
        NumNamAmtAllDto iterate1;
        NumVicamtDto iterate2 = null;
        boolean isListCorrect = true;
        Long amountOfGame1, amountOfGame2;

        while(iterator1.hasNext() && iterator2.hasNext())
        {
            iterate1 = iterator1.next();
            if(isListCorrect)
                iterate2 = iterator2.next();

            amountOfGame1 = iterate1.getamountOfGame();
            if(iterate1.getChampNumber().compareTo(iterate2.getChampNumber()) == 0){
                amountOfGame2 = iterate2.getAmountOfVictoryGame();
                isListCorrect = true;
            } else{
                isListCorrect = false;
                amountOfGame2 = 0L;
            }
            if(amountOfGame1 < 200){
                continue;
            }
            System.out.println(iterate1.getChampNumber()+" " + iterate2.getChampNumber());
            numberNVictoryRateList.add(new NumNamVicPicDto(
                    iterate1.getChampNumber(),
                    iterate1.getChampName(),
                    cutTwoDot((double)amountOfGame2/amountOfGame1),
                    cutTwoDot((double)amountOfGame1/iterate1.getAmountOfAllChampGame())));
        }

        return numberNVictoryRateList;
    }

    public double cutTwoDot(double a) {
        return a;
    }
}