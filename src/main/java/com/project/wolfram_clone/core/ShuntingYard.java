package com.project.wolfram_clone.core;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ShuntingYard {

    public ShuntingYard() {}

    public String generatePostfixNotation(String expression) {
        String postfixNotation = "";
        Stack<String> operators = new Stack<>();
        Queue<String> tokens = new LinkedList<>();
        int i = 0;

        while(i < expression.length()){
            switch(expression.charAt(i)){
                case '^':
                    tokens.add(" ");
                    operators.push("^");
                    break;

                case '*':
                    if(!operators.isEmpty() && operators.peek().equals("^")){
                        tokens.add(" ");
                        tokens.add(operators.pop());
                    }
                    tokens.add(" ");
                    operators.push("*");
                    break;

                case '/':
                    if(!operators.isEmpty() && operators.peek().equals("^")){
                        tokens.add(" ");
                        tokens.add(operators.pop());
                    }
                    tokens.add(" ");
                    operators.push("/");
                    break;

                case '+':
                    if(!operators.isEmpty() && (operators.peek().equals("^")
                            || operators.peek().equals("*")
                            || operators.peek().equals("/"))){
                        tokens.add(" ");
                        tokens.add(operators.pop());
                    }
                    tokens.add(" ");
                    operators.push("+");
                    break;

                case '-':
                    if(!operators.isEmpty() && (operators.peek().equals("^")
                            || operators.peek().equals("*")
                            || operators.peek().equals("/"))){
                        tokens.add(" ");
                        tokens.add(operators.pop());
                    }
                    tokens.add(" ");
                    operators.push("-");
                    break;

                case '(':
                    while(expression.charAt(i) != ')'){
                        switch(expression.charAt(i)) {
                            case '^':
                                tokens.add(" ");
                                operators.push("^");
                                break;

                            case '*':
                                if (!operators.isEmpty() && operators.peek().equals("^")) {
                                    tokens.add(" ");
                                    tokens.add(operators.pop());
                                }
                                tokens.add(" ");
                                operators.push("*");
                                break;

                            case '/':
                                if (!operators.isEmpty() && operators.peek().equals("^")) {
                                    tokens.add(" ");
                                    tokens.add(operators.pop());
                                }
                                tokens.add(" ");
                                operators.push("/");
                                break;

                            case '+':
                                if (!operators.isEmpty() && (operators.peek().equals("^")
                                        || operators.peek().equals("*")
                                        || operators.peek().equals("/"))) {
                                    tokens.add(" ");
                                    tokens.add(operators.pop());
                                }
                                tokens.add(" ");
                                operators.push("+");
                                break;

                            case '-':
                                if (!operators.isEmpty() && (operators.peek().equals("^")
                                        || operators.peek().equals("*")
                                        || operators.peek().equals("/"))) {
                                    tokens.add(" ");
                                    tokens.add(operators.pop());
                                }
                                tokens.add(" ");
                                operators.push("-");
                                break;

                            case '(':
                                operators.push("(");
                                break;

                            default:
                                tokens.add(String.valueOf(expression.charAt(i)));
                                break;
                        }

                        i++;
                    }

                    while(!operators.peek().equals("(")){
                        tokens.add(" ");
                        tokens.add(operators.pop());
                    }
                    operators.pop();
                    break;

                default:
                    tokens.add(String.valueOf(expression.charAt(i)));
                    break;
            }

            i++;
        }

        for(String token : tokens){
            postfixNotation += token;
        }

        while(!operators.isEmpty()){
            postfixNotation += " " + operators.pop();
        }

        return postfixNotation;
    }
}
