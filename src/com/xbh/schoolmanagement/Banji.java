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
	 * ��ѧ����ӵ��༶
	 * 
	 * @param stu
	 */
	public void addStudent(Student stu) {
		// �ж�ѧ���Ƿ����
		for (Student student : stuList) {
			if (student.equals(stu)) {
				System.out.println("ѧ����" + stu.getStuNum() + "�ڰ༶��" + this.getClassName() + "���Ѵ��ڣ�");
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
		for (Student student : stuList) {
			if (student.getStuNum().equals(stuNum))
				return student;
		}
		return null;
	}

	/**
	 * ����༶ѧ�������ĳɼ�
	 * 
	 * @param stuNum
	 * @param score
	 */
	public void insertChineseScore(String stuNum, float score) {
		Student student = this.searchStudentByNum(stuNum);
		if (student == null)
			System.out.println("��ѧ�����ڴ˰༶��");
		else
			student.setChinese(score);
	}

	/**
	 * ����༶ѧ������ѧ�ɼ�
	 * 
	 * @param stuNum
	 * @param score
	 */
	public void insertMathScore(String stuNum, float score) {
		Student student = this.searchStudentByNum(stuNum);
		if (student == null)
			System.out.println("��ѧ�����ڴ˰༶��");
		else
			student.setMath(score);
	}

	/**
	 * ɾ��ѧ����Ϣ
	 * 
	 * @param stuNum
	 */
	public void deleteStudent(String stuNum) {
		Student student = this.searchStudentByNum(stuNum);
		if (student != null) {
			this.getStuList().remove(student);
			System.out.println("ɾ���ɹ���");
		} else {
			System.out.println("û���ҵ�ѧ��Ϊ��" + stuNum + "��ѧ����");
		}

	}

	/**
	 * ��ʾ����ѧ������Ϣ������ѧ�ź�������
	 */
	public void displayAllStudent() {
		System.out.println(this.getClassName() + "�༶�б�");
		for (Student student : stuList) {
			System.out.println(student);
		}
	}

	@Override
	public String toString() {
		return "�༶��Ϣ �� [�༶��ţ�" + classId + ", �༶���ƣ�" + className + "]";
	}
}
