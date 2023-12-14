package br.com.fiap.tech.challenge.enterprise.valueobject;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.javamoney.moneta.Money;

import java.io.Serial;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static br.com.fiap.tech.challenge.util.MoneyConstants.CURRENCY_CODE;

@Getter
@ToString
@Accessors(fluent = true)
public class Percentage extends ValueObject {
    @Serial
    private static final long serialVersionUID = 7913894476812007281L;

    @PositiveOrZero
    @Max(100)
    private final BigDecimal value;

    private Percentage(BigDecimal value) {
        this.value = value;

        validate();
    }

    public Money apply(Money amount) {
        var discountValue = amount
                .getNumber()
                .numberValue(BigDecimal.class)
                .multiply(currentMultiplicand());

        return Money.of(discountValue, CURRENCY_CODE);
    }

    public BigDecimal apply(BigDecimal value) {
        return value.multiply(currentMultiplicand());
    }

    public double apply(double value) {
        return BigDecimal.valueOf(value).multiply(currentMultiplicand()).doubleValue();
    }

    private BigDecimal currentMultiplicand(){
        return value().divide(
                BigDecimal.valueOf(100),
                new MathContext(4, RoundingMode.HALF_UP)
        );
    }

    public static Percentage zero() {
        return of(BigDecimal.ZERO);
    }

    public static Percentage of(double value) {
        return of(BigDecimal.valueOf(value));
    }

    public static Percentage of(BigDecimal value) {
        return new Percentage(value);
    }

}
