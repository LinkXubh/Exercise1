package com.xbh.schoolmanagement;

public class Student {
	private String stuNum;
	private String stuName;
	private float math;
	private float chinese;

	public Student() {

	}

	/**
	 * 双参构造参数，分数默认为0
	 * 
	 * @param stuNum
	 * @param stuName
	 */
	public Student(String stuNum, String stuName) {
		this.setStuNum(stuNum);
		this.setStuName(stuName);
		this.math = 0.0f;
		this.chinese = 0.0f;
	}

	/*
	 * public Student(String stuNum, String stuName, float math, float chinese) {
	 * this.setStuNum(stuNum); this.setStuName(stuName); this.setMath(math);
	 * this.setChinese(chinese); }
	 */

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
		// 分数有效区间为[0,100]，区间外默认为0
		if (math >= 0.0f && math <= 100.0f)
			this.math = math;
		else {
			System.out.println("超出分数有效范围0-100，默认为0");
			this.math = 0.0f;
		}
	}

	public float getChinese() {
		return chinese;
	}

	public void setChinese(float chinese) {
		// 分数有效区间为[0,100]，区间外默认为0
		if (chinese >= 0.0f && chinese <= 100.0f)
			this.chinese = chinese;
		else {
			System.out.println("超出分数有效范围0-100，默认为0");
			this.chinese = 0.0f;
		}
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
			return student.getStuNum().equals(this.getStuNum());
		}
		return false;
	}

	@Override
	public String toString() {
		return "学生信息 ： [学号：" + stuNum + ", 姓名：" + stuName + "]";
	}

}
