package com.xbh.schoolmanagement;

public class Student {
	private String stuNum;
	private String stuName;
	private float math;
	private float chinese;

	public Student() {

	}

	public Student(String stuNum, String stuName) {
		setStuNum(stuNum);
		setStuName(stuName);
		setMath(0.0f);
		setChinese(0.0f);
	}

	public Student(String stuNum, String stuName, float math, float chinese) {
		setStuNum(stuNum);
		setStuName(stuName);
		setMath(math);
		setChinese(chinese);
	}

	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public float getMath() {
		return math;
	}

	public void setMath(float math) {
		this.math = math;
	}

	public float getChinese() {
		return chinese;
	}

	public void setChinese(float chinese) {
		this.chinese = chinese;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(chinese);
		result = prime * result + Float.floatToIntBits(math);
		result = prime * result + ((stuName == null) ? 0 : stuName.hashCode());
		result = prime * result + ((stuNum == null) ? 0 : stuNum.hashCode());
		return result;
	}

	/**
	 * 如果学号与姓名相等则学生相等
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj.getClass() == Student.class) {
			Student student = (Student) obj;
			return student.getStuNum().equals(this.getStuNum()) && student.getStuName().equals(this.getStuName());
		}
		return false;
	}

	@Override
	public String toString() {
		return "学生信息 ： [学号：" + stuNum + ", 姓名：" + stuName + "]";
	}

}
