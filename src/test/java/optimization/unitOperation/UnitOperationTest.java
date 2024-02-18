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
    void onePlusOne() {
        logger.info("onePlusOne");
        UnitOperationUtils.onePlusOne(BigInteger.valueOf(A));
    }

    @Test
    @Order(value = 2)
    void aBitPlusABit(){
        logger.info("aBitPlusABit");
        UnitOperationUtils.aBitPlusABit(BigInteger.valueOf(A));
    }

    @Test
    @Order(value = 3)
    void aLotPlusALot(){
        logger.info("aLotPlusALot");
        UnitOperationUtils.aLotPlusALot(BigInteger.valueOf(A));
    }
}
