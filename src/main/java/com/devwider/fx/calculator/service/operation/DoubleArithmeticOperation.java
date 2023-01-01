package com.devwider.fx.calculator.service.operation;

import java.util.stream.Stream;

public enum DoubleArithmeticOperation implements IArithmeticOperation<Double> {

    ADD("+") {
        @Override
        public Double calculate(Double a, Double b) {
            return a + b;
        }
    },
    SUBTRACT("-") {
        @Override
        public Double calculate(Double a, Double b) {
            return a - b;
        }
    },
    MULTIPLY("*") {
        @Override
        public Double calculate(Double a, Double b) {
            return a * b;
        }
    },


    NON("") {
        @Override
        public Double calculate(Double a, Double b) {
            return 0.0;
        }
    };

    private final String op;

    DoubleArithmeticOperation(String op) {
        this.op = op;
    }

    @Override
    public IArithmeticOperation<Double> typeOf(String op) {
        return Stream.of(DoubleArithmeticOperation.values())
                .filter(a -> a.op.equals(op))
                .findAny()
                .orElse(DoubleArithmeticOperation.NON);
    }

    @Override
    public IArithmeticOperation<Double> empty() {
        return DoubleArithmeticOperation.NON;
    }
}