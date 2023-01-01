package com.devwider.fx.calculator.service;

public interface ICalculatorService {
    String append(String text) throws NumberFormatException;
    String back();
    String calculate(String text) throws NumberFormatException;
    void reset();
}
