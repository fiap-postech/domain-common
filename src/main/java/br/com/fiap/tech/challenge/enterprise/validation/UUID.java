package br.com.fiap.tech.challenge.enterprise.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, CONSTRUCTOR, ANNOTATION_TYPE, TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = UUIDValidator.class)
@Documented
public @interface UUID {
    String message() default "${validatedValue} should be a valid UUID";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    boolean required() default true;
}
