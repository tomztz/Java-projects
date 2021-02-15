import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;


import java.util.Arrays;

//-------------------------------------------------------------------------
/**
 *  Test class for Arith class.
 *
 *  @version 3.1 15/12/17 11:32:15
 *
 *  @author  Tianze Zhang
 */

@RunWith(JUnit4.class)

public class ArithTest {
    @Test
    public void isOperatorNull(){



        assertEquals("test isOperator null", false, Arith.isOperator(null));
    }
    @Test
    public void getValueZero(){



    assertEquals("undefined operator", 0, Arith.getValue("!",1,2));
    }
    @Test
    public void getValueDivByZero(){


        try{
            Arith.getValue("/",0,0);
            fail("error: divide by zero");
        } catch(RuntimeException e) {
            //assert ExceptionType e
        }


    }
    @Test
    public void hasSameOrHigherOperatorPrecedenceBrackets(){
        assertEquals("Check precedence brackets", false, Arith.hasSameOrHigherOperatorPrecedence("(",")"));
    }

    @Test
    public void hasSameOrHigherOperatorPrecedencePlusMul(){
        assertEquals("Check precedence plus and multiply", true, Arith.hasSameOrHigherOperatorPrecedence("+","*"));
    }
    @Test
    public void hasSameOrHigherOperatorPrecedencePlusDiv(){
        assertEquals("Check precedence plus and multiply", true, Arith.hasSameOrHigherOperatorPrecedence("+","/"));
    }
    @Test
    public void hasSameOrHigherOperatorPrecedenceMinusMul(){
        assertEquals("Check precedence minus and divide", true, Arith.hasSameOrHigherOperatorPrecedence("-","*"));
    }
    @Test
    public void hasSameOrHigherOperatorPrecedenceMinusDiv(){
        assertEquals("Check precedence minus and divide", true, Arith.hasSameOrHigherOperatorPrecedence("-","/"));
    }
    @Test
    public void hasSameOrHigherOperatorPrecedenceMulDiv(){
        assertEquals("Check precedence minus and divide", false, Arith.hasSameOrHigherOperatorPrecedence("*","/"));
    }
    @Test
    public void validateInfixOrderTrue() {

        String[] infixExpression = {"(", "(", "1", "-", "2", ")", "*", "3", ")", "+", "(", "10",
                "-", "(", "3", "+", "(", "6", "/", "3", ")", ")", ")"};

        assertEquals("Check validate infix expression true.", true, Arith.validateInfixOrder(infixExpression));


    }
    @Test
    public void validateInfixOrderFalse2() {

        String[] infixExpression = {"("};

        assertEquals("Check validate infix expression false.", false, Arith.validateInfixOrder(infixExpression));


    }

    @Test
    public void validateInfixOrderFalse() {

        String[] prefixExpression = {"+", "*", "2", "3", "/", "6","2"};

        assertEquals("Check validate infix expression false.", false, Arith.validateInfixOrder(prefixExpression));


    }
    @Test
    public void validateInfixOrderFalse3() {

        String[] prefixExpression = {"1", "5", "2", "*", "/", "+","2"};

        assertEquals("Check validate infix expression false.", false, Arith.validateInfixOrder(prefixExpression));


    }
    @Test
    public void validateInfixOrderFalseWithInvalidBracketsAndOp() {

        String[] infixExpression = {"(", "+", ")", "3", "/", "6","2","+","2"};

        assertEquals("Check validate infix expression false.", false, Arith.validateInfixOrder(infixExpression));


    }
    @Test
    public void validateInfixOrderFalseWithNull() {

        String[] infixExpression = {"(", ")"};

        assertEquals("Check validate infix expression false.", false, Arith.validateInfixOrder(infixExpression));


    }
    @Test
    public void validateInfixOrderFalseWithUnbalanceBrackets() {

        String[] infixExpression = {"(", "2","+","2",")",")"};

        assertEquals("Check validate infix expression false.", false, Arith.validateInfixOrder(infixExpression));


    }
    @Test
    public void evaluateInfixOrderTrue() {

        String[] infixExpression = {"(", "(", "1", "-", "2", ")", "*", "3", ")", "+", "(", "10",
                "-", "(", "3", "+", "(", "6", "/", "3", ")", ")", ")"};

        assertEquals("Check evaluate Infix expression true.", 2, Arith.evaluateInfixOrder(infixExpression));


    }
    @Test
    public void evaluateInfixOrderTrue2() {

        String[] infixExpression = { "7", "+", "8", "*", "3", "-", "22"};

        assertEquals("Check evaluate Infix expression true.", 9, Arith.evaluateInfixOrder(infixExpression));


    }
    @Test
    public void convertInfixToPostfixTrue2() {

        String[] infixExpression = {"7", "+", "8", "*", "3", "-", "22"};

        String[]expectedExpression={"7", "8", "3", "*", "22", "-" ,"+"};

        for(int i=0;i<expectedExpression.length;i++) {

            assertEquals("Check convert Infix to postfix expression true.", expectedExpression[i], Arith.convertInfixToPostfix(infixExpression)[i]);
        }


    }

    @Test
    public void convertInfixToPostfixTrue() {

        String[] infixExpression = {"(","(", "1","-", "2", ")","*", "3",
        ")","+", "(","10","-", "(","3", "+", "(","6", "/", "3",")",")",")"};

        String[] expectedExpression={"1", "2","-","3", "*","10","3","6","3","/", "+", "-", "+"};
        for(int i=0;i<expectedExpression.length;i++) {
            assertEquals("Check convert Infix to postfix expression true.", expectedExpression[i], Arith.convertInfixToPostfix(infixExpression)[i]);
        }

    }

    @Test
    public void convertPostfixToInfixTrue() {

        String[] expectedExpression= {"(","(", "1","-", "2", ")","*", "3",
                ")","+", "(","10","-", "(","3", "+", "(","6", "/", "3",")",")",")"};

        String[] postfixExpression={"1", "2","-","3", "*","10","3","6","3","/", "+", "-", "+"};

        for(int i=0;i<expectedExpression.length;i++) {

            assertEquals("Check convert postfix to infix expression true.", expectedExpression[i], Arith.convertPostfixToInfix(postfixExpression)[i]);
        }

    }
}