package beanMgr;

import org.junit.Test;

import beans.User;

public class UserMgrTest {

	@Test
	public void testFind() {
		System.out.println(UserMgr.find("admin").getName());
	}
    @Test
    public void testChangePw(){

    	UserMgr.changePw("admin","123456");
    }
}
