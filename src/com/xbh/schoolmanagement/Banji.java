package com.xbh.schoolmanagement;

import java.util.List;

public class Banji {
	private String classId;
	private String className;
	private List<Student> stuList;

	public Banji() {

	}

	public Banji(String classId, String className) {
		this.setClassId(classId);
		this.setClassName(className);
		this.stuList = null;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<Student> getStuList() {
		return stuList;
	}

	public void setStuList(List<Student> stuList) {
		this.stuList = stuList;
	}

	/**
	 * 将学生添加到班级
	 * 
	 * @param stu
	 */
	public void addStudent(Student stu) {
		for (Student student : stuList) {
			if (student.equals(stu)) {
				System.out.println("学生" + stu.getStuNum() + "在班级" + this.getClassId() + "中已存在！");
				return;
			}
		}
	stuList.add(stu);
	System.out.println("添加学生成功！");
	}

	/**
	 * 通过学号查询学生在班级中是否存在
	 * 
	 * @param stuNum
	 * @return
	 */
	public Student searchStudentByNum(String stuNum) {
		return null;
	}

	/**
	 * 输入班级学生的语文成绩
	 * 
	 * @param stuNum
	 * @param score
	 */
	public void insertChineseScore(String stuNum, float score) {

	}

	/**
	 * 输入班级学生的数学成绩
	 * 
	 * @param stuNum
	 * @param score
	 */
	public void insertMathScore(String stuNum, float score) {

	}

	/**
	 * 删除学生信息
	 * 
	 * @param stuNum
	 */
	public void deleteStudent(String stuNum) {

	}

	/**
	 * 显示所有学生的信息（包括学号和姓名）
	 */
	public void displayAllStudent() {

	}
}
