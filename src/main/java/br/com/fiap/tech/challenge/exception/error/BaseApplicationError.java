package br.com.fiap.tech.challenge.exception.error;

public interface BaseApplicationError extends BaseError {

    ErrorType getErrorType();

}