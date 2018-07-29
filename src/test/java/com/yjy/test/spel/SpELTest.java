package com.yjy.test.spel;

import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpELTest {

    @Test
    public void test1() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'");
        String message = (String) exp.getValue();
        System.out.println(message);

        // concat
        exp = parser.parseExpression("'Hello World'.concat('!')");
        message = (String) exp.getValue();
        System.out.println(message);

        // invokes 'getBytes()'
        exp = parser.parseExpression("'Hello World'.bytes");
        byte[] bytes = (byte[]) exp.getValue();
        System.out.println(new String(bytes));

        // invokes 'getBytes().length'
        exp = parser.parseExpression("'Hello World'.bytes.length");
        int length = (Integer) exp.getValue();
        System.out.println(length);

        // Constructor
        exp = parser.parseExpression("new String('hello world').toUpperCase()");
        message = exp.getValue(String.class);
        System.out.println(message);
    }

    @Test
    public void testRelationalOperators() {
        ExpressionParser parser = new SpelExpressionParser();
        boolean result1 = parser.parseExpression("2 == 2").getValue(Boolean.class);
        System.out.println(result1);

        boolean result2 = parser.parseExpression("2 < -5.0").getValue(Boolean.class);
        System.out.println(result2);

        boolean result3 = parser.parseExpression("'black' < 'block'").getValue(Boolean.class);
        System.out.println(result3);
    }
}
