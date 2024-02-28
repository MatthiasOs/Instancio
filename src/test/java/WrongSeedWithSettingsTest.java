import org.assertj.core.api.Assertions;
import org.instancio.Instancio;
import org.instancio.junit.InstancioExtension;
import org.instancio.junit.WithSettings;
import org.instancio.settings.Keys;
import org.instancio.settings.Settings;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(InstancioExtension.class)
public class WrongSeedWithSettingsTest {
    @WithSettings
    private final Settings settings = Settings.create()
                                              .set(Keys.SEED, Constants.seed);

    //FIXME Wrong Seed gets printed to console
    @Test
    void shouldPrintCorrectSeedWithSettings() {
        Integer integer = Instancio.of(Integer.class).create();
        Assertions.assertThat(integer).isEqualTo(Constants.integer_from_seed);
        Assertions.fail("fail so seed gets printed");
    }
}
