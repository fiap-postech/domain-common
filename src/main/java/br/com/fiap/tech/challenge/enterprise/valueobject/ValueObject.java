package br.com.fiap.tech.challenge.enterprise.valueobject;

import br.com.fiap.tech.challenge.AssertionConcern;

import java.io.Serial;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

public abstract class ValueObject extends AssertionConcern {
    @Serial
    private static final long serialVersionUID = -7416337849677971827L;

    protected ValueObject() {
    }

    @Override
    public boolean equals(Object obj) {
        return reflectionEquals(this, obj, true);
    }

    @Override
    public int hashCode() {
        return reflectionHashCode(this, true);
    }
}
