package com.exception.handling;
import java.util.*;
import java.lang.Exception;

public class ExceptionTest extends Throwable{
	public void getData() {
		try {
			int a =5;
			int b=0;
			int c=a/b;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("Nobody stops me..");
		}
	}
}
