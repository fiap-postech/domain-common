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
@Constraint(validatedBy = PriceCurrencyValidator.class)
@Documented
public @interface PriceCurrency {
    String message() default "Price should expressed using BRL only";

    Class<?>[] groups () default {};

    Class<? extends Payload>[] payload () default {};
}
