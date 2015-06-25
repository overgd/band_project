package guest_model;

import guest_crud.CrudProcess;

import java.sql.SQLException;

public class SequenceManager {
	public synchronized static int nextId(String tableName) throws SQLException {
		CrudProcess crud = new CrudProcess();
		int count = crud.selectLastId(tableName);
		System.out.println("sequencemanger count : ["+count+"]");
		if(count > 0){
			count = count + 1;
			System.out.println("count = count + 1:["+count+"]");
			IdSequence idSequence = new IdSequence();
			idSequence.setName(tableName);
			System.out.println("tablename:["+tableName+"]");
			idSequence.setLastid(count);
			System.out.println("count:["+count+"]");
			System.out.println("idsequence done");
			crud.updateIdSequence(idSequence); 
			System.out.println("sequencemanger return : ["+count+"]");
			return count;
		}else{
			
			IdSequence idSequence = new IdSequence();
			idSequence.setName(tableName);
			idSequence.setLastid(1);
			crud.insertIdSequnce(idSequence); 
			System.out.println("sequencemanager return : 1");
			return 1;
		}
	}
}
