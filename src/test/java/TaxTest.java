import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static javax.print.attribute.standard.MediaSizeName.B;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxTest  {
    static TaxTest sut;


    @BeforeAll
    public static void started () {
        sut = new TaxTest();
    }

    @AfterEach
    public void finished () {
        sut = null;
    }


    @Test
    public void test1TaxEarning() {
        int a = 800, expected = 48;
        int result = sut.taxEarning(a);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("source")
    public void test2TaxEarning (int a, int b) {
        int result = sut.taxEarning(a);
        assertEquals(result, b);
    }

    private static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(600, 36),
                Arguments.of(1000, 60)
        );
    }

    @Test
    public void testTaxEarningMinusSpending() {
        int a = 3000, b = 2000, expected = 150;
        int result = sut.taxEarningMinusSpending(a, b);
        assertEquals(result, expected);
    }

}