package br.com.fiap.tech.challenge.enterprise.valueobject;

import br.com.fiap.tech.challenge.AssertionConcern;

import java.io.Serial;

public abstract class ValueObject extends AssertionConcern {
    @Serial
    private static final long serialVersionUID = -7416337849677971827L;

    protected ValueObject() {
    }


}
