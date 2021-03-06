package lotto.domain;

import lotto.exception.NaturalNumberException;
import lotto.exception.PaymentOutOfBoundsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class PaymentTest {
    private Payment payment;

    @BeforeEach
    void setUp() {
        payment = new Payment("1000");
    }

    @Test
    void 생성자_확인() {
        assertThat(payment).isEqualTo(new Payment("1000"));
    }

    @Test
    void 생성자_확인_빈_문자열을_입력했을_때() {
        assertThatThrownBy(() -> new Payment("")).isInstanceOf(NullPointerException.class);
    }

    @Test
    void 생성자_확인_숫자가_아닌_문자열을_입력했을_때() {
        assertThatThrownBy(() -> new Payment("a1000")).isInstanceOf(NaturalNumberException.class);
    }

    @Test
    void 생성자_확인_로또가격보다_적은_금액을_입력했을_때() {
        assertThatThrownBy(() -> new Payment("999")).isInstanceOf(PaymentOutOfBoundsException.class);
    }

    @Test
    void 총_로또개수_확인() {
        assertThat(payment.calculateCountOfLotto()).isEqualTo(1);
    }

    @Test
    void 수익률_계산_확인() {
        assertThat(payment.calculateEarningsRate(BigDecimal.valueOf(10_000))).isEqualTo(BigDecimal.valueOf(10.0));
    }
}
