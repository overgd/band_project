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
	
}
















