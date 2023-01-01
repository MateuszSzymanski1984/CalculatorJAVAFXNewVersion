package com.devwider.fx.calculator.service;

import com.devwider.fx.calculator.service.operation.IArithmeticOperation;
import com.devwider.fx.calculator.service.operation.ICalculatorOperation;

import java.util.function.Function;

public class CalculatorService<T extends Number> implements ICalculatorService {

    private IArithmeticOperation<T> arithmeticOperation;
    private ICalculatorOperation<T> calculatorOperation;
    private final Function<String, T> converter;
    private final StringBuilder a;
    private final StringBuilder b;
    private StringBuilder actual;

    public CalculatorService(IArithmeticOperation<T> arithmeticOperation, ICalculatorOperation<T> calculatorOperation,
                             Function<String, T> converter) {
        this.arithmeticOperation = arithmeticOperation;
        this.calculatorOperation = calculatorOperation;
        this.converter = converter;
        this.a = new StringBuilder();
        this.b = new StringBuilder();
        this.actual = new StringBuilder();
    }

    @Override
    public String append(String text) throws NumberFormatException {
        actual = arithmeticOperation == arithmeticOperation.empty() ? a : b;
        if(!".".equals(text) || !actual.toString().contains("."))
            actual.append(text);
        return actual.toString();
    }

    @Override
    public String back() {
        if(actual.length() > 0)
            actual.delete(actual.length()-1 , actual.length());
        return actual.toString();
    }

    @Override
    public String calculate(String text) throws NumberFormatException {
        calculatorOperation = calculatorOperation.typeOf(text);
        if(!a.toString().isEmpty() && !b.toString().isEmpty()
                && arithmeticOperation != arithmeticOperation.empty()) {
            T a1 = converter.apply(a.toString());
            T b1 = converter.apply(b.toString());
            T result = arithmeticOperation.calculate(a1, b1);
            reset();
            a.append(result);
            actual = a;
        } else if(calculatorOperation != calculatorOperation.empty()) {
            T a1 = converter.apply(actual.toString());
            T result = calculatorOperation.calculate(a1);
            actual.delete(0, actual.length());
            actual.append(result);
        }
        if(calculatorOperation == calculatorOperation.empty())
            arithmeticOperation = arithmeticOperation.typeOf(text);
        return actual.toString();
    }

    @Override
    public void reset() {
        a.delete(0, a.length());
        b.delete(0, b.length());
        arithmeticOperation = arithmeticOperation.empty();
        calculatorOperation = calculatorOperation.empty();
    }
}
