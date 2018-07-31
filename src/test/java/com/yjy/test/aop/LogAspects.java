package com.yjy.test.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class LogAspects {

    // 抽取公共的切入点表达式
    @Pointcut("execution(public int com.yjy.test.aop.MathCalculator.div(int, int))")
    public void pointCut() {
    }

    // JoinPoint一定要出现参数列表的第一位
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName() + "运行...参数列表{" + Arrays.asList(args) + "}");
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "结束...");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature().getName() + "正常返回...计算结果{" + result + "}");
    }

    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void logException(JoinPoint joinPoint, Exception e) {
        System.out.println(joinPoint.getSignature().getName() + "正常返回...异常信息{" + e + "}");
    }

}
