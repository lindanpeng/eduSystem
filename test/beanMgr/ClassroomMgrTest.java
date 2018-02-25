package beanMgr;

import java.util.List;

import org.junit.Test;

import beans.Classroom;

public class ClassroomMgrTest {
@Test
public void testGetAll(){
	List<Classroom> classrooms=ClassroomMgr.getAll();
	for(Classroom cr:classrooms){
		System.out.println(cr.getName());
	}
}
}
