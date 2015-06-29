package sch_model;

import java.sql.SQLException;

import sch_crud.CrudProcess;

public class SequenceManager {
	public synchronized static int nextId(String tableName) throws SQLException {
		CrudProcess crud = new CrudProcess();
		int count = crud.selectLastId(tableName);
		if(count > 0){
			count = count + 1;
			IdSequence idSequence = new IdSequence();
			idSequence.setName(tableName);
			idSequence.setLastid(count);
			crud.updateIdSequence(idSequence); return count;
		}else{
			IdSequence idSequence = new IdSequence();
			idSequence.setName(tableName);
			idSequence.setLastid(1);
			crud.insertIdSequence(idSequence); return 1;
		}
	}
}






