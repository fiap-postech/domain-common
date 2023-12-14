package br.com.fiap.tech.challenge.exception.error;

import static br.com.fiap.tech.challenge.exception.error.ErrorType.INTERNAL_SERVER_ERROR;
import static br.com.fiap.tech.challenge.exception.error.ErrorType.INVALID_PARAMETER;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public enum CommonApplicationError implements BaseApplicationError {

    GENERIC_ERROR("CE-001", INTERNAL_SERVER_ERROR, TRUE, "Unexpected error ({})"),
    CONSTRAINT_VIOLATION("CE-002", INVALID_PARAMETER, FALSE, "Constraint violation"),
    INVALID_PARAMETERS("CE-003", INVALID_PARAMETER, FALSE, "Invalid arguments"),
    IMAGE_URL_INVALID("CE-004", INVALID_PARAMETER, FALSE, "Image has invalid url"),
    ;

    private final String code;
    private final String description;
    private final ErrorType errorType;
    private final boolean acceptParameters;

    CommonApplicationError(String code, ErrorType errorType, boolean acceptParameters, String description) {
        this.code = code;
        this.description = description;
        this.errorType = errorType;
        this.acceptParameters = acceptParameters;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public ErrorType getErrorType() {
        return errorType;
    }

    @Override
    public boolean getAcceptParameters() {
        return acceptParameters;
    }
}