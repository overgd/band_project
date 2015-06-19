package login_crud;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import login_model.Band;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CrudProcess {
	
	private final String namespace = "configurations.LoginMapper";
	
	private SqlSessionFactory getSqlSessionFactory(){
		
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try{
			inputStream = Resources.getResourceAsStream(resource);
		}catch(IOException e){
			throw new IllegalArgumentException(e);
		}
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		return builder.build(inputStream);
		
	}
	
	public Integer insertBandUser(Band band) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try{
			
			String stmt = namespace+".insertBandUser";
			
			int result = sqlsession.insert(stmt, band);
			
			if(result > 0) {
				sqlsession.commit();
			}else {
				sqlsession.rollback();
			}
			return result;
			
		}finally{
			sqlsession.close();
		}
	
	}
	
	public List selectBandUserID() {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try {
			String stmt = namespace+".selectBandUserID";
			List<String> result = sqlsession.selectList(stmt);
			return result;
		}finally {
			sqlsession.close();
		}
		
	}
	
	public List selectFanUserID() {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try {
			String stmt = namespace+".selectFanUserID";
			List<String> result = sqlsession.selectList(stmt);
			return result;
		}finally {
			sqlsession.close();
		}
		
	}
	
	public String selectLoginUserCheck(String id) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try {
			
			String stmt1 = namespace+".selectIDPasswordBandUser";
			String stmt2 = namespace+".selectIDPasswordFanUser";
			
			String result1 = sqlsession.selectOne(stmt1, id);
			String result2 = sqlsession.selectOne(stmt2, id);
			
			if(result1 != "") {
				return result1;
			}
			if(result2 != "") {
				return result2;
			}
			
			return null;
			
		}finally {
			sqlsession.close();
		}
		
	}
	
}
















