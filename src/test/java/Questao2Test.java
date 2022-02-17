import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import questoes.Questao2;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

public class Questao2Test{

    @ParameterizedTest(name = "#{index} - Run test with password = {0}")
    @MethodSource("checkPasswordOk")
    void givenPassword_whenPasswordCorrect_thenReturnStringEmpty(String password) {
        assertEquals("", Questao2.checkPassword(password));
    }

    @ParameterizedTest(name = "#{index} - Run test with password = {0}")
    @MethodSource("checkPasswordNotOkCriteria")
    void givenPassword_whenPasswordNotCorrect_thenReturnStringValue(String password) {
        assertEquals("3", Questao2.checkPassword(password));
    }

    @Test
    void givenPassword_whenPasswordLengthNotCorrect_thenReturnStringValue() {
        assertEquals("2", Questao2.checkPassword("aA1&"));
    }

    static Stream<String> checkPasswordOk() {
        return Stream.of(
                "Aa1&xx",
                "My_N@me_is_N0body",
                "xxxxxx111&&&Z",
                "aaaaAAA888***"
        );
    }

    static Stream<String> checkPasswordNotOkCriteria() {
        return Stream.of(
                "123456",
                "abcdef",
                "ABCDEF",
                "******"
        );
    }


}
