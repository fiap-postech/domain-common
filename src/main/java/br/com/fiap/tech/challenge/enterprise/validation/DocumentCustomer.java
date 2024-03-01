package br.com.fiap.tech.challenge.enterprise.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({PARAMETER,FIELD, CONSTRUCTOR, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = DocumentValidator.class)
@Documented
public @interface DocumentCustomer {

    String message() default "The provided document is invalid";

    boolean required() default true;

    Class<?>[] groups () default {};

    Class<? extends Payload>[] payload () default {};
}
