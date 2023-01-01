package com.devwider.fx.calculator.service.operation;

public interface IArithmeticOperation<T extends Number> {
    T calculate(T a, T b);
    IArithmeticOperation<T> typeOf(String op);
    IArithmeticOperation<T> empty();
}
