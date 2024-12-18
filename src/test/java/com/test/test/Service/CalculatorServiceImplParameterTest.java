package com.test.test.Service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.expression.spel.ast.OpNE;

import java.util.stream.Stream;

import static com.test.test.Service.CalculatorServiceImlConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceImplParameterTest {
    private final CalculatorService out = new CalculatorServiceImpl();

    @MethodSource("provideArgumentsForCalculatorTests")
    @ParameterizedTest
    public void should_Return_Correct_Result_Of_Summation(int num1, int num2) {
        assertEquals(num1 + num2, out.sum(num1, num2));
    }

    @MethodSource("provideArgumentsForCalculatorTests")
    @ParameterizedTest
    public void should_Return_Correct_Result_Of_Minus(int num1, int num2) {
        assertEquals(num1 - num2, out.minus(num1, num2));
    }

    @MethodSource("provideArgumentsForCalculatorTests")
    @ParameterizedTest
    public void should_Return_Correct_Result_Of_Multiplication(int num1, int num2) {
        assertEquals(num1 * num2, out.multiply(num1, num2));
    }

    @MethodSource("provideArgumentsForCalculatorTests")
    @ParameterizedTest
    public void should_Return_Correct_Result_Of_Division(int num1, int num2) {
        assertEquals(num1 / num2, out.divide(num1, num2));
    }

    private static Stream<Arguments> provideArgumentsForCalculatorTests () {
        return Stream.of(
                Arguments.of(ZERO, ONE),
                Arguments.of(ZERO, TWO),
                Arguments.of(ONE, ONE),
                Arguments.of(ONE, TWO),
                Arguments.of(TWO, ONE)
                );
    }
}
