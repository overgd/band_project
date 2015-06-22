package band_crud;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import login_model.Band;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CrudProcess {
	
	private final String namespace = "configurations.SearchMapper";
	
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
	
	public List selectBandInfoToName(String name) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try {
			String stmt = namespace+".selectBandInfoToName";
			List<Band> result = sqlsession.selectList(stmt, name);
			if(result == null){
				return null;
			}else {
				return result;
			}
		}finally {
			sqlsession.close();
		}
		
	}

	
}
















