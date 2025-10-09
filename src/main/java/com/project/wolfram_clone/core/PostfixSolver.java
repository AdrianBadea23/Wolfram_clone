package com.project.wolfram_clone.core;

import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class PostfixSolver {

    public PostfixSolver() {}

    private boolean isOperator(String c) {
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/") || c.equals("^");
    }

    public Double getSolution(String equation){
        Stack<Double> stack = new Stack<>();
        String[] parts = equation.trim().split("\\s+");

        for (String token : parts) {
            if (!isOperator(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                double a = stack.pop(); // exponent
                double b = stack.pop(); // base
                double result = switch (token) {
                    case "^" -> Math.pow(b, a);
                    case "*" -> b * a;
                    case "/" -> b / a;
                    case "+" -> b + a;
                    case "-" -> b - a;
                    default -> throw new IllegalArgumentException("Unknown operator: " + token);
                };
                stack.push(result);
            }
        }
        return stack.pop();
    }
}
