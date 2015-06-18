package item_crud;

import item_model.AInfo;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CrudProcess {
	
	private final String namespace = "configurations.AlbumMapper";
	
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
	
	public Integer insertAlbumInfo(AInfo ai){
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try{
			String stmt = namespace+".insertAlbumInfo";
			int result= sqlsession.insert(stmt,ai);
			if(result>0){sqlsession.commit();
			}else{sqlsession.rollback();}
			return result;
		}finally{sqlsession.close();}
	}
	
}
















