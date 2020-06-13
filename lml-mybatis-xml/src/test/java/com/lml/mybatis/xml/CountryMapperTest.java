package com.lml.mybatis.xml;

import com.alibaba.fastjson.JSON;
import com.lml.mybatis.xml.model.Country;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.Reader;
import java.util.List;

class CountryMapperTest {

    private static SqlSessionFactory sqlSessionFactory;

    @BeforeEach
    void setUp() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testSelectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Country> list = sqlSession.selectList("selectAll");
            System.out.println(JSON.toJSONString(list));
        } finally {
            sqlSession.close();
        }
    }

    @Test
    void testSelectById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.selectOne("selectById", 2L);
        } finally {
            sqlSession.close();
        }
    }
}