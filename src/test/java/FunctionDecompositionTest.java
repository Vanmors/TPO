import org.example.FunctionDecomposition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionDecompositionTest {


    static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 1, 2, 2, "Корректный тест"},
                { 2, 3, 6, "Некоректный тест"},
                { 1, 7, 7, "precision 1, результат всегда равен X"},
                { -5, 5, 50, "Корректный тест"}
        });
    }

    @ParameterizedTest
    @MethodSource("data")
    public void decomposeTest(int precision, int value, int expected, String comment) {
        System.out.println(comment);
        assertEquals(expected, FunctionDecomposition.decompose(precision, value), "Разложение некорректно");
    }
}
