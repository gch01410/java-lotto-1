package lotto.domain.lottogenerator;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    @Test
    void 로또_생성_확인() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.getNumber(1),
                LottoNumber.getNumber(2),
                LottoNumber.getNumber(3),
                LottoNumber.getNumber(4),
                LottoNumber.getNumber(5),
                LottoNumber.getNumber(6));

        assertThat(LottoGenerator.create(new ManualLottoGeneratingStrategy(Arrays.asList(1, 2, 3, 4, 5, 6))))
                .isEqualTo(new Lotto(lottoNumbers));
    }
}