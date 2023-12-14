package br.com.fiap.tech.challenge.enterprise.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DomainEventPublisher {
    private static final ThreadLocal<DomainEventPublisher> instance = ThreadLocal.withInitial(DomainEventPublisher::new);

    private boolean publishing;

    @SuppressWarnings("rawtypes")
    private List subscribers;

    public static DomainEventPublisher instance() {
        return instance.get();
    }

    public <T> void publish(final T aDomainEvent) {
        if (!this.isPublishing() && this.hasSubscribers()) {

            try {
                this.setPublishing(true);

                var eventType = aDomainEvent.getClass();

                @SuppressWarnings("unchecked")
                List<DomainEventSubscriber<T>> allSubscribers = this.subscribers();

                for (DomainEventSubscriber<T> subscriber : allSubscribers) {
                    Class<?> subscribedToType = subscriber.subscribedToEventType();

                    if (eventType == subscribedToType || subscribedToType == DomainEvent.class) {
                        subscriber.handle(aDomainEvent);
                    }
                }

            } finally {
                this.setPublishing(false);
            }
        }
    }

    public void publishAll(Collection<DomainEvent> domainEvents) {
        for (var domainEvent : domainEvents) {
            this.publish(domainEvent);
        }
    }

    public void reset() {
        if (!this.isPublishing()) {
            this.setSubscribers(null);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> void subscribe(DomainEventSubscriber<T> subscriber) {
        if (!this.isPublishing()) {
            this.ensureSubscribersList();

            this.subscribers().add(subscriber);
        }
    }

    private DomainEventPublisher() {
        super();

        this.setPublishing(false);
        this.ensureSubscribersList();
    }

    @SuppressWarnings("rawtypes")
    private void ensureSubscribersList() {
        if (!this.hasSubscribers()) {
            this.setSubscribers(new ArrayList());
        }
    }

    private boolean isPublishing() {
        return this.publishing;
    }

    private void setPublishing(boolean publishing) {
        this.publishing = publishing;
    }

    private boolean hasSubscribers() {
        return this.subscribers() != null;
    }

    @SuppressWarnings("rawtypes")
    private List subscribers() {
        return this.subscribers;
    }

    @SuppressWarnings("rawtypes")
    private void setSubscribers(List subscribers) {
        this.subscribers = subscribers;
    }
}
