package optimization.map;

import optimization.hashmap.chicken.Chicken;
import optimization.hashmap.GenerateUtil;
import optimization.hashmap.MapReduceUtil;
import optimization.hashmap.WeightResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MapAverageTests {

    private static final Logger logger = LogManager.getLogger(MapAverageTests.class);

    private static final int NUM_CHICKENS = 20000000;

    private Long startTime;

    private static List<Chicken> chickens;

    @BeforeEach
    void setStartTime() {
        this.startTime = System.currentTimeMillis();
        logger.info("\t\t\t\tStart time : " + startTime);

    }

    @AfterEach
    void logDuration() {
        long endTime = System.currentTimeMillis();
        logger.info("\t\t\t\tEnd time : " + endTime);
        logger.info("Duration : " + (endTime - startTime));
    }

    @BeforeAll
    static void generateIdentifiers() {
        Set<String> identifiers = GenerateUtil.generateUniqueIdentifiers(NUM_CHICKENS);
        chickens = GenerateUtil.createList(identifiers, Chicken.MAX_AGE);
    }

    @Test
    @Order(value = 1)
    void calculateWeightResultBasic() {
        logger.info("calculateWeightResultBasic");
        List<WeightResult> weightResults = MapReduceUtil.calculateWeightResultBasic(chickens, Chicken.MAX_AGE);
        logger.info(weightResults.toString());
    }

    @Test
    @Order(value = 2)
    void calculateWeightResultGroupByAge() {
        logger.info("calculateWeightResultGroupByAge");
        List<WeightResult> weightResults = MapReduceUtil.calculateWeightResultGroupByBreed(chickens, Chicken.MAX_AGE);
        logger.info(weightResults.toString());
    }

    @Test
    @Order(value = 3)
    void calculateWeightResultReduced() {
        logger.info("calculateWeightResultReduced");
        List<WeightResult> weightResults = MapReduceUtil.calculateWeightResultReduced(chickens, Chicken.MAX_AGE);
        logger.info(weightResults.toString());
    }
}
