import org.example.FunctionDecomposition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionDecompositionTest {


    static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 1, 2, 2 },
                { 2, 3, 6 },
                { 5, 7, 35 },
                { 10, 5, 50 }
        });
    }

    @ParameterizedTest
    @MethodSource("data")
    public void decomposeTest(int a, int b, int expected) {
        assertEquals(expected, FunctionDecomposition.decompose(a, b), "Сумма некорректна");
    }
}
