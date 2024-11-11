import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class NotenDurchschnittTest {

    @Test
    void berechneDurchschnittTest() {
        double[] noten = { 1.0, 1.5, 2.0 };
        double expectedDurchschnitt = 1.5;

        
        double actualDurchschnitt = Notendurchschnitt.berechneDurchschnitt();
        assertThat(actualDurchschnitt).isEqualTo(expectedDurchschnitt);
    }

}
