package optimization.unitOperation;

import java.math.BigInteger;

public class UnitOperationUtils {

    public static final int ONE = 1;

    public static final int A_BIT = 10;

    public static final int A_LOT = 100000000;

    public static void onePlusOne(BigInteger iterationNumber) {
        for (int i = 0; BigInteger.valueOf(i).compareTo(iterationNumber) <= 0; i++) {
            int a = ONE+ONE;
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
