package guest_crud;

import guest_model.Condition;
import guest_model.IdSequence;
import guest_model.Writing;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CrudProcess {
	private final String namespace = "configurations.GuestMapper";
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
	public Integer updateIdSequence(IdSequence idSequence){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int result = -1;
		try{
			result = sqlSession.update(namespace + ".updateSequenceManager", idSequence);
			if(result > 0){ sqlSession.commit(); }
			else { sqlSession.rollback(); }
//			return result;
		}catch(Exception e){
			e.printStackTrace();
		}finally{ sqlSession.close(); }
		return result;
	}
	public Integer selectLastId(String name){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			Object result = sqlSession.selectOne(
					namespace + ".selectLastId", name);
			if(result == null){ return 0; }
			else { return Integer.parseInt(String.valueOf(result));}
		}finally{ sqlSession.close(); }
	}
	public Integer insertIdSequnce(IdSequence idSequence){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			
			int result = sqlSession.insert(namespace+".insertSequenceManager",idSequence);
			
			if(result > 0){ sqlSession.commit(); }
			else { sqlSession.rollback(); }
			return result;
		}finally{ sqlSession.close(); }
	}
	public Integer insertguestbookcontent(Writing writing){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			int result = sqlSession.insert(
					namespace + ".insertguestbookcontent", writing);
			if(result > 0) { sqlSession.commit(); }
			else{ sqlSession.rollback(); }
			return result;
		}finally{ sqlSession.close(); }
	}
	public Integer insertguestbookinfo(Writing writingInfo){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			int result = sqlSession.insert(namespace + ".insertguestbookinfo", writingInfo);
			if(result > 0) { sqlSession.commit(); }
			return result;
		}finally{ sqlSession.close(); }
	}
	public Integer selectMaxGroupId(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			Object result = sqlSession.selectOne(namespace+".selectMaxGroupId");
			if(result == null){
				return 0;
			}else{
				return Integer.parseInt(String.valueOf(result));
			}
		}finally{
			sqlSession.close();
		}
	}
	public List<Writing> selectWritingInfo(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			return sqlSession.selectList(namespace + ".selectBBSList");
		}finally{ sqlSession.close();}
	}
	public Writing selectOneWritingInfo(Writing writingid){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			return sqlSession.selectOne(
					namespace + ".selectWritingInfo", writingid);
		}finally{ sqlSession.close(); }
	}
	public String selectWritingContent(Writing writingid){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			return sqlSession.selectOne(
					namespace + ".seletWritingContent", writingid);
		}finally{ sqlSession.close(); }
	}
	 public Integer deleteWritingInfo(int writingid) {
	      
	      SqlSession sqlSession = getSqlSessionFactory().openSession();
	      
	      try {
	         int result = sqlSession.delete(namespace+".deleteWritingInfo", writingid);
	         
	         if(result > 0) {
	            sqlSession.commit();
	         }else {
	            sqlSession.rollback();
	         }
	         return result;
	         
	      }finally {
	         sqlSession.close();
	      }
	      
	   }
	   
	   public Integer deleteWritingContent(int writingid) {
	      
	      SqlSession sqlSession = getSqlSessionFactory().openSession();
	      
	      try {
	         int result = sqlSession.delete(namespace+".deleteWritingContent", writingid);
	      
	         if(result > 0) {
	            sqlSession.commit();
	         }else {
	            sqlSession.rollback();
	         }
	         return result;
	      
	      }finally {
	         sqlSession.close();
	  }
}
	    public Integer updateWritingInfo(Writing writing){
	    	SqlSession sqlSession = getSqlSessionFactory().openSession();
	    	try{
				int result = sqlSession.update(namespace+".updateWritingInfo", writing);
	    		if(result > 0) { sqlSession.commit(); }
	    		else { sqlSession.rollback(); }
	    		return result;
	    	}finally{ sqlSession.close(); }
	    }
	    public Integer updateWritingContent(Writing writing){
	    	SqlSession sqlSession = getSqlSessionFactory().openSession();
	    	try{
	    		String statement = namespace + ".updateWritingContent";
	    		System.out.println(statement);
	    		int result = sqlSession.update(statement, writing);
	    		if(result > 0) { sqlSession.commit(); }
	    		else { sqlSession.rollback(); }
	    		return result;
	    	}finally{ sqlSession.close(); }
	    }
	    public Integer selectMaxGroupIdReply(Writing writing){
	    	SqlSession sqlSession = getSqlSessionFactory().openSession();
	    	try{
	    		String statement = namespace + ".selectMaxGroupIdReply";
	    		Object result = sqlSession.selectOne(statement, writing);
	    		if(result == null) return 0;
	    		else return Integer.parseInt(String.valueOf(result));
	    	}finally{ sqlSession.close(); }
	    }
	    public Integer selectCount(String bandid){
	    	SqlSession sqlSession = getSqlSessionFactory().openSession();
	    	try{
	    		return sqlSession.selectOne(namespace + ".selectCount", bandid);
	    	}finally{ sqlSession.close(); }
	    }
	    public List<Writing> selectWritingInfoWithRange(Condition condition){
	    	SqlSession sqlSession = getSqlSessionFactory().openSession();
	    	try{
	    		String stmt = namespace + ".selectWritingInfoWithRange";
	    		return sqlSession.selectList(stmt, condition);
	    	}finally{ sqlSession.close(); }
	    }
	    public Integer updateOrderNoReply(Writing writing){
	    	SqlSession sqlSession = getSqlSessionFactory().openSession();
	    	try{
	    		String stmt = namespace + ".updateOrderNoReply";
	    		int result = sqlSession.update(stmt, writing);
	    		if(result > 0){ sqlSession.commit();}
	    		else { sqlSession.rollback();}
	    		return result;
	    	}finally {sqlSession.close();}
	    }
	    public Integer selectMaxOrderNo(Writing writing){
	    	SqlSession sqlSession = getSqlSessionFactory().openSession();
	    	try{
	    		String stmt = namespace + ".selectMaxOrderNo";
	    		Object result = sqlSession.selectOne(stmt, writing);
	    		if(result == null) {return 0; }
	    		else { return Integer.parseInt(String.valueOf(result)); }
	    	}finally{ sqlSession.close(); }
	    }
	}























