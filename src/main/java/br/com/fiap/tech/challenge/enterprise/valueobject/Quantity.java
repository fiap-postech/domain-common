package br.com.fiap.tech.challenge.enterprise.valueobject;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serial;

import static java.lang.Math.max;

@Getter
@Accessors(fluent = true)
@ToString
public class Quantity extends ValueObject {
    @Serial
    private static final long serialVersionUID = 5676097435219158623L;

    @Min(0)
    @Max(Integer.MAX_VALUE)
    private final int value;

    private Quantity(int value) {
        this.value = value;

        validate();
    }

    public Quantity increment(){
        return increment(1);
    }

    public Quantity increment(int value){
        return of(value() + value);
    }

    public Quantity decrement(){
        return decrement(1);
    }

    public Quantity decrement(int value){
        return of(max(value() - value, 0));
    }

    public static Quantity of(int value){
        return new Quantity(value);
    }

    public static Quantity min(){
        return Quantity.of(0);
    }
}