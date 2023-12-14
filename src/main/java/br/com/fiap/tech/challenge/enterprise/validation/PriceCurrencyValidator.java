package br.com.fiap.tech.challenge.enterprise.validation;

import br.com.fiap.tech.challenge.enterprise.valueobject.Price;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static br.com.fiap.tech.challenge.util.MoneyConstants.CURRENCY_CODE;
import static java.util.Objects.isNull;

public class PriceCurrencyValidator implements ConstraintValidator<PriceCurrency, Price> {
    @Override
    public boolean isValid(Price value, ConstraintValidatorContext context) {
        if (isNull(value) || isNull(value.amount())){
            return false;
        }
        return CURRENCY_CODE.equals(value.amount().getCurrency().getCurrencyCode());
    }
}