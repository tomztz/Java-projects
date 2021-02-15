// -------------------------------------------------------------------------

import java.util.ArrayList;
import java.util.Stack;

/**
 *  Utility class containing validation/evaluation/conversion operations
 *  for infix arithmetic expressions.
 *
 *  @author Tianze Zhang
 *  @version 1/12/15 13:03:48
 */

class Arith
{


    //~ Validation methods ..........................................................


    /**
     * Validation method for infix notation.
     *
     * @param infixLiterals : an array containing the string literals hopefully in infix order.
     * The method assumes that each of these literals can be one of:
     * - "+", "-", "*", or "/"
     * - or a valid string representation of an integer "0", "1" , "2", ..., "-1", "-2", ...
     *
     * @return true if the parameter is indeed in infix notation, and false otherwise.
     *
     * this method don't contain an data structure, it has an worst case running time of
     * theta(n),(it's at the middle bound since the WC cannot be greater or lower than theta(n)
     * which n is the length of the infixLiterals given, this is because it contains
     * a for loop that scans every element of the array, it will have a best case running time
     * of O(1)(upper bound) which is the least elements in the array, and the average case is around O(N/2)
     *
     * discuss optimality:
     * running time of theta(N) is already optimal for scanning a Array,
     * Using only Array not using any data structure for this method saves memory
     *
     *
     **/
    public static boolean validateInfixOrder(String infixLiterals[])
    {
        int count=0;
        int bracketsIncomplete=0;
        for(int i=0;i<infixLiterals.length;i++){
            String s= infixLiterals[i];
            if(isInteger(s)){
                count++;
            }
            else if(isOperator(s)){
                count--;
            }
            else if(s.equals("(")){
                if(i!=infixLiterals.length-1){
                if(isOperator(infixLiterals[i+1])||infixLiterals[i+1].equals(")")){
                    return false;}}
                bracketsIncomplete++;
            }
            else if(s.equals(")")){

                bracketsIncomplete--;


            }

            if(count<0||count>1){
                return false;
            }

        }
        if(count==1&&bracketsIncomplete==0){
            return true;
        }
        return false;
    }


    protected static boolean isInteger(String str)
    {
        try
        {
            int  number = Integer.parseInt(str);
        }
        catch(NumberFormatException ex)
        {
            return false;
        }
        return true;
    }

    protected static boolean isOperator(String token) {
        if (token == null) return false;

        return  token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/");
    }

    //~ Evaluation  methods ..........................................................


    /**
     * Evaluation method for infix notation.
     *
     * @param infixLiterals : an array containing the string literals in infix order.
     * The method assumes that each of these literals can be one of:
     * - "+", "-", "*", or "/"
     * - or a valid string representation of an integer.
     *
     * @return the integer result of evaluating the expression
     *
     * uses two stacks, taking an array, and two helper functions.this method has a worst case
     * of O(NM) which N is the numbers of elements in the Array, and M is the element get peek
     * or Popped from the stack. I chose the upper bound O(NM) because M could higher. This result
     * is obtained by one for loop with an while loop of N*M executions.
     *
     * optimality:
     * use of data structures of stack : push pop peak O(1)
     * no temp array and reference saves memory.
     **/
    public static int evaluateInfixOrder(String infixLiterals[])
    {
        Stack<Integer> operands = new Stack<Integer>();
        Stack<String> operators = new Stack<String>();

        for (String token: infixLiterals) {

            if (isInteger(token)) operands.push(Integer.parseInt(token));
            else if (token.equals("(")) operators.push(token);
            else if (token.equals(")"))
            {
                while (!operators.peek().equals("("))
                    operands.push(getValue(operators.pop(), operands.pop(), operands.pop()));

                operators.pop();
            }

            else if (isOperator(token))
            {
                while (!operators.empty() && hasSameOrHigherOperatorPrecedence(token,operators.peek()))
                    operands.push(getValue(operators.pop(), operands.pop(), operands.pop()));
                operators.push(token);
            }
        }

        while (!operators.empty())
            operands.push(getValue(operators.pop(), operands.pop(), operands.pop()));

        return operands.pop();
    }
    protected static boolean hasSameOrHigherOperatorPrecedence(String operator1, String operator2)
    {
        if (operator2.equals("(") || operator2.equals(")"))
            return false;
        if ((operator1.equals("*") || operator1.equals("/") && (operator2.equals("+") || operator2.equals("-"))))
            return false;
        else
            return true;
    }
    protected static int getValue(String operator, int a, int b)
    {
        switch (operator)
        {
            case "+":
                return b + a;
            case "-":
                return b - a;
            case "*":
                return b * a;
            case "/":
                if (b == 0)
                    throw new RuntimeException("error: divide by zero");
                return b / a;
        }

        return 0;
    }


