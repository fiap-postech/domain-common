package br.com.fiap.tech.challenge.enterprise.valueobject;

import br.com.fiap.tech.challenge.util.Moneys;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DiscountTest {

    @Test
    void testWithoutDiscount() {
        var discount = Discount.withoutDiscount();

        assertThat(discount.amount()).isEqualTo(Moneys.zero());
    }

    @Test
    void testMultiply() {
        var discount = Discount.of(Moneys.makeMoney(10.00));
        var quantity = Quantity.of(2);

        var result = discount.multiply(quantity);

        assertThat(result.amount()).isEqualTo(Moneys.makeMoney(20.00));
    }

    @Test
    void testReset() {
        var discount = Discount.of(Moneys.makeMoney(10.00));

        var result = discount.reset();

        assertThat(result.amount()).isEqualTo(Moneys.zero());
    }

    @Test
    void testErrorWhenDiscountIsNegative() {
        var negativeValue = Moneys.makeMoney(-10);

        assertThatThrownBy(() -> Discount.of(negativeValue))
                .isInstanceOf(ConstraintViolationException.class)
                .hasMessage("amount: must be greater than or equal to 0");
    }
}
