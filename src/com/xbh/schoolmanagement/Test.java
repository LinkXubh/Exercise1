package com.xbh.schoolmanagement;

public class Test {

	public void testStudent() {
		Student stu1 = new Student("S001", "С��");
		Student stu2 = new Student("S002", "С��");
		Student stu3 = new Student("S002", "С��");
		// ����toString()
		System.out.println(stu1);
		System.out.println(stu2);
		System.out.println(stu3);
		// �����ж�ѧ���Ƿ����
		System.out.println("stu1==stu2:" + (stu1.equals(stu2)));
		System.out.println("stu2==stu3:" + (stu2.equals(stu3)));
	}

	public void testBanji() {
		Student stu1 = new Student("S001", "С��");
		Student stu2 = new Student("S002", "С��");
		Student stu3 = new Student("S003", "С��");
		Student stu4 = new Student("S003", "С��");
		Banji banji1 = new Banji("B001", "һ��");
		Banji banji2 = new Banji("B001", "����");
		banji1.addStudent(stu1);
		banji1.addStudent(stu2);
		banji2.addStudent(stu3);
		banji2.addStudent(stu4);
		System.out.println("ɾ��ǰ");
		banji1.displayAllStudent();
		// banji2.displayAllStudent();
		// System.out.println("���ҽ��");
		// System.out.println(banji1.searchStudentByNum("S001"));
		// System.out.println(banji1.searchStudentByNum("S003"));
		banji1.deleteStudent("S001");
		banji1.deleteStudent("S003");
		System.out.println("ɾ����");
		banji1.displayAllStudent();
		System.out.println(banji1);
		System.out.println(banji2);
	}
	
	public void testSchool() {
		Student stu1 = new Student("S001", "С��");
		Student stu2 = new Student("S002", "С��");
		Student stu3 = new Student("S003", "С��");
		Student stu4 = new Student("S004", "С��");
		Banji banji1 = new Banji("B001", "һ��");
		Banji banji2 = new Banji("B001", "����");
		School school = new School();
		banji1.addStudent(stu1);
		banji1.addStudent(stu2);
		banji2.addStudent(stu3);
		banji2.addStudent(stu4);
		school.addBanji(banji1);
		school.addBanji(banji2);
		System.out.println("ɾ��ǰ");
		school.displayBanJiName();
		System.out.println(school.searchByName("һ��"));
		school.deleteBanji(banji1);
		System.out.println("ɾ����");
		school.displayBanJiName();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t = new Test();
		// t.testStudent();
		//t.testBanji();
		t.testSchool();
	}

}
