package com.haotu.service;

import com.haotu.BaseTestNg;
import com.haotu.dao.HelloRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;

import javax.annotation.Resource;
import java.lang.reflect.Field;

public class HelloServiceImplTest extends BaseTestNg {
    @Resource
    private HelloService helloService;

    @Test
    public void testSayHello() throws Exception {
        HelloRepository mock = Mockito.mock(HelloRepository.class);
        Mockito.when(mock.queryById(1L)).thenReturn("hello mock");

//        Field helloRepository = helloService.getClass().getField("helloRepository");
//        helloRepository.setAccessible(true);
//        helloRepository.set(helloService, mock);

//        Class<?> targetClass = AopUtils.getTargetClass(helloService);
//        Field helloRepository1 = targetClass.getField("helloRepository");
//        helloRepository1.setAccessible(true);
//        helloRepository1.set(targetClass, mock);
        Object target = ((Advised) helloService).getTargetSource().getTarget();
        Field helloRepository = helloService.getClass().getSuperclass().getDeclaredField("helloRepository");
        helloRepository.setAccessible(true);
        helloRepository.set(target, mock);

        helloService.sayHello();
    }
}
