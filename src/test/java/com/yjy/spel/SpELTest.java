package com.yjy.spel;

import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpELTest {

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
