package optimization.map;

import optimization.hashmap.chicken.Chicken;
import optimization.hashmap.GenerateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MapFindTests {

    private static final Logger logger = LogManager.getLogger(MapFindTests.class);

    private static final int NUM_IDENTIFIERS = 1000000;
    private static final int NUM_TO_FIND = 100000;

    private Long startTime;

    private static Set<String> identifiers;
    private static String identifierToFind;
    private static List<Chicken> testList;
    private static TreeMap<String, Chicken> testTreeMap;
    private static HashMap<String, Chicken> testHashMap;


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
        identifiers = GenerateUtil.generateUniqueIdentifiers(NUM_IDENTIFIERS);
        identifierToFind = GenerateUtil.selectRandomIdentifier(identifiers);
    }

    @Test
    @Order(value = 1)
    void generateList() {
        logger.info("generateList");
        testList = GenerateUtil.createList(identifiers);
    }

    @Test
    @Order(value = 2)
    void generateTreeMap() {
        logger.info("generateTreeMap");
        testTreeMap = GenerateUtil.createTreeMap(identifiers);
    }

    @Test
    @Order(value = 3)
    void generateHashMap() {
        logger.info("generateHashMap");
        testHashMap = GenerateUtil.createHashMap(identifiers);
    }

    @Test
    @Order(value = 4)
    void findInList() {
        logger.info("findInList");
        logger.info(testList.stream().filter(chicken -> chicken.getId().equals(identifierToFind)).findFirst().orElseThrow().getId());
    }

    @Test
    @Order(value = 5)
    void findInTreeMap() {
        logger.info("findInTreeMap");
        logger.info(testTreeMap.get(identifierToFind).getId());
    }

    @Test
    @Order(value = 6)
    void findInHashMap() {
        logger.info("findInHashMap");
        logger.info(testHashMap.get(identifierToFind).getId());
    }

    @Test
    @Order(value = 7)
    void findFirst100kInList() {
        logger.info("findFirst100kInList");
        Iterator<String> iterator = identifiers.iterator();
        String id;
        for (int i = 0; i < NUM_TO_FIND && iterator.hasNext(); i++) {
            String value = iterator.next();
            id = testList.stream().filter(c -> c.getId().equals(value)).findFirst().orElseThrow(() -> new NoSuchElementException(value)).getId();
        }
    }

    @Test
    @Order(value = 8)
    void findFirst100kInTreeMap() {
        logger.info("findFirst100kInTreeMap");
        Iterator<String> iterator = identifiers.iterator();
        String id;
        for (int i = 0; i < NUM_TO_FIND && iterator.hasNext(); i++) {
            String value = iterator.next();
            id = testTreeMap.get(value).getId();
        }
    }

    @Test
    @Order(value = 9)
    void findFirst100kInHashMap() {
        logger.info("findFirst100kInHashMap");
        Iterator<String> iterator = identifiers.iterator();
        String id;
        for (int i = 0; i < NUM_TO_FIND && iterator.hasNext(); i++) {
            String value = iterator.next();
            id = testHashMap.get(value).getId();
        }
    }
}
