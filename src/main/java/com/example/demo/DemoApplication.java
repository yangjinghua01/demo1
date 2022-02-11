package com.example.demo;

import com.example.springbootenable.Config.EnableUser;
import com.example.springbootenable.Config.MyImporBeanDefinitionRegister;
import com.example.springbootenable.Config.MyImportSelect;
import com.example.springbootenable.Config.UserConfig;
import com.example.springbootenable.Pojo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.util.Map;

/**
 * @ComponentScan 扫描的范围是当前引导类所在包及其子包
 * com.example.demo;
 * com.example.springbootenable.Config;
 * 两者不具备包含关系
 * 解决方案如下
 * 1.使用@ComponentScan扫描com.example.springbootenable.Config这个包
 * 2.使用@improt注解这些类都会被spring创建并放入IOC容器
 * 3.对Import这个注解进行封装
 *
 */


/**
 * Improt的四种用法
 * 导入配置类
 * 导入ImportSelect的实现类
 * 导入ImporBeanDefinitionRegister实现类
 */

@SpringBootApplication
//@Import(UserConfig.class)
//@EnableUser
//@Import(User.class)
@Import(MyImporBeanDefinitionRegister.class)
//@Import(MyImportSelect.class)
public class DemoApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        Object user = context.getBean("user");
//        User bean = context.getBean(User.class);
//        System.out.println(bean);
        Map<String, User> beansOfType = context.getBeansOfType(User.class);
        System.out.println(beansOfType);
        System.out.println(user);
    }
}
