package me.test;

import me.RestApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by YiMing on 2016/11/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RestApplication.class)
@WebAppConfiguration
public class TestMain {

    @Test
    public  void test(){
        System.out.println("11111");
    }
}
