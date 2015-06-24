package qna_crud;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import qna_model.Id_sequence;
import qna_model.Qna_content;
import qna_model.Qna_info;

public class CrudProcess {
	
	private final String namespace = "configurations.QnaMapper";
	
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
	
	public Integer insertIdSequence(Id_sequence id_sequence) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try{
			
			String stmt = namespace+".insertIdSequence";
			
			int result = sqlsession.insert(stmt, id_sequence);
			
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
	
	public Integer insertQnaInfo(Qna_info qnainfo) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try{
			
			String stmt = namespace+".insertQnaInfo";
			
			int result = sqlsession.insert(stmt, qnainfo);
			
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
	
	public Integer insertQnaContent(Qna_content qnacontent) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try{
			
			String stmt = namespace+".insertQnaContent";
			
			int result = sqlsession.insert(stmt, qnacontent);
			
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
	
	public Qna_info selectQnaInfo(String band_id) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try {
			String stmt = namespace+".selectQnaInfo";

			Qna_info result = sqlsession.selectOne(stmt, band_id);
			
			if(result == null){
				return null;
			}else {
				return result;
			}
			
		}finally {
			sqlsession.close();
		}
		
	}
	
	public Qna_content selectQnaContent(String band_id) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try {
			String stmt = namespace+".selectQnaContent";

			Qna_content result = sqlsession.selectOne(stmt, band_id);
			
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
















