package util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author zhengkai
 * @Date 2022/12/21 9:20
 */
public class BigDecimalUtils {

    /**
     * 计算 a / b，保留两位小数 拉拉hahaaaabcdabc
     * @param a
     * @param b
     * @param roundingMode 舍取模式
     * @return
     */
    public static BigDecimal divide(long a, long b, RoundingMode roundingMode) {
        BigDecimal result;
        if (b == 0 && a != 0) {
            result = new BigDecimal("100.00");
        } else if (b == 0) {
            result = new BigDecimal("0.00");
        } else {
            BigDecimal aBig = new BigDecimal(a);
            BigDecimal bBig = new BigDecimal(b);
            result = aBig
                    .divide(bBig, 4, roundingMode)
                    .multiply(new BigDecimal(100)).setScale( 2, roundingMode);
        }
        return result;
    }

    /**
     * 计算 a / b，保留两位小数
     * @param a
     * @param b
     * @param roundingMode 舍取模式
     * @return
     */
    public static BigDecimal divide(BigDecimal a, BigDecimal b, RoundingMode roundingMode) {
        BigDecimal result;
        if (b.intValue() == 0 && a.intValue() != 0) {
            result = new BigDecimal("100.00");
        } else if (b.toString().equals(a.toString())) {
            result = new BigDecimal("0.00");
        } else {
            result = a.divide(b, 4, roundingMode)
                    .multiply(new BigDecimal(100)).setScale( 2, roundingMode);
        }
        return result;
    }

    /**
     * 计算 (a - b) / b，保留两位小数
     * @param a
     * @param b
     * @param roundingMode 舍取模式
     * @return
     */
    public static BigDecimal growRate(long a, long b, RoundingMode roundingMode) {
        BigDecimal result;
        if (a == b) {
            result = new BigDecimal("0.00");
        } else if (b == 0) {
            result = new BigDecimal("100.00");
        } else {
            BigDecimal aBig = new BigDecimal(a);
            BigDecimal bBig = new BigDecimal(b);
            result = aBig.subtract(bBig)
                    .divide(bBig, 4, roundingMode)
                    .multiply(new BigDecimal(100)).setScale( 2, roundingMode);
        }
        return result;
    }

}
