package optimization.power;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PowerTests {

    private static final Logger logger = LogManager.getLogger(PowerTests.class);

    private Long startTime;

    private static final int A = 1000001;
    private static final int B = 100001;
//    private static final int A = 2;
//    private static final int B = 8;


    private static BigInteger nativePower;

    private static BigInteger powerWithIterativeMultiply;

    private static BigInteger powerWithMerge;

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
    void nativePower() {
        logger.info("nativePower");
        nativePower = BigInteger.valueOf(A).pow(B);
    }

    @Test
    @Order(value = 2)
    void powerWithIterativeMultiply(){
        logger.info("powerWithIterativeMultiply");
        powerWithIterativeMultiply = PowerUtils.powerWithIterativeMultiply(A, B);
    }

    @Test
    @Order(value = 3)
    void powerWithMerge() throws Exception {
        logger.info("powerWithMerge");
        powerWithMerge = PowerUtils.powerWithMerge(A, B);
    }

    @AfterAll
    static void compareResults() {
//        logger.info("powerWithIterativeMultiply : \n" + powerWithIterativeMultiply);
//        logger.info("powerWithMerge : \n" + powerWithMerge);
        logger.info("powerWithIterativeMultiply equals nativePower: " + nativePower.equals(powerWithIterativeMultiply));
        logger.info("powerWithMerge equals nativePower: " + nativePower.equals(powerWithMerge));
    }
}
