import org.junit.jupiter.api.Test;
import questoes.Questao3;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Questao3Test {

    @Test
    void givenAString_whenHaveAnagrams_thanAssertEqualsSuccess1() {
        // Esperado 4 anagramas
        // [0,3]    [8,9]    [0,1,2]->[1,2,3]    [1, 2, 3]
        // [i,i]    [q,q]    [ifa]->[fai]        [fai]->[ifa]
        String input = "ifailuhkqq";
        assertEquals("4", Questao3.getAnagrams(input));
    }

    @Test
    void givenAString_whenHaveAnagrams_thanAssertEqualsSuccess2() {
        // Esperado 3 anagramas
        // [0,2]     [0,1]->[1,2]     [1,2]->[0,1]
        // [o,o]     [ov,vo]          [vo,ov]
        String input = "ovo";
        assertEquals("3", Questao3.getAnagrams(input));

    }

    @Test
    void givenAString_whenNotHaveAnagrams_thanAssertEqualsZero() {
        // Esperado 0 anagramas
        String input = "abcd";
        assertEquals("0", Questao3.getAnagrams(input));
    }


}
