package com.xbh.schoolmanagement;

public class Test {

	public void testStudent() {
		Student stu1 = new Student("S001","小王");
		Student stu2 = new Student("S002","小红");
		Student stu3 = new Student("S002","小红");
		System.out.println(stu1);
		System.out.println(stu2);
		System.out.println(stu3);
		System.out.println("stu1==stu2:"+(stu1.equals(stu2)));
		System.out.println("stu2==stu3:"+(stu2.equals(stu3)));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t = new Test();
		t.testStudent();
	}

}
