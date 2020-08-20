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
	 * ��ѧ����ӵ��༶
	 * 
	 * @param stu
	 */
	public void addStudent(Student stu) {
		for (Student student : stuList) {
			if (student.equals(stu)) {
				System.out.println("ѧ��" + stu.getStuNum() + "�ڰ༶" + this.getClassId() + "���Ѵ��ڣ�");
				return;
			}
		}
	stuList.add(stu);
	System.out.println("���ѧ���ɹ���");
	}

	/**
	 * ͨ��ѧ�Ų�ѯѧ���ڰ༶���Ƿ����
	 * 
	 * @param stuNum
	 * @return
	 */
	public Student searchStudentByNum(String stuNum) {
		return null;
	}

	/**
	 * ����༶ѧ�������ĳɼ�
	 * 
	 * @param stuNum
	 * @param score
	 */
	public void insertChineseScore(String stuNum, float score) {

	}

	/**
	 * ����༶ѧ������ѧ�ɼ�
	 * 
	 * @param stuNum
	 * @param score
	 */
	public void insertMathScore(String stuNum, float score) {

	}

	/**
	 * ɾ��ѧ����Ϣ
	 * 
	 * @param stuNum
	 */
	public void deleteStudent(String stuNum) {

	}

	/**
	 * ��ʾ����ѧ������Ϣ������ѧ�ź�������
	 */
	public void displayAllStudent() {

	}
}
