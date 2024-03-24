package optimization.power;

import java.math.BigInteger;

public class PowerUtil {

    private PowerUtil(){}

    public static BigInteger powerWithIterativeMultiply(int a, int b) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 0; i < b; i++) {
            result = result.multiply(BigInteger.valueOf(a));
        }
        return result;
    }

    public static BigInteger powerWithMerge(int a, int b) throws Exception {
        BigInteger result = BigInteger.valueOf(a);
        if (b < 0) throw new Exception("Not implemented");
        if (b == 0) {
            return BigInteger.valueOf(1);
        }
        if (b % 2 == 0) {
            result = powerWithMerge(a, b / 2);
            result = result.multiply(result);
        } else {
            result = result.multiply(powerWithMerge(a, b - 1));
        }

        return result;
    }
}
