package br.com.fiap.tech.challenge.enterprise.valueobject;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.javamoney.moneta.Money;

import java.io.Serial;

import static br.com.fiap.tech.challenge.util.MoneyConstants.CURRENCY_CODE;
import static javax.money.Monetary.getCurrency;

@Getter
@Accessors(fluent = true)
@ToString
public class Discount extends ValueObject {
    @Serial
    private static final long serialVersionUID = -4877668256672282598L;

    @PositiveOrZero
    private final Money amount;

    private Discount(Money amount) {
        this.amount = amount;

        validate();
    }

    public Discount reset(){
        return withoutDiscount();
    }

    public static Discount of(Money amount){
        return new Discount(amount);
    }

    public static Discount withoutDiscount() {
        return of(Money.zero(getCurrency(CURRENCY_CODE)));
    }

    public Discount multiply(Quantity quantity) {
        return of(amount().multiply(quantity.value()));
    }
}
