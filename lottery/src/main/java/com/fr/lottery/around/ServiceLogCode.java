package com.fr.lottery.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class ServiceLogCode {


    @Pointcut("execution(* com.fr.lottery.service.impl.*.*(..))")
    private void anyMethod() {
    }// 定义一个切入点

    @Around(value = "anyMethod()")
    public Object write(ProceedingJoinPoint pjp) throws Throwable {

//		System.out.println("请求方法:" + (pjp.getTarget().getClass().getName() + "." + pjp.getSignature().getName() + "()"));
//		System.out.println("target:"+pjp.getTarget());

//        if(pjp.getTarget() instanceof RacpServiceImpl){
//            MultipleDataSource.setDataSourceKey("racpPooledDataSourceID");
//        }
//        else   if(pjp.getTarget() instanceof XjServiceImpl){
//            MultipleDataSource.setDataSourceKey("xjPooledDataSourceID");
//        }
//        else   if(pjp.getTarget() instanceof PepServiceImpl){
//            MultipleDataSource.setDataSourceKey("pepPooledDataSourceID");
//        }
//        else{
            MultipleDataSource.setDataSourceKey("lottery_master");
//        }

        Object object = pjp.proceed();

        return object;

    }

}