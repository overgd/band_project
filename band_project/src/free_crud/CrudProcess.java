package free_crud;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import free_model.Condition;
import free_model.IdSequence;
import free_model.Writing;

public class CrudProcess {
	private final String namespace = "configurations.FreeMapper";
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
		try{
			int result = sqlSession.update(
					namespace+".updateSequenceManager",idSequence);
			if(result > 0){ sqlSession.commit();}
			else { sqlSession.rollback();}
			return result;
		}finally{ sqlSession.close();}
	}
	public Integer selectLastId(String name){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			Object result = sqlSession.selectOne(
					namespace+".selectLastId", name);
			if(result == null){ return 0;}
			else { return Integer.parseInt(String.valueOf(result));}
		}finally{sqlSession.close();	}
	}
	public Integer insertIdSequence(IdSequence idSequence){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			int result = sqlSession.insert(
					namespace+".insertSequenceManager",idSequence);
			if(result > 0){  sqlSession.commit();}
			else { sqlSession.rollback(); }
			return result;
		}finally{	sqlSession.close();	}
	}
	public Integer insertWritingContent(Writing writing){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			int result = sqlSession.insert(
					namespace+".insertWritingContent",writing);
			if(result > 0){ sqlSession.commit();}
			else{ sqlSession.rollback();}
			return result;
		}finally{sqlSession.close();}
	}
	public Integer insertWritingInfo(Writing writingInfo){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			int result = sqlSession.insert(
					namespace+".insertWritingInfo",writingInfo);
			if(result > 0){ sqlSession.commit();}
			else{ sqlSession.rollback();}
			return result;
		}finally{ sqlSession.close();}
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
			return sqlSession.selectList(namespace+".selectBBSList");
								//글목록을 검색할 시 selectList 사용
		}finally{sqlSession.close();}
	}
	public Writing selectOneWritingInfo(int writingid){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			return sqlSession.selectOne(namespace+".selectWritingInfo",writingid);
		}finally{sqlSession.close();}
	}
	public String selectWritingContent(int writingid){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			return sqlSession.selectOne(namespace+".selectWritingContent",writingid);
		}finally{sqlSession.close();}
	}
	public Integer deleteWritingInfo(int  writingid){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			int result = sqlSession.delete(namespace+".deleteWritingInfo",writingid);
			if(result >0) sqlSession.commit();
			else sqlSession.rollback();
			return result;
		}finally{sqlSession.close();}
	}
	public Integer deleteWritingContent(int writingid){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			int result = sqlSession.delete(namespace+".deleteWritingContent",writingid);
			if(result >0) sqlSession.commit();
			else sqlSession.rollback();
			return result;
		}finally{sqlSession.close();}
	}
	public Integer updateWritingInfo(Writing writing){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			int result = sqlSession.update(namespace+".updateWritingInfo", writing);
			if(result > 0){sqlSession.commit();}
			else {sqlSession.rollback();}
			return result;
		}finally{sqlSession.close();}
	}
	public Integer updateWritingContent(Writing writing){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			int result = sqlSession.update(namespace+".updateWritingContent", writing);
			if(result > 0){sqlSession.commit();}
			else {sqlSession.rollback();}
			return result;
		}finally{sqlSession.close();}
	}
	public Integer selectMaxGroupIdReply(Writing writing){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			String statement = namespace+".selectMaxGroupIdReply";
			Object result = sqlSession.selectOne(statement, writing);
			if(result ==null) return 0;
			else return Integer.parseInt(String.valueOf(result));
		}finally{sqlSession.close();}
	}
	public Integer selectCount(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			return sqlSession.selectOne(namespace+".selectCount");
		}finally{sqlSession.close();}
	}
	public List<Writing> selectWritingInfoWithRange(Condition condition){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			String stmt = namespace + ".selectWritingInfoWithRange";
			return sqlSession.selectList(stmt,condition);
		}finally{sqlSession.close();}
	}
	public Integer updateOrderNoReply(Writing writing){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			String stmt = namespace+".updateOrderNoReply";
			int result = sqlSession.update(stmt,writing);
			if(result > 0){sqlSession.commit();}
			else {sqlSession.rollback();}
			return result;
		}finally{sqlSession.close();}
	}
	public Integer selectMaxOrderNo(Writing writing){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			String stmt = namespace+".selectMaxOrderNo";
			Object result = sqlSession.selectOne(stmt,writing);
			if(result == null){return 0;}
			else{return Integer.parseInt(String.valueOf(result));}
		}finally{sqlSession.close();}
	}
}









































