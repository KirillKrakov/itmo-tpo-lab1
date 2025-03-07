package software_testing.function;

public class Arcsin {
    public final static int termsCount = 400;
    public static double arcsin(double x) {
        if (x < -1 || x > 1) {
            return Double.NaN;
        }
        double answer = 0;
        for (int n = 0; n < termsCount; n ++) {
            double term = 1 / Math.pow(2, 2 * n) * C(2 * n, n) * Math.pow(x, 2 * n + 1) / (2 * n + 1);
            answer += term;
        }
        return answer;
    }

    // биномиальный коэффициент
    private static long C(int n, int r) {
        if(r > n - r) {
            r = n - r;
        }
        long answer = 1;
        for(int i = 1; i <= r; i++) {
            answer *= n - r + i;
            answer /= i;
        }
        return answer;
    }
}
