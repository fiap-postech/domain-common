package br.com.fiap.tech.challenge.enterprise.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class URLValidator implements ConstraintValidator<URL, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            new java.net.URL(value).toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }
    }
}
