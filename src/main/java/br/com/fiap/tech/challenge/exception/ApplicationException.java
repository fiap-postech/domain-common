package br.com.fiap.tech.challenge.exception;

import br.com.fiap.tech.challenge.exception.error.BaseApplicationError;

import static br.com.fiap.tech.challenge.util.Strings.formatMessage;

public class ApplicationException extends RuntimeException {

    private final BaseApplicationError error;

    private final Object[] parameters;

    private final Object data;

    public ApplicationException(BaseApplicationError error, Object... parameters) {
        super(formatMessage(error.getDescription(), parameters));
        this.error = error;
        this.parameters = parameters;
        this.data = null;
    }

    public ApplicationException(BaseApplicationError error, Throwable cause, Object... parameters) {
        super(formatMessage(error.getDescription(), parameters), cause);
        this.error = error;
        this.parameters = parameters;
        this.data = null;
    }

    public ApplicationException(Object data, BaseApplicationError error, Object... parameters) {
        super(formatMessage(error.getDescription(), parameters));
        this.error = error;
        this.parameters = parameters;
        this.data = data;
    }

    public ApplicationException(Object data, BaseApplicationError error, Throwable cause, Object... parameters) {
        super(formatMessage(error.getDescription(), parameters), cause);
        this.error = error;
        this.parameters = parameters;
        this.data = data;
    }

    public BaseApplicationError getError() {
        return error;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public Object getData() {
        return data;
    }
}