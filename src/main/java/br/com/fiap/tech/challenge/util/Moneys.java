package br.com.fiap.tech.challenge.util;

import org.javamoney.moneta.Money;

import java.math.BigDecimal;

import static java.util.Objects.isNull;
import static javax.money.Monetary.getCurrency;

public class Moneys {

    private Moneys() {
    }

    public static Money makeMoney(double value) {
        return Money.of(value, MoneyConstants.CURRENCY_CODE);
    }

    public static Money makeMoney(BigDecimal value){
        return isNull(value) ? Moneys.zero() : Money.of(value, MoneyConstants.CURRENCY_CODE);
    }

    public static Money zero(){
        return Money.zero(getCurrency(MoneyConstants.CURRENCY_CODE));
    }
}