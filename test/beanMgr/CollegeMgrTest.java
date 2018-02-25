package beanMgr;

import java.util.List;

import org.junit.Test;

import beans.College;

public class CollegeMgrTest {
@Test	
public void testGetAll(){
	List<College> colleges=CollegeMgr.getAll();
	for(College college:colleges){
		System.out.println(college.getName());
	}
}
}