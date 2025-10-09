package com.project.wolfram_clone.controller;

import com.project.wolfram_clone.core.PostfixSolver;
import com.project.wolfram_clone.core.ShuntingYard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EquationController {

    private final ShuntingYard shuntingYard;
    private final PostfixSolver postfixSolver;

    public EquationController(ShuntingYard shuntingYard, PostfixSolver postfixSolver) {
        this.shuntingYard = shuntingYard;
        this.postfixSolver = postfixSolver;
    }

    @GetMapping("/solve")
    public String solve(@RequestParam String equation) {
        String postfixNotation;
        postfixNotation = shuntingYard.infixToRpn(equation);
        return String.valueOf(postfixSolver.getSolution(postfixNotation));
    }
}
