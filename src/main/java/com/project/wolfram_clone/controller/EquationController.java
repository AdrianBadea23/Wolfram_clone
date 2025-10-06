package com.project.wolfram_clone.controller;

import com.project.wolfram_clone.core.PostfixSolver;
import com.project.wolfram_clone.core.ShuntingYard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EquationController {

    @GetMapping("/solve")
    public String solve(@RequestParam String equation) {
        System.out.println("Solving equation: " + equation);
        String postfixNotation;
        ShuntingYard shuntingYard =  new ShuntingYard();
        PostfixSolver postfixSolver = new PostfixSolver();

        postfixNotation = shuntingYard.generatePostfixNotation(equation);
        return String.valueOf(postfixSolver.getSolution(postfixNotation));
    }
}
