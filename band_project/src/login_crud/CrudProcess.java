package login_crud;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import login_model.Band;
import login_model.Fan;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CrudProcess implements Serializable {
	
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
	
	public Integer insertFanUser(Fan fan) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try{
			
			String stmt = namespace+".insertFanUser";
			
			int result = sqlsession.insert(stmt, fan);
			
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
	
	public String selectBandUserID(String id) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try {
			String stmt = namespace+".selectBandUserID";
			String result = sqlsession.selectOne(stmt, id);
			if(result == null){
				return null;
			}else {
				return result;
			}
		}finally {
			sqlsession.close();
		}
		
	}
	
	public String selectFanUserID(String id) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try {
			String stmt = namespace+".selectFanUserID";
			String result = sqlsession.selectOne(stmt, id);
			if(result == null){
				return null;
			}else {
				return result;
			}
		}finally {
			sqlsession.close();
		}
		
	}
	
	public String selectLoginUserCheck(String id) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try {
			
			String stmt1 = namespace+".selectIDPasswordBandUser";
			String stmt2 = namespace+".selectIDPasswordFanUser";
			
			String result1 = sqlsession.selectOne(stmt1, "b."+id);
			String result2 = sqlsession.selectOne(stmt2, "f."+id);
			
			if(result1 != null) {
				return "BOK";
			}
			if(result2 != null) {
				return "FOK";
			}
			
			return null;
			
		}finally {
			sqlsession.close();
		}
		
	}
	
	public Fan selectFanUserInfo(String id) {
	
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try {
			String stmt = namespace+".selectFanUserInfo";
			Fan result = sqlsession.selectOne(stmt, "f."+id);
			
			if(result == null) {
				return null;
			}else {
				return result;
			}
		}finally {
			sqlsession.close();
		}
		
	}
	
	public Band selectBandUserInfo(String id) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try {
			String stmt = namespace+".selectBandUserInfo";
			Band result = sqlsession.selectOne(stmt, "b."+id);
			
			if(result == null) {
				return null;
			}else {
				return result;
			}
		}finally {
			sqlsession.close();
		}
		
	}
	
	public Integer updateFanUserInfo(Fan fan) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try{
			
			String stmt = namespace+".updateFanUserInfo";
			
			int result = sqlsession.insert(stmt, fan);
			
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
	
	public Integer updateBandUserInfo(Band band) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try{
			
			String stmt = namespace+".updateBandUserInfo";
			
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
	
	public Integer deleteFanUserInfo(String id) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try{
			
			String stmt = namespace+".deleteFanUserInfo";
			
			int result = sqlsession.delete(stmt, "f."+id);
			
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
	
	public Integer deleteBandUserInfo(String id) {
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		try{
			
			String stmt = namespace+".deleteBandUserInfo";
			
			int result = sqlsession.delete(stmt, "b."+id);
			
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
















