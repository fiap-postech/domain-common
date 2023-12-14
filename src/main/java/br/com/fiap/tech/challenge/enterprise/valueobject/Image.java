package br.com.fiap.tech.challenge.enterprise.valueobject;

import br.com.fiap.tech.challenge.enterprise.validation.URL;
import br.com.fiap.tech.challenge.exception.ApplicationException;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import static br.com.fiap.tech.challenge.exception.error.CommonApplicationError.IMAGE_URL_INVALID;

@Accessors(fluent = true)
@Getter
public class Image extends ValueObject {
    @Serial
    private static final long serialVersionUID = -7027977210412190271L;

    @URL
    private final String url;

    private Image(String url) {
        this.url = url;

        validate();
    }

    public java.net.URL toURL() {
        try {
            return new java.net.URL(url);
        } catch (MalformedURLException e) {
            throw new ApplicationException(IMAGE_URL_INVALID);
        }
    }

    public URI toURI() {
        try {
            return toURL().toURI();
        } catch (URISyntaxException e) {
            throw new ApplicationException(IMAGE_URL_INVALID);
        }
    }

    public static Image of(String url) {
        return new Image(url);
    }
}
