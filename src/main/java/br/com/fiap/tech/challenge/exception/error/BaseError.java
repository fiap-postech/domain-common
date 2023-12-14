package br.com.fiap.tech.challenge.exception.error;

public interface BaseError {

    String getCode();

    String getDescription();

    boolean getAcceptParameters();
}