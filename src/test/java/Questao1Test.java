
import org.junit.jupiter.api.Test;
import questoes.Questao1;

import static org.junit.jupiter.api.Assertions.*;


public class Questao1Test {

    @Test
    void givenAString_whenIsANumber_thanAssertEqualsSuccess() {
        String ladder = "     *\n    **\n   ***\n  ****\n *****\n******";
        assertEquals(ladder, Questao1.fillAsterisks("6"));
    }

    @Test
    void givenAString_whenIsNotANumber_thanAssertNotEquals() {
        String ladder = "     *\n    **\n   ***\n  ****\n *****\n******";
        assertNotEquals(ladder, Questao1.fillAsterisks("A"));
    }




}
