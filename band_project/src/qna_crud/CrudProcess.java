package qna_crud;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
	
	public List selectQnaInfo(String band_id) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try {
			String stmt = namespace+".selectQnaInfo";

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
	
	public List selectQnaContent(String band_id) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try {
			String stmt = namespace+".selectQnaContent";

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
	
	public Integer updateIdSequence(Id_sequence id_sequence) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try{
			
			String stmt = namespace+".updateIdSequence";
			
			int result = sqlsession.update(stmt, id_sequence);
			
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
	
	public Integer deleteQnaInfo(Qna_info qnainfo) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try{
			
			String stmt = namespace+".deleteQnaInfo";
			
			int result = sqlsession.delete(stmt, qnainfo);
			
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
	
	public Integer deleteQnaContent(Qna_info qnainfo) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try{
			
			String stmt = namespace+".deleteQnaContent";
			
			int result = sqlsession.delete(stmt, qnainfo);
			
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
	
	public Integer selectCountQnaInfo(String band_id) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try {
			String stmt = namespace+".selectCountQnaInfo";

			Integer result = sqlsession.selectOne(stmt, band_id);
			
			if(result == null){
				return null;
			}else {
				return result;
			}
			
		}finally {
			sqlsession.close();
		}
		
	}
	
	public Integer updateQnaInfo(Qna_info qnainfo) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try{
			
			String stmt = namespace+".updateQnaInfo";
			
			int result = sqlsession.update(stmt, qnainfo);
			
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
	
	public Integer updateQnaContent(Qna_content qnacontent) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try{
			
			String stmt = namespace+".updateQnaContent";
			
			int result = sqlsession.update(stmt, qnacontent);
			
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

}
















