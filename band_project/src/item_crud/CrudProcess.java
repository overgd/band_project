package item_crud;

import item_model.Album;
import item_model.Albumbbs;
import item_model.Id_sequence;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
	
	public Integer insertAlbumInfo(Album album){
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try{
			String stmt = namespace+".insertAlbumInfo";
			int result= sqlsession.insert(stmt, album);
			if(result>0){sqlsession.commit();
			}else{sqlsession.rollback();}
			return result;
		}finally{sqlsession.close();}
	}
	
	public Integer insertAlbumBBSInfo(Albumbbs albumbbs) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try{
			String stmt = namespace+".insertAlbumBBSInfo";
			int result= sqlsession.insert(stmt, albumbbs);
			if(result>0){sqlsession.commit();
			}else{sqlsession.rollback();}
			return result;
		}finally{sqlsession.close();}
		
	}
	
	public Integer selectLastAlbumId() {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try {
			
			String stmt = namespace+".selectLastAlbumId";
			Integer result = sqlsession.selectOne(stmt);
			
			if(result == null){
				return null;
			}else {
				return result;
			}
			
		}finally {
			sqlsession.close();
		}
	}
	
	public Id_sequence selectIdSequence(String table_name) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try {
			
			String stmt = namespace+".selectIdSequence";
			Id_sequence result = sqlsession.selectOne(stmt, table_name);
			
			if(result == null){
				return null;
			}else {
				return result;
			}
			
		}finally {
			sqlsession.close();
		}
	}
	
	public List selectAlbumBBSInfoToBandId(String band_id) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try {
			
			String stmt = namespace+".selectAlbumBBSInfoToBandId";
			List result = sqlsession.selectList(stmt, band_id);
			
			if(result == null){
				return null;
			}else {
				return result;
			}
		}finally {
			sqlsession.close();
		}
	}
	
	public List selectAlbumInfoToBandId(String band_id) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try {
			
			String stmt = namespace+".selectAlbumInfoToBandId";
			List result = sqlsession.selectList(stmt, band_id);
			
			if(result == null){
				return null;
			}else {
				return result;
			}
		}finally {
			sqlsession.close();
		}
	}
	
	public Integer insertIdSequence(Id_sequence idsequence) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try{
			String stmt = namespace+".insertIdSequence";
			int result= sqlsession.insert(stmt, idsequence);
			if(result>0){sqlsession.commit();
			}else{sqlsession.rollback();}
			return result;
		}finally{sqlsession.close();}
		
	}
	
	public Integer updateIdSequence(Id_sequence idsequence) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		try{
			String stmt = namespace+".updateIdSequence";
			int result= sqlsession.update(stmt, idsequence);
			if(result>0){sqlsession.commit();
			}else{sqlsession.rollback();}
			return result;
		}finally{sqlsession.close();}
		
	}
	
	public Album selectOneAlbumInfo(String album_id) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try {
			
			String stmt = namespace+".selectOneAlbumInfo";
			Album result = sqlsession.selectOne(stmt, album_id);
			
			if(result == null){
				return null;
			}else {
				return result;
			}
		}finally {
			sqlsession.close();
		}
	}
	
	public Albumbbs selectOneAlbumBBSInfo(String album_id) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try {
			
			String stmt = namespace+".selectOneAlbumBBSInfo";
			Albumbbs result = sqlsession.selectOne(stmt, album_id);
			
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
















