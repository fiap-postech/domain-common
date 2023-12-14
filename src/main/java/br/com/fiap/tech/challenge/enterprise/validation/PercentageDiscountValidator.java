package br.com.fiap.tech.challenge.enterprise.validation;

import br.com.fiap.tech.challenge.enterprise.valueobject.Percentage;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.math.BigDecimal;

import static java.util.Objects.isNull;

public class PercentageDiscountValidator implements ConstraintValidator<PercentageDiscount, Percentage> {

    private BigDecimal min;

    private BigDecimal max;

    @Override
    public void initialize(PercentageDiscount constraintAnnotation) {
        min = BigDecimal.valueOf(constraintAnnotation.min());
        max = BigDecimal.valueOf(constraintAnnotation.max());

        validateParameters();
    }

    @Override
    public boolean isValid(Percentage value, ConstraintValidatorContext context) {
        if (isNull(value)){
            return true;
        }

        return min.compareTo(value.value()) < 0 &&
                max.compareTo(value.value()) >= 0;
    }

    private void validateParameters(){
        if (min.longValue() < 0){
            throw new IllegalArgumentException("min value should be at least 0");
        }

        if (max.longValue() < 0){
            throw new IllegalArgumentException("max value should be at least 0");
        }

        if (max.longValue() < min.longValue()) {
            throw new IllegalArgumentException("max value should greater or equal to min value");
        }
    }
}
