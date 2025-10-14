package com.project.wolfram_clone;

import com.project.wolfram_clone.core.PostfixSolver;
import com.project.wolfram_clone.core.ShuntingYard;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest()
class WolframCloneApplicationTests {

    private final ShuntingYard shuntingYard = new ShuntingYard();
    private final PostfixSolver postfixSolver = new PostfixSolver();
    Double resultD = 0.0;
    private String expression = "";
    private String result = "";

    @Test
    void ShuntingYardTest() {
        expression = "2^2^2^2";
        result = shuntingYard.infixToRpn(expression);
        assert(result.equals(" 2 2 2 2 ^ ^ ^"));
    }

    @Test
    void ShuntingYardTest2() {
        expression = "2+(2+2)*2";
        result = shuntingYard.infixToRpn(expression);
        assert(result.equals(" 2 2 2 + 2 * +"));
    }

    @Test
    void ShuntingYardTest3() {
        expression = "2-2";
        result = shuntingYard.infixToRpn(expression);
        assert(result.equals(" 2 2 -"));
    }

    @Test
    void ShuntingYardTest4() {
        expression = "2/2";
        result = shuntingYard.infixToRpn(expression);
        assert(result.equals(" 2 2 /"));
    }

    @Test
    void postfixSolverTest() {
        expression = "2/2";
        result = shuntingYard.infixToRpn(expression);
        resultD = postfixSolver.getSolution(result);
        assert(resultD == 1.0);
    }

    @Test
    void postfixSolverTest2() {
        expression = "2^2^2^2";
        result = shuntingYard.infixToRpn(expression);
        resultD = postfixSolver.getSolution(result);
        assert(resultD == 65536.0);
    }

    @Test
    void postfixSolverTest3() {
        expression = "2+(2+2)*2";
        result = shuntingYard.infixToRpn(expression);
        resultD = postfixSolver.getSolution(result);
        assert(resultD == 10.0);
    }
}
