package br.com.fiap.tech.challenge.enterprise.entity;

import java.time.LocalDateTime;

public interface DomainEvent {
    int version();
    LocalDateTime occurredOn();
}
