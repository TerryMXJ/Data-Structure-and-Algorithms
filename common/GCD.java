package common;

/**
 * 求最大公约数
 */

public class GCD {
    
    public static int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b, a%b);
    }
}
