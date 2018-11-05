package ru.unn.agile.numerical_integration;

public final class BaseDefinition implements NumericMethod {
    private BaseDefinition() {
        throw new AssertionError("Don't make instance");
    };

    public static double calculate(
            final Expression function,
            final double start,
            final double end,
            final double dx
    ) {
        if (dx < 0) {
            throw new IllegalArgumentException("dx must be gt 0");
        }

        return FpUtils.recursionSum(function, x -> x + dx, start + dx / 2, end) * dx;
    };
};
