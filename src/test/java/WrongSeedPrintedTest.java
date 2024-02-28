import org.assertj.core.api.Assertions;
import org.instancio.Instancio;
import org.instancio.junit.InstancioExtension;
import org.instancio.junit.Seed;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(InstancioExtension.class)
public class WrongSeedPrintedTest {

    //FIXME Wrong Seed gets printed to console
    @Test
    void shouldPrintCorrectSeedWithMethod() {
        Integer integer = Instancio.of(Integer.class).withSeed(Constants.seed).create();
        //Correct Seed gets used, because the Integer is the correct one when using the seed constant
        Assertions.assertThat(integer).isEqualTo(Constants.integer_from_seed);
        Assertions.fail("fail so seed gets printed");
    }

    //Correct Seed 3003117528796338262 gets printed
    @Seed(Constants.seed)
    @Test
    void shouldPrintCorrectSeedWithAnnotation() {
        Integer integer = Instancio.of(Integer.class).create();
        Assertions.assertThat(integer).isEqualTo(Constants.integer_from_seed);
        Assertions.fail("fail so seed gets printed");
    }

}
