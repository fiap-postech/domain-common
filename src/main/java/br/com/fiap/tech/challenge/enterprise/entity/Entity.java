package br.com.fiap.tech.challenge.enterprise.entity;

import br.com.fiap.tech.challenge.AssertionConcern;

import java.io.Serial;
import java.util.UUID;
import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;


public abstract class Entity extends AssertionConcern {
    @Serial
    private static final long serialVersionUID = -4512991976943294994L;

    private final UUID uuid;

    protected Entity(UUID uuid) {
        this.uuid = defaultIfNull(uuid, UUID.randomUUID());
    }

    public UUID uuid(){
        return uuid;
    }
}
