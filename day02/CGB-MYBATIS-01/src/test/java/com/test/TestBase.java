package com.test;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBase {
	/**
	 * 借助此对象创建SqlSession(通过此对象
	 * 实现与数据库之间的会话)
	 */
	protected SqlSessionFactory factory;
    /**
     * 此方会在@Test注解修饰的方法之前执行,
     * 通常用于做一些初始化操作(方法名自己定义)
     */
	@Before
	public void init()throws IOException{
		factory=new SqlSessionFactoryBuilder()
				.build(
		Resources.getResourceAsStream(
				  "mybatis-configs.xml"));
	}
	@Test
	public void testSqlSessionFactory(){
		//测试factory是否不等于null
		Assert.assertNotEquals(
				null,//unexpected
				factory);//断言测试
		//假如factory不等于null则输出factory的值
		System.out.println(factory);
	}
	
	
}





