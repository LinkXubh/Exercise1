package com.xbh.schoolmanagement;

import java.util.ArrayList;
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
		this.stuList = new ArrayList<Student>();
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
		// 判断学生是否存在
		for (Student student : stuList) {
			if (student.equals(stu)) {
				System.out.println("学生：" + stu.getStuNum() + "在班级：" + this.getClassName() + "中已存在！");
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
		for (Student student : stuList) {
			if (student.getStuNum().equals(stuNum))
				return student;
		}
		return null;
	}

	/**
	 * 输入班级学生的语文成绩
	 * 
	 * @param stuNum
	 * @param score
	 */
	public void insertChineseScore(String stuNum, float score) {
		Student student = this.searchStudentByNum(stuNum);
		if (student == null)
			System.out.println("该学生不在此班级中");
		else
			student.setChinese(score);
	}

	/**
	 * 输入班级学生的数学成绩
	 * 
	 * @param stuNum
	 * @param score
	 */
	public void insertMathScore(String stuNum, float score) {
		Student student = this.searchStudentByNum(stuNum);
		if (student == null)
			System.out.println("该学生不在此班级中");
		else
			student.setMath(score);
	}

	/**
	 * 删除学生信息
	 * 
	 * @param stuNum
	 */
	public void deleteStudent(String stuNum) {
		Student student = this.searchStudentByNum(stuNum);
		if (student != null) {
			this.getStuList().remove(student);
			System.out.println("删除成功！");
		} else {
			System.out.println("没有找到学号为：" + stuNum + "的学生！");
		}

	}

	/**
	 * 显示所有学生的信息（包括学号和姓名）
	 */
	public void displayAllStudent() {
		System.out.println(this.getClassName() + "班级列表：");
		for (Student student : stuList) {
			System.out.println(student);
		}
	}

	@Override
	public String toString() {
		return "班级信息 ： [班级编号：" + classId + ", 班级名称：" + className + "]";
	}
}
