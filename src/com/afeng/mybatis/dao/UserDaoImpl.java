package com.afeng.mybatis.dao;

import com.afeng.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * 采用原生dao进行开发
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
    /**
     * 根据id查询对应用户
     * @param id 查询的用户id值
     * @return 查询到的user结果
     */
    @Override
    public User findUserById(Integer id) {
        //根据继承的模板 获取到实现的SQLSession对象
        SqlSession sqlSession = super.getSqlSession();
        //在这里不用将session对象关闭 因为SQLSessionFactory对象已经交给spring管理了
        return sqlSession.selectOne("queryUserById", 10);
    }
    /**
     * 保存用户
     * @param user 要保存的用户
     */
    @Override
    public void saveUser(User user) {
        //保存用户
        SqlSession sqlSession = super.getSqlSession();
        sqlSession.insert("saveUser", user);
        //在这里 也无需像之前的代码一样提交session
    }
}
