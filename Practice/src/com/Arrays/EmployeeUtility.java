package com.Arrays;
import java.util.*;

public class EmployeeUtility {
	private static Scanner sc;
	private EmployeeUtility() {}
	public static Scanner getScannerInstance() {
		if(sc==null) {
			sc=new Scanner(System.in);
		}
		return sc;
	}
}
