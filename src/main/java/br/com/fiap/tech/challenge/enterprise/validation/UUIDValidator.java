package br.com.fiap.tech.challenge.enterprise.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static java.util.Objects.isNull;

public class UUIDValidator implements ConstraintValidator<UUID, String> {

    private boolean required;

    @Override
    public void initialize(UUID constraintAnnotation) {
        this.required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (isNull(value) && !this.required) {
            return true;
        }

        try {
            //noinspection ResultOfMethodCallIgnored
            java.util.UUID.fromString(value);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }
}
