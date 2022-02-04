package com.pack;
import java.util.Scanner;
public class Student{
	
	public static void main(String[] args) {
		int [] id = new int[5];
		String [] name = new String[5];
		int [] hindi = new int[5];
		int [] eng = new int[5];
		int [] maths = new int[5];
		int [] science = new int[5];
		int [] social = new int[5];
		int [] result = new int[5];
		int [] percentage = new int[5];
		boolean p = true;
		while(p){
		System.out.println("WELCOME TO COLLEGE MANAGEMENT");
		System.out.println("A: Add Student Result");
		System.out.println("X: Exit");
		System.out.println("C: Check student result");
		
		String ch;
		Scanner sc = new Scanner(System.in);
		ch = sc.next().toUpperCase();
		
		if(ch.equals("X")) {
			System.out.println("BYE");
			p= false;
		}
		else if(ch.equals("A")) {
			System.out.println("Enter student id");
			int x = sc.nextInt();
			id[x-1]=1;
			System.out.println("Enter marks in Hindi");
			hindi[x-1] = sc.nextInt();
			System.out.println("Enter marks in English");
			eng[x-1] = sc.nextInt();
			System.out.println("Enter marks in maths");
			maths[x-1] = sc.nextInt();
			System.out.println("Enter marks in science");
			science[x-1] = sc.nextInt();
			System.out.println("Enter marks in social science");
			social[x-1] = sc.nextInt();
			
			percentage[x-1]=((hindi[x-1]+eng[x-1]+maths[x-1]+science[x-1]+social[x-1])*100)/500;
			if(percentage[x-1] > 35)
				result[x-1] = 1;
			else
				result[x-1] = 0;
			System.out.println("Do you want to continue?(1/0)");
			int d = sc.nextInt();
			if(d==1)
				p = true;
			else
				p = false;	
		}
		else if(ch.equals("C")) {
			System.out.println("Enter student id");
			int x = sc.nextInt();
			if(id[x-1]==0) {
				System.out.println("Student id not found");
			}
			else {
				System.out.println(name[x-1] +" Hindi= " + hindi[x-1] + " english= " +eng[x-1] +" maths= " + 
			maths[x-1] +"science= " + science[x-1]+ " social science= " + social[x-1] +"Percentage= " + percentage[x-1]);
				if(percentage[x-1] > 35)
					System.out.println("Pass");
				else
					System.out.println("Fail");
				
				System.out.println("Do you want to continue?(1/0)");
				int y= sc.nextInt();
				if(y==0) {
					System.out.println("BYE");
					p = false;
					}				
				else
					p=true;
			}
		}
		
		}
		
		
		}
		
		

	}

