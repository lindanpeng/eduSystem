package beanMgr;

import java.util.List;

import org.junit.Test;

import beans.Teacher;

public class TeacherMgrTest {
@Test
public void testGetList(){
	List<Teacher> teachers=TeacherMgr.getList(null, 0, 10);
	System.out.println(teachers);
}
@Test
public void testDel(){
	TeacherMgr.del("022016001");
}
@Test
public void testGeneratedId(){
	System.out.println(TeacherMgr.generateId());
}
}
