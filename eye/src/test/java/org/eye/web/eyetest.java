package org.eye.web;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class eyetest {
	
	private static Logger logger = Logger.getLogger(eyetest.class);
	
	@Inject
	private DataSource ds;
	
	@Inject
	ApplicationContext ctx;
	
	@Inject
	SqlSessionFactory sqlFactory;
	
	
	
	@Test
	public void testSession(){
		SqlSession sess = sqlFactory.openSession();
		
		logger.info(sess);
		
		String time = sess.selectOne("org.eye.TimeMapper.getTime");
		
		logger.info("---------------------------------------------");
		logger.info(time);
		logger.info("---------------------------------------------");
		
		sess.close();
	}

	@Test
	public void textCtx() {

		logger.info(ctx);

		Object obj = ctx.getBean("sqlSessionFactory");

		logger.info(obj);
	}
	
	@Test
	public void testLoading(){
		logger.info("test Loading...");
		
		logger.info(ds);
		
		try(Connection con = ds.getConnection()){
			logger.info(con);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
