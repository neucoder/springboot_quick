package com.haotu.service;

import com.haotu.BaseTestNg;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
/**
 * 表格文档注释
 *
 * <table>
 * <tr><th>列1</th><th>列2</th></tr>
 * <tr><td>值1</td><td>值2</td></tr>
 * </table>
 */
public class TestHelloService extends BaseTestNg {
    @Resource(name = "helloServiceImpl")
    private HelloService helloService;

    @Test
    public void testSayHello() {
        helloService.sayHello();
    }
}
