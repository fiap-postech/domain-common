package br.com.fiap.tech.challenge.enterprise.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, CONSTRUCTOR, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PercentageDiscountValidator.class)
@Documented
public @interface PercentageDiscount {
    String message() default "Percentage discount should be between {min}% and {max}%";

    long min() default 0;

    long max() default 50;

    Class<?>[] groups () default {};

    Class<? extends Payload>[] payload () default {};
}
