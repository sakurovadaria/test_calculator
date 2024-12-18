package com.test.test.Service;

import com.test.test.Exception.ZeroDivideException;
import org.junit.jupiter.api.Test;

import static com.test.test.Service.CalculatorServiceImlConstants.*;
import static org.junit.jupiter.api.Assertions.*;
class CalculatorServiceImplTest {
    private final CalculatorService out = new CalculatorServiceImpl();


    @Test
    public void shouldReturn3WhenSum1AndSum2() {
        assertEquals(THREE, out.sum(ONE, TWO));
    }

    @Test
    public void shouldReturn2WhenSum0AndSum2() {
        assertEquals(TWO, out.sum(ZERO, TWO));
    }

    @Test
    public void shouldReturn0WhenMinus2And2() {
        assertEquals(ZERO, out.minus(TWO, TWO));
    }

    @Test
    public void shouldReturn1WhenMinus2And1() {
        assertEquals(ONE, out.minus(TWO, ONE));
    }

    @Test
    public void shouldReturn1WhenMultiply1And1() {
        assertEquals(ONE, out.multiply(ONE, ONE));
    }

    @Test
    public void shouldReturn1WhenMultiply2And1() {
        assertEquals(TWO, out.multiply(TWO, ONE));
    }

    @Test
    public void shouldReturn1WhenDivide2And2() {
        assertEquals(ONE, out.divide(TWO, TWO));
    }

    @Test
    public void shouldReturn2WhenDivide2And1() {
        assertEquals(TWO, out.divide(TWO, ONE));
    }

    @Test
    public void shouldTrow2ErrorDividerExceptionWhenDivideAnyNumAnd0() {
        assertThrows(ZeroDivideException.class, () -> out.divide(TWO, ZERO));
    }
}