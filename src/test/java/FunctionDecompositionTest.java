import org.example.task1.FunctionDecomposition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class FunctionDecompositionTest {


    static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 1, 0.1, 0.1, "Корректный тест"},
                { 1, 0.4, 0.4, "precision 1, результат всегда равен X"},
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


    static Collection<Object[]> dataArcsin() {
        return Arrays.asList(new Object[][] {
                {2, 0.5, 0.01},
                {100, 0.5, 0.01},
                {100, 0.1, 0.01},
                {100, 0.9, 0.1},
                {1000, -0.4, 0.01},
                {1000, -0.9, 0.1}
        });
    }

    @ParameterizedTest
    @MethodSource("dataArcsin")
    public void decomposeTestArcsin(int iterations, double value, double precision){
        FunctionDecomposition functionDecomposition = new FunctionDecomposition();
        boolean expected = Math.abs(Math.asin(value) - functionDecomposition.decompose(iterations, value)) < precision;
        assertTrue(expected);
    }

}
