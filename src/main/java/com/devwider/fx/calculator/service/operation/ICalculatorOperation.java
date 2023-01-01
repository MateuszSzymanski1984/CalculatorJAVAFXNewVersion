package com.devwider.fx.calculator.service.operation;

public interface ICalculatorOperation<T extends Number> {
    T calculate(T a);
    ICalculatorOperation<T> typeOf(String op);
    ICalculatorOperation<T> empty();
}
