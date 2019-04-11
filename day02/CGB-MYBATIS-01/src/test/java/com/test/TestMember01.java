package com.test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.pt.member.entity.Member;

public class TestMember01 extends TestBase {
	@Test
	public void testInsertObject() {
			SqlSession session=
			factory.openSession();//默认事务是手动提交方式,操作执行结束需要手动提交
			//factory.openSession(true);//表示事务自动提交，执行完操作无需commit
			String statement="com.pt.member.dao.MemberDao.insertObject";
			Member m=new Member();
			m.setNickname("xiaoqiang");
			m.setRealname("zhaoqiang");
			m.setPassword("123456");
			m.setGender("MALE");
			m.setEmail("e1@t.com");
			m.setMobile("11111111111");
			m.setRank(1);
			m.setSafequestion("1+1=?");
			m.setSafeanswer("2");
	        m.setCreatedTime(new java.util.Date());
			int rows=session.insert(statement,m);
			System.out.println("rows="+rows);
			session.commit();
			session.close();
		}

	@Test
	public void testFindObjects(){
		//1.创建SqlSession对象(借助此对象与数据库交互)
		SqlSession session=factory.openSession();
		//2.执行查询操作(基于sqlsession通过名空间和元素id找sql)
		String namespace="com.pt.member.dao.MemberDao";
		String eId="findObjects";
		String statement=namespace+"."+eId;
		List<Member> list=
		session.selectList(statement);//底层jdbc操作
		//3.处理结果
		for(Member m:list){
			System.out.println(m);
		}
		//4.释放资源
		session.close();
	}
}







