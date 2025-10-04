package com.project.wolfram_clone.core;

import static java.lang.Math.pow;

public class PostfixSolver {

    public PostfixSolver() {}

    private boolean isOperator(String c) {
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/") || c.equals("^");
    }

    public int getSolution(String equation){
        int solution = 0;
        int i = 0;
        int operators = 0;

        String[] parts = equation.trim().split("\\s+");

        i = 0;
        while(i<parts.length){
            if(isOperator(parts[i])){
                switch(parts[i].charAt(0)){
                    case '^':
                        solution = (int) pow(Integer.parseInt(parts[i - 2]), Integer.parseInt(parts[i - 1]));
                        break;

                    case '*':
                        solution = Integer.parseInt(parts[i - 2]) * Integer.parseInt(parts[i - 1]);
                        break;

                    case '/':
                        solution = Integer.parseInt(parts[i - 2]) / Integer.parseInt(parts[i - 1]);
                        break;

                    case '+':
                        solution = Integer.parseInt(parts[i - 2]) + Integer.parseInt(parts[i - 1]);
                        break;

                    case '-':
                        solution = Integer.parseInt(parts[i - 2]) - Integer.parseInt(parts[i - 1]);
                        break;
                    default:
                        break;
                }
                parts[i] = String.valueOf(solution);
                i--;

            }
            i++;

        }

        solution = Integer.parseInt(parts[i - 1]);
        return solution;
    }
}
