package lotto.domain.lotto;

import lotto.domain.lottogenerator.LottoGenerator;
import lotto.domain.lottogenerator.ManualLottoGeneratingStrategy;
import lotto.domain.lottogenerator.RandomLottoGeneratingStrategy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRepositoryTest {
    @Test
    void 수동_로또_추가() {
        LottoRepository lottoRepository = new LottoRepository();
        lottoRepository.register(new ManualLottoGeneratingStrategy(Arrays.asList(1, 2, 3, 4, 5, 6)));

        assertThat(lottoRepository.getLottos())
                .isEqualTo(Arrays.asList(LottoGenerator
                        .create(new ManualLottoGeneratingStrategy(Arrays.asList(1, 2, 3, 4, 5, 6)))));
    }

    @Test
    void 자동_로또_추가() {
        LottoRepository lottoRepository = new LottoRepository();
        lottoRepository.register(new RandomLottoGeneratingStrategy());

        assertThat(lottoRepository.getLottos().size()).isEqualTo(1);
    }
}