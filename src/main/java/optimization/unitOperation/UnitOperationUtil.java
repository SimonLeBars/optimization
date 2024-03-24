package optimization.unitOperation;

import java.math.BigInteger;

public class UnitOperationUtil {

    private UnitOperationUtil(){}

    public static final int ONE = 1;
    public static final int A_BIT = 10;
    public static final int A_LOT = 100000000;

    public static void basicLoop(BigInteger iterationNumber) {
        int i = 0;
        while (BigInteger.valueOf(i).compareTo(iterationNumber) <= 0) {
            i++;
        }
    }

    public static void loopWithAddition(BigInteger iterationNumber) {
        int i = 0;
        int a = 0;
        while (BigInteger.valueOf(i).compareTo(iterationNumber) <= 0) {
            i++;
            a = ONE + ONE;
        }
    }

    public static void onePlusOneTwoTimes(BigInteger iterationNumber) {
        for (int i = 0; BigInteger.valueOf(i).compareTo(iterationNumber) <= 0; i++) {
            int a = ONE+ONE;
            int b = ONE+ONE;
        }
    }

    public static void aBitPlusABit(BigInteger iterationNumber) {
        for (int i = 0; BigInteger.valueOf(i).compareTo(iterationNumber) <= 0; i++) {
            int a = A_BIT+A_BIT;
        }
    }

    public static void aLotPlusALot(BigInteger iterationNumber) {
        for (int i = 0; BigInteger.valueOf(i).compareTo(iterationNumber) <= 0; i++) {
            int a = A_LOT+A_LOT;
        }
    }
}