    //~ Conversion  methods ..........................................................


    /**
     * Converts infix to postfix.
     *
     * @param infixLiterals : an array containing the string literals in infix order.
     * The method assumes that each of these literals can be one of:
     * - "+", "-", "*", or "/"
     * - or a valid string representation of an integer.
     *
     * @return the expression in postfix order.
     * uses one stacks, taking an array, and one arraylist.this method has a worst case
     *      * of O(NM) which N is the numbers of elements in the Array, and M is the element get peek
     *      * or Popped from the stack. I chose the upper bound O(NM) because M could higher. This result
     *      * is obtained by one for loop with an while loop of N*M executions.
     *      *
     *      * optimality:
     *      * use of data structures of stack : push pop peak O(1)
     *      * no additional stack and reference of arrays save memory.
     **/
    public static String[] convertInfixToPostfix(String infixLiterals[])
    {

        Stack<String> stack = new Stack<>();
        ArrayList<String> postfix = new ArrayList<String>();


        for(int i=0;i<infixLiterals.length;i++){

            if(isInteger(infixLiterals[i])) {
                postfix.add(infixLiterals[i]);

            }
            if(infixLiterals[i].equals("(")){
                stack.push(infixLiterals[i]);

            }

            else if(isOperator(infixLiterals[i])) {
                if (!stack.isEmpty()) {
                    while (isOperator(stack.peek()) && !hasSameOrHigherOperatorPrecedence(stack.peek(), infixLiterals[i])) {


                        String op = stack.pop();
                        postfix.add(op);
                    }
                }
                    stack.push(infixLiterals[i]);

            }
	else if(infixLiterals[i].equals(")")){
                while(
                        stack.peek() != "("){

                    String op=stack.pop();
                    postfix.add(op);

                }
               stack.pop();
            }

        }
        while (!stack.isEmpty()){
            String operator=stack.pop();
            postfix.add(operator);

        }
        String[] arr = new String[postfix.size()];

        String[]postfixNew=postfix.toArray(arr);
        return postfixNew;

    }


    /**
     * Converts postfix to infix.
     *
     * @param postfixLiterals : an array containing the string literals in postfix order.
     * The method assumes that each of these literals can be one of:
     * - "+", "-", "*", or "/"
     * - or a valid string representation of an integer.
     *
     * @return the expression in infix order.
     * uses one stacks, taking an array, and one arraylist.this method has a worst case
     * of O(N+NM) which N is the numbers of elements in the Array, and M is the element that is
     *more than 1 decimal i.e. 10. I chose the upper bound O(N+NM) because M could higher. This result
     *is obtained by two different for loops with an while loop of N*M executions.
     *
     *optimality:
     *use of data structures of stack : push pop peak O(1)
     *no additional stack and reference of arrays save memory.
     **/
    public static String[] convertPostfixToInfix(String postfixLiterals[]) {
        Stack<String> s = new Stack<String>();
        for (int i = 0; i < postfixLiterals.length; i++) {
            // Push operands

            if (isInteger(postfixLiterals[i])) {
                s.push(postfixLiterals[i] + "");
            } else {
                String op1 = s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();

                s.push("(" + op2 + postfixLiterals[i] +
                        op1 + ")");
            }
        }

        String infix = s.peek();
        String newInfix=infix.substring(1, infix.length() - 1);
        ArrayList<String>arrayList=new ArrayList<String>();
        String str="";
        for(int i=0;i<newInfix.length();i++){

                if(i!=newInfix.length()-1&&(isInteger(Character.toString(newInfix.charAt(i))))) {

                    while (isInteger(Character.toString(newInfix.charAt(i)))) {
                        str = str + Character.toString(newInfix.charAt(i));
                        i++;

                    }
                    arrayList.add(str);
                    str="";
                    i--;
                }
                else {
                    arrayList.add(Character.toString(newInfix.charAt(i)));
                }
        }
        String[] infixAry = new String[arrayList.size()];

        String[]infixNew=arrayList.toArray(infixAry);
        return infixNew;
    }
}
//list of data structure stack and Arraylist;


