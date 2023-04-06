package com.sumit.test;

import java.util.Scanner;

public class Calculator {
    public enum Operation {
        ADD("+") {
            public double apply(double x, double y) {
                return x + y;
            }
        },
        SUBTRACT("-") {
            public double apply(double x, double y) {
                return x - y;
            }
        },
        MULTIPLY("*") {
            public double apply(double x, double y) {
                return x * y;
            }
        },
        DIVIDE("/") {
            public double apply(double x, double y) {
                return x / y;
            }
        };

        private final String symbol;

        Operation(String symbol) {
            this.symbol = symbol;
        }

        public abstract double apply(double x, double y);

        @Override
        public String toString() {
            return symbol;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        double x = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double y = scanner.nextDouble();
        System.out.print("Enter the operator (+, -, *, /): ");
        String operator = scanner.next();

        Operation op = Operation.valueOf(operator.toUpperCase());
        double result = op.apply(x, y);
        System.out.println(x + " " + op + " " + y + " = " + result);
    }
}
