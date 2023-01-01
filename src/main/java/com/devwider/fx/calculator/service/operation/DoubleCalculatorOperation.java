package com.devwider.fx.calculator.service.operation;

import java.util.stream.Stream;

public enum DoubleCalculatorOperation implements ICalculatorOperation<Double> {

    PERCENT("%") {
        @Override
        public Double calculate(Double a) {
            return DoubleArithmeticOperation.MULTIPLY.calculate(a, 0.01);
        }
    },
    NEGATIVE_POSITIVE("-/+") {
        @Override
        public Double calculate(Double a) {
            return DoubleArithmeticOperation.MULTIPLY.calculate(a, -1.0);
        }
    },
    EQUAL("=") {
        @Override
        public Double calculate(Double a) {
            return a;
        }
    },
    NON("") {
        @Override
        public Double calculate(Double a) {
            return a;
        }
    };

    private final String op;

    DoubleCalculatorOperation(String op) {
        this.op = op;
    }

    @Override
    public ICalculatorOperation<Double> typeOf(String op) {
        return Stream.of(DoubleCalculatorOperation.values())
                .filter(a -> a.op.equals(op))
                .findAny()
                .orElse(DoubleCalculatorOperation.NON);
    }

    @Override
    public ICalculatorOperation<Double> empty() {
        return DoubleCalculatorOperation.NON;
    }
}
