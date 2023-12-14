package br.com.fiap.tech.challenge.util;

import br.com.fiap.tech.challenge.enterprise.valueobject.Discount;
import br.com.fiap.tech.challenge.enterprise.valueobject.Image;
import br.com.fiap.tech.challenge.enterprise.valueobject.Price;
import br.com.fiap.tech.challenge.enterprise.valueobject.Quantity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.javamoney.moneta.Money;

import java.math.BigDecimal;

import static br.com.fiap.tech.challenge.util.MoneyConstants.CURRENCY_CODE;
import static br.com.fiap.tech.challenge.util.MoneyConstants.CURRENCY_PRECISION;
import static br.com.fiap.tech.challenge.util.MoneyConstants.CURRENCY_ROUNDING_MODE;
import static java.util.Objects.isNull;
import static javax.money.Monetary.getCurrency;
import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Mappings {

    public static BigDecimal priceToBigDecimalConverter(Price source) {
        return defaultIfNull(source, Price.min())
                .amount()
                .getNumberStripped()
                .setScale(CURRENCY_PRECISION, CURRENCY_ROUNDING_MODE);
    }

    public static BigDecimal moneyToBigDecimalConverter(Money source) {
        return defaultIfNull(source, Money.zero(getCurrency(CURRENCY_CODE)))
                .getNumberStripped()
                .setScale(CURRENCY_PRECISION, CURRENCY_ROUNDING_MODE);
    }

    public static BigDecimal discountToBigDecimalConverter(Discount discount) {
        return defaultIfNull(discount, Discount.withoutDiscount())
                .amount()
                .getNumberStripped()
                .setScale(CURRENCY_PRECISION, CURRENCY_ROUNDING_MODE);
    }

    public static String imageToStringConverter(Image source) {
        if (isNull(source)) return null;
        return source.url();
    }

    public static Integer quantityToIntegerConverter(Quantity quantity) {
        return defaultIfNull(quantity, Quantity.min())
                .value();
    }
}
