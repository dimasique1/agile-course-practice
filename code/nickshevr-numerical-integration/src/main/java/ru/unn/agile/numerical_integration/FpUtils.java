package ru.unn.agile.numerical_integration;

public final class FpUtils {
    private FpUtils() {
        throw new AssertionError("It's static util");
    };

    public static double recursionSum(
            final Expression term,
            final Expression next,
            final double a,
            final double b
    ) {
        if (a > b) {
            return 0;
        }

        return term.execute(a) + FpUtils.recursionSum(term, next, next.execute(a), b);
    };
};
