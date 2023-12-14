package br.com.fiap.tech.challenge.enterprise.entity;

public interface DomainEventSubscriber<T> {
    void handle(final T event);
    Class<T> subscribedToEventType();
}
