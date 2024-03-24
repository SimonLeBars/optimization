package optimization.unitOperation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UnitOperationTest {

    private static final Logger logger = LogManager.getLogger(UnitOperationTest.class);

    private Long startTime;

    private static final int A = Integer.MAX_VALUE / 10;

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

    @Test
    @Order(value = 1)
    void init() {
        logger.info("init");
        UnitOperationUtil.basicLoop(BigInteger.valueOf(A));
    }

    @Test
    @Order(value = 2)
    void basicLoop() {
        logger.info("basicLoop");
        UnitOperationUtil.basicLoop(BigInteger.valueOf(A));
    }

    @Test
    @Order(value = 3)
    void basicLoopTwoTimes() {
        logger.info("basicLoopTwoTimes");
        UnitOperationUtil.basicLoop(BigInteger.valueOf(A));
        UnitOperationUtil.basicLoop(BigInteger.valueOf(A));
    }

    @Test
    @Order(value = 4)
    void basicLoopTwiceLonger() {
        logger.info("basicLoopTwiceLonger");
        UnitOperationUtil.basicLoop(BigInteger.valueOf(A+A));
    }

    @Test
    @Order(value = 5)
    void loopWithAddition() {
        logger.info("loopWithAddition");
        UnitOperationUtil.loopWithAddition(BigInteger.valueOf(A));
    }

    @Test
    @Order(value = 6)
    void loopWithAdditionTwoTimes() {
        logger.info("loopWithAddition");
        UnitOperationUtil.loopWithAddition(BigInteger.valueOf(A));
        UnitOperationUtil.loopWithAddition(BigInteger.valueOf(A));
    }

    @Test
    @Order(value = 7)
    void aBitPlusABit(){
        logger.info("aBitPlusABit");
        UnitOperationUtil.aBitPlusABit(BigInteger.valueOf(A));
    }

    @Test
    @Order(value = 8)
    void aLotPlusALot(){
        logger.info("aLotPlusALot");
        UnitOperationUtil.aLotPlusALot(BigInteger.valueOf(A));
    }
}
