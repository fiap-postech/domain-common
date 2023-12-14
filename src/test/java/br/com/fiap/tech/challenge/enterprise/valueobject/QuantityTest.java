package br.com.fiap.tech.challenge.enterprise.valueobject;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class QuantityTest {

    @Test
    void testErrorWhereAmountIsNegative() {
        assertThatThrownBy(() -> Quantity.of(-1))
                .isInstanceOf(ConstraintViolationException.class)
                .hasMessage("value: must be greater than or equal to 0");
    }

    @Test
    void testMinQuantity() {
        var quantity = Quantity.min();

        assertThat(quantity.value()).isZero();
    }

    @Test
    void testQuantityIncrement() {
        var quantity = Quantity.min();
        var result = quantity.increment();

        assertThat(result.value()).isEqualTo(1);

        result = result.increment(2);
        assertThat(result.value()).isEqualTo(3);
    }

    @Test
    void testQuantityDecrement() {
        var quantity = Quantity.of(5);
        var result = quantity.decrement();

        assertThat(result.value()).isEqualTo(4);

        result = result.decrement(2);
        assertThat(result.value()).isEqualTo(2);
    }

    @Test
    void testQuantityDecrementWhenValueIsZero() {
        var quantity = Quantity.min();
        var result = quantity.decrement();

        assertThat(result.value()).isZero();
    }
}
