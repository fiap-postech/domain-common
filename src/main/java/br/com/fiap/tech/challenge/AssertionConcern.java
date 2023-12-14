package br.com.fiap.tech.challenge;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

import static java.util.Objects.nonNull;

public class AssertionConcern implements Serializable {
    @Serial
    private static final long serialVersionUID = -5898477763983021330L;

    protected AssertionConcern(){
    }

    public void validate(){
        var violations = runValidation();

        if (nonNull(violations) && !violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
    }

    public boolean isValid(){
        return runValidation().isEmpty();
    }

    protected Set<ConstraintViolation<AssertionConcern>> runValidation(){
        var factory = Validation.buildDefaultValidatorFactory();
        var validator = factory.getValidator();

        return validator.validate(this);
    }
}
