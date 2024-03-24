package optimization.multiply;

import java.math.BigInteger;

public class MultiplyUtil {

    private MultiplyUtil(){}

    public static BigInteger multiplyWithIterativeAddition(int a, int b) {
        BigInteger result = BigInteger.valueOf(a);
        for (int i = 1; i < b; i++) {
            result = result.add(BigInteger.valueOf(a));
        }
        return result;
    }

    public static BigInteger multiplyWithMerge(int a, int b) throws Exception {
        BigInteger result = BigInteger.valueOf(a);
        if (b < 1) throw new Exception("Not implemented");
        if (b == 1) {
            return BigInteger.valueOf(a);
        }
        if (b % 2 == 0) {
            result = multiplyWithMerge(a, b / 2);
            result = result.add(result);
        } else {
            result = result.add(multiplyWithMerge(a, b - 1));
        }

        return result;
    }
}
