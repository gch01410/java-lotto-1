package lotto.domain.lotto;

import lotto.domain.lottogenerator.ManualLottoGeneratingStrategy;
import lotto.domain.lottogenerator.RandomLottoGeneratingStrategy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRepositoryTest {
    @Test
    void 수동_로또_추가() {
        LottoRepository lottoRepository = new LottoRepository();
        lottoRepository.register(new ManualLottoGeneratingStrategy(Arrays.asList(1, 2, 3, 4, 5, 6)));

        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.getNumber(1),
                LottoNumber.getNumber(2),
                LottoNumber.getNumber(3),
                LottoNumber.getNumber(4),
                LottoNumber.getNumber(5),
                LottoNumber.getNumber(6));

        assertThat(lottoRepository.getLottos()).isEqualTo(Arrays.asList(new Lotto(lottoNumbers)));
    }

    @Test
    void 자동_로또_추가() {
        LottoRepository lottoRepository = new LottoRepository();
        lottoRepository.register(new RandomLottoGeneratingStrategy());

        assertThat(lottoRepository.getLottos().size()).isEqualTo(1);
    }
}