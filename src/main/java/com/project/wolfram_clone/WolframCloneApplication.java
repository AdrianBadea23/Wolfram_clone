package com.project.wolfram_clone;

import com.project.wolfram_clone.core.PostfixSolver;
import com.project.wolfram_clone.core.ShuntingYard;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WolframCloneApplication {

    public static void main(String[] args) {
//        SpringApplication.run(WolframCloneApplication.class, args);
        String postfixNotation;
        ShuntingYard shuntingYard =  new ShuntingYard();
        PostfixSolver postfixSolver = new PostfixSolver();

        postfixNotation = shuntingYard.generatePostfixNotation("(11+2)^3+7");
        System.out.println(postfixNotation);
        System.out.println(postfixSolver.getSolution(postfixNotation));
    }


}
