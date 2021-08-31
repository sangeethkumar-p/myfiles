package com.CodeLikeMe;

import java.util.Scanner;

public class Task {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		for(int i=1;i<=100;i++) {
			int sum=0;
			if(i<10 && i==n) {
				System.out.print(i+" ");
			}else {
				int res=i;
				while(res>0) {
				sum+=res%10;
				res/=10;
				}
				if(sum==n) {
					System.out.print(i+" ");
				}
				sum=0;	
			}		
		}
	} 
}
	