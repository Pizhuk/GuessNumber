package test.com;

import main.com.services.GameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class GameServiceTest {

    GameService cut = new GameService();

    static List<Arguments> startGameTestArgs() {
        return List.of(
                Arguments.arguments(36, "36", 2, 5, new int[5], "Поздравляю! Ты угадал задуманное число за 2 попыток"),
                Arguments.arguments(36, "12", 5, 5, new int[5], "Вы не отгадали число!"),
                Arguments.arguments(36, "12", 1, 5, new int[5], "Не угадал. Осталось 4 попыток"),
                Arguments.arguments(36, "12", 3, 5, new int[] {1, 23, 20, 0, 0}, "Не угадал, холоднее… Осталось 2 попыток"),
                Arguments.arguments(21, "13", 3, 5, new int[] {1, 70, 28, 0, 0}, "Не угадал, теплее… Осталось 2 попыток")
        );
    }

    @ParameterizedTest
    @MethodSource("startGameTestArgs")
    void startGameTest(int number, String answer, int count, int amountOfAttempts, int[] helpArray, String expected){
        String actual = cut.startGame(number, answer, count, amountOfAttempts, helpArray);
        Assertions.assertEquals(expected, actual);
    }
}
