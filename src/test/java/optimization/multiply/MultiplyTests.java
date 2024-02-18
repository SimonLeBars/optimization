package optimization.multiply;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MultiplyTests {

    private static final Logger logger = LogManager.getLogger(MultiplyTests.class);

    private Long startTime;

    private static final int A = Integer.MAX_VALUE;
    private static final int B = Integer.MAX_VALUE / 10;
//    private static final int A = 2;
//    private static final int B = 8;


    private static BigInteger nativeMultiply;

    private static BigInteger multiplyWithIterativeAddition;

    private static BigInteger multiplyWithMerge;

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
    void nativeMultiply() {
        logger.info("nativeMultiply");
        nativeMultiply = BigInteger.valueOf(A).multiply(BigInteger.valueOf(B));
    }

    @Test
    @Order(value = 2)
    void multiplyWithIterativeAddition(){
        logger.info("multiplyWithIterativeAddition");
        multiplyWithIterativeAddition = MultiplyUtils.multiplyWithIterativeAddition(A, B);
    }

    @Test
    @Order(value = 3)
    void multiplyWithMerge() throws Exception {
        logger.info("multiplyWithMerge");
        multiplyWithMerge = MultiplyUtils.multiplyWithMerge(A, B);
    }

    @AfterAll
    static void compareResults() {
//        logger.info("multiplyWithIterativeAddition : \n" + multiplyWithIterativeAddition);
//        logger.info("multiplyWithMerge : \n" + multiplyWithMerge);
        logger.info("multiplyWithIterativeAddition equals nativeMultiply: " + nativeMultiply.equals(multiplyWithIterativeAddition));
        logger.info("multiplyWithMerge equals nativeMultiply: " + nativeMultiply.equals(multiplyWithMerge));
    }
}
