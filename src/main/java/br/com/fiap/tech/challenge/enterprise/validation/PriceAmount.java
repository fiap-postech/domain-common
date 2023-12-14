package br.com.fiap.tech.challenge.enterprise.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PriceAmountValidator.class)
@Documented
public @interface PriceAmount {
    String message() default "Price should be greater than or 0. Found: ${validatedValue}";

    Class<?>[] groups () default {};

    Class<? extends Payload>[] payload () default {};
}