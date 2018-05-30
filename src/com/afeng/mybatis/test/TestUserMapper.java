package com.afeng.mybatis.test;

import com.afeng.mybatis.mapper.UserMapper;
import com.afeng.mybatis.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class TestUserMapper {
    private ApplicationContext context;


    /**
     * 在每个test之前执行的初始化工作
     * 在这里也不是像之前的代码一样 无需写代码获取SqlSessionFactory对象
     * 只是需要加载在classpath下的applicationContext.xml文件即可
     */
    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    /**
     *
     */
    @Test
    public void testSelectUserById() {
        //使用context获取抽象类对应的bean对象
        UserMapper userMapper = this.context.getBean(UserMapper.class);
        User user = userMapper.findUserById(10);
        System.out.println(user);
    }

    /**
     *测试保存用户 并在保存之后获取用户的id值
     */
    @Test
    public void testSaveUser() {
        //使用context获取抽象类对应的bean对象
        UserMapper userMapper = this.context.getBean(UserMapper.class);
        User user = new User("15#303","0",new Date(),"HuaiBei Normal University");
        userMapper.saveUser(user);
        System.out.println(user);
    }
}
