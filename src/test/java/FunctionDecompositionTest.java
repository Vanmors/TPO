import org.example.task1.FunctionDecomposition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FunctionDecompositionTest {


    static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 1, 2, 2.0, "Корректный тест"},
                { 2, 3, 7.5, "Некоректный тест"},
                { 1, 7, 7.0, "precision 1, результат всегда равен X"},
                {12, 3, 2.2231233827984104E9, ""}
        });
    }

    static Collection<Object[]> dataException() {
        return Arrays.asList(new Object[][] {
                { -1, 2, "Exception"},
        });
    }

    @ParameterizedTest
    @MethodSource("data")
    public void decomposeTest(int precision, double value, Object expected, String comment) {
        System.out.println(comment);
        FunctionDecomposition functionDecomposition = new FunctionDecomposition();
        assertEquals(expected, functionDecomposition.decompose(precision, value), "Разложение некорректно");
    }

    @ParameterizedTest
    @MethodSource("dataException")
    public void decomposeExceptionTest(int precision, double value, String comment) {
        System.out.println(comment);
        FunctionDecomposition functionDecomposition = new FunctionDecomposition();
        assertThrows(RuntimeException.class, () -> functionDecomposition.decompose(precision, value));
    }

}
