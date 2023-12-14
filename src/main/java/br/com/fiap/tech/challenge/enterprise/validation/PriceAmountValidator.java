package br.com.fiap.tech.challenge.enterprise.validation;

import br.com.fiap.tech.challenge.enterprise.valueobject.Price;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static java.util.Objects.isNull;

public class PriceAmountValidator implements ConstraintValidator<PriceAmount, Price> {
    @Override
    public boolean isValid(Price value, ConstraintValidatorContext context) {
        if (isNull(value) || isNull(value.amount())){
            return false;
        }
        return value.amount().isPositiveOrZero();
    }
}