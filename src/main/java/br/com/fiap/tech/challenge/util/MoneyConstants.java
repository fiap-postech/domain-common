package br.com.fiap.tech.challenge.util;

import java.math.MathContext;
import java.math.RoundingMode;

public class MoneyConstants {
    private MoneyConstants() {
    }

    public static final String CURRENCY_CODE = "BRL";
    public static final int CURRENCY_PRECISION = 2;
    public static final RoundingMode CURRENCY_ROUNDING_MODE = RoundingMode.HALF_UP;

    public static final MathContext CURRENCY_MATH_CONTEXT = new MathContext(CURRENCY_PRECISION, CURRENCY_ROUNDING_MODE);
}
