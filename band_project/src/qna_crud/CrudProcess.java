package qna_crud;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import login_model.Band;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import qna_model.Id_sequence;

public class CrudProcess {
	
	private final String namespace = "configurations.BandMapper";
	
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
	
	public Id_sequence selectIdSequence(String band_id) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try {
			String stmt = namespace+".selectIdSequence";
//			String table_name = band_id+".qna_info";
//			System.out.println(table_name);
			Id_sequence result = sqlsession.selectOne(stmt, "qna_info");
			
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
















