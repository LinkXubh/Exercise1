package com.xbh.schoolmanagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	private static final Scanner in = new Scanner(System.in);
	private static Banji mainClass = new Banji("mainClassList", "主学生列表");
	private static School school = new School();

	static {
		school.addBanji(mainClass);
	}

	public void mainMenu() {
		System.out.println("***************************");
		System.out.println("      **主菜单**");
		System.out.println("      1--班级管理");
		System.out.println("      2--学校管理");
		System.out.println("      0--退出");
		System.out.println("***************************");
	}

	public void classMenu() {
		System.out.println("*************************************");
		System.out.println("      **班级管理**");
		System.out.println("      1--添加学生信息到主学生列表");
		System.out.println("      2--添加学生信息到普通学生列表");
		System.out.println("      3--通过学号查询学生信息");
		System.out.println("      4--输入班级的语文成绩");
		System.out.println("      5--输入班级的数学成绩");
		System.out.println("      6--删除学生信息");
		System.out.println("      7--显示所有学生信息");
		System.out.println("      9--返回上一级菜单");
		System.out.println("*************************************");
	}

	public void schoolMenu() {
		System.out.println("**************************************************");
		System.out.println("      **学校管理**");
		System.out.println("      1--创建班级");
		System.out.println("      2--删除班级");
		System.out.println("      3--通过班级名称查询班级信息");
		System.out.println("      4--对各班语文成绩按平均分进行由大到小排序");
		System.out.println("      5--对各班数学成绩按平均分进行由大到小排序");
		System.out.println("      6--显示所有班级名称");
		System.out.println("      9--返回上一级菜单");
		System.out.println("**************************************************");
	}

	/**
	 * 主菜单流程
	 */
	public void mainProcess() {
		int input = 0;
		while (true) {
			mainMenu();
			System.out.println("请输入对应数字进行操作");
			try {
				input = in.nextInt();
			} catch (InputMismatchException e) {
				in.next();
				System.out.println("输入的数据格式有误");
				continue;
			}
			if (input == 0) {
				System.out.println("退出程序");
				break;
			}
			switch (input) {
			case 1:
				System.out.println("班级管理");
				classProcess();
				break;
			case 2:
				System.out.println("学校管理");
				schoolProcess();
				break;
			default:
				System.out.println("输入有误，没有对应的操作");
			}
		}
		in.close();
	}

	/**
	 * 班级管理流程
	 */
	public void classProcess() {
		int input = 0;
		while (true) {
			classMenu();
			System.out.println("请输入对应数字进行操作");
			try {
				input = in.nextInt();
			} catch (InputMismatchException e) {
				in.next();
				System.out.println("输入的数据格式有误");
				continue;
			}
			if (input == 0)
				break;
			switch (input) {
			case 1:
				System.out.println("添加学生信息到主学生列表");
				break;
			case 2:
				System.out.println("添加学生信息到普通学生列表");
				break;
			case 3:
				System.out.println("通过学号查询学生信息");
				break;
			case 4:
				System.out.println("输入班级的语文成绩");
				break;
			case 5:
				System.out.println("输入班级的数学成绩");
				break;
			case 6:
				System.out.println("删除学生信息");
				break;
			case 7:
				System.out.println("显示所有学生信息");
				break;
			case 9:
				System.out.println("返回上一级菜单");
				return;
			default:
				System.out.println("输入有误，没有对应的操作");

			}
		}
	}

	/**
	 * 学校管理流程
	 */
	public void schoolProcess() {
		int input = 0;
		while (true) {
			schoolMenu();
			System.out.println("请输入对应数字进行操作");
			try {
				input = in.nextInt();
			} catch (InputMismatchException e) {
				in.next();
				System.out.println("输入的数据格式有误");
				continue;
			}
			if (input == 0)
				break;
			switch (input) {
			case 1:
				System.out.println("创建班级");
				createClass();
				break;
			case 2:
				System.out.println("删除班级");
				deleteClass();
				break;
			case 3:
				System.out.println("通过班级名称查询班级信息");
				searchClass();
				break;
			case 4:
				System.out.println("对各班语文成绩按平均分进行由大到小排序");
				school.sortChineseByAverage();
				break;
			case 5:
				System.out.println("对各班数学成绩按平均分进行由大到小排序");
				school.sortMathByAverage();
				break;
			case 6:
				System.out.println("显示所有班级名称");
				school.displayBanJiName();
				break;
			case 9:
				System.out.println("返回上一级菜单");
				return;
			default:
				System.out.println("输入有误，没有对应的操作");

			}
		}
	}

	/**
	 * 创建班级，无法创建已存在的班级
	 */
	public void createClass() {
		System.out.println("向学校中添加班级");
		System.out.println("请输入班级编号：");
		String classId = in.next();
		System.out.println("请输入班级名称：");
		String className = in.next();
		if (school.searchByName(className) == null) {
			Banji banji = new Banji(classId, className);
			school.addBanji(banji);
			System.out.println("班级创建成功!");
		} else {
			System.out.println("班级" + className + "已存在");
		}
	}

	/**
	 * 删除班级,无法删除主学生列表与不存在的班级
	 */
	public void deleteClass() {
		System.out.println("请输入班级名称");
		String className = in.next();
		if (className.equals("主学生列表")) {
			System.out.println("主学生列表不能删除");
			return;
		}
		Banji banji = school.searchByName(className);
		if (banji == null) {
			System.out.println("该班级不存在");
		} else {
			school.deleteBanji(banji);
			System.out.println("班级删除成功！");
		}
	}

	/**
	 * 输入班级名称查找班级
	 */
	public void searchClass() {
		System.out.println("请输入班级名称：");
		String className = in.next();
		Banji banji = school.searchByName(className);
		if (banji == null)
			System.out.println("该班级不存在！");
		else
			System.out.println(banji);
	}
}
