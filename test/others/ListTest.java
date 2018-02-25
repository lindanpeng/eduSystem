package others;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import beans.Time;


public class ListTest {
@Test
public void test(){
List<Time> times=new ArrayList<>();
Time time=new Time();
time.setTime("12345");
times.add(time);
time.setTime("23456");
System.out.println(time.getTime());
}
}
