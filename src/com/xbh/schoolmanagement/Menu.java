package com.xbh.schoolmanagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	private static final Scanner in = new Scanner(System.in);
	private static final Banji mainClass = new Banji("mainClassList", "��ѧ���б�");
	private static final School school = new School();

	static {
		school.addBanji(mainClass);
	}

	public void mainMenu() {
		System.out.println("***************************");
		System.out.println("      **���˵�**");
		System.out.println("      1--�༶����");
		System.out.println("      2--ѧУ����");
		System.out.println("      0--�˳�");
		System.out.println("***************************");
	}

	public void classMenu() {
		System.out.println("*************************************");
		System.out.println("      **�༶����**");
		System.out.println("      1--���ѧ����Ϣ����ѧ���б�");
		System.out.println("      2--���ѧ����Ϣ����ͨѧ���б�");
		System.out.println("      3--ͨ��ѧ�Ų�ѯѧ����Ϣ");
		System.out.println("      4--����༶�����ĳɼ�");
		System.out.println("      5--����༶����ѧ�ɼ�");
		System.out.println("      6--ɾ��ѧ����Ϣ");
		System.out.println("      7--��ʾ����ѧ����Ϣ");
		System.out.println("      9--������һ���˵�");
		System.out.println("*************************************");
	}

	public void schoolMenu() {
		System.out.println("**************************************************");
		System.out.println("      **ѧУ����**");
		System.out.println("      1--�����༶");
		System.out.println("      2--ɾ���༶");
		System.out.println("      3--ͨ���༶���Ʋ�ѯ�༶��Ϣ");
		System.out.println("      4--�Ը������ĳɼ���ƽ���ֽ����ɴ�С����");
		System.out.println("      5--�Ը�����ѧ�ɼ���ƽ���ֽ����ɴ�С����");
		System.out.println("      6--��ʾ���а༶����");
		System.out.println("      9--������һ���˵�");
		System.out.println("**************************************************");
	}

	/**
	 * ���˵�����
	 */
	public void mainProcess() {
		int input = 0;
		while (true) {
			mainMenu();
			System.out.println("�������Ӧ���ֽ��в�����");
			try {
				input = in.nextInt();
			} catch (InputMismatchException e) {
				in.next();
				System.out.println("��������ݸ�ʽ����");
				continue;
			}
			if (input == 0) {
				System.out.println("�˳�����");
				break;
			}
			switch (input) {
			case 1:
				System.out.println("�༶����");
				classProcess();
				break;
			case 2:
				System.out.println("ѧУ����");
				schoolProcess();
				break;
			default:
				System.out.println("��������û�ж�Ӧ�Ĳ���");
			}
		}
		in.close();
	}

	/**
	 * �༶��������
	 */
	public void classProcess() {
		int input = 0;
		while (true) {
			classMenu();
			System.out.println("�������Ӧ���ֽ��в�����");
			try {
				input = in.nextInt();
			} catch (InputMismatchException e) {
				in.next();
				System.out.println("��������ݸ�ʽ����");
				continue;
			}
			if (input == 0)
				break;
			switch (input) {
			case 1:
				System.out.println("���ѧ����Ϣ����ѧ���б�");
				addStudentToMainClass();
				break;
			case 2:
				System.out.println("���ѧ����Ϣ����ͨѧ���б�");
				addStudentToClass();
				break;
			case 3:
				System.out.println("ͨ��ѧ�Ų�ѯѧ����Ϣ");
				searchStudent();
				break;
			case 4:
				System.out.println("����༶�����ĳɼ�");
				chineseScore();
				break;
			case 5:
				System.out.println("����༶����ѧ�ɼ�");
				mathScore();
				break;
			case 6:
				System.out.println("ɾ��ѧ����Ϣ");
				deleteStudent();
				break;
			case 7:
				System.out.println("��ʾ����ѧ����Ϣ");
				displayClassStudent();
				break;
			case 9:
				System.out.println("������һ���˵�");
				return;
			default:
				System.out.println("��������û�ж�Ӧ�Ĳ���");
			}
		}
	}

	/**
	 * ѧУ��������
	 */
	public void schoolProcess() {
		int input = 0;
		while (true) {
			schoolMenu();
			System.out.println("�������Ӧ���ֽ��в�����");
			try {
				input = in.nextInt();
			} catch (InputMismatchException e) {
				in.next();
				System.out.println("��������ݸ�ʽ����");
				continue;
			}
			if (input == 0)
				break;
			switch (input) {
			case 1:
				System.out.println("�����༶");
				createClass();
				break;
			case 2:
				System.out.println("ɾ���༶");
				deleteClass();
				break;
			case 3:
				System.out.println("ͨ���༶���Ʋ�ѯ�༶��Ϣ");
				searchClass();
				break;
			case 4:
				System.out.println("�Ը������ĳɼ���ƽ���ֽ����ɴ�С����");
				school.sortChineseByAverage();
				break;
			case 5:
				System.out.println("�Ը�����ѧ�ɼ���ƽ���ֽ����ɴ�С����");
				school.sortMathByAverage();
				break;
			case 6:
				System.out.println("��ʾ���а༶����");
				school.displayBanJiName();
				break;
			case 9:
				System.out.println("������һ���˵�");
				return;
			default:
				System.out.println("��������û�ж�Ӧ�Ĳ���");
			}
		}
	}

	/**
	 * ���ѧ����Ϣ����ѧ���б�
	 */
	public void addStudentToMainClass() {
		int count = 0;
		System.out.println("������Ҫ���ѧ����Ϣ������");
		try {
			count = in.nextInt();
		} catch (InputMismatchException e) {
			in.next();
			System.out.println("��������ݸ�ʽ����ȷ");
			return;
		}
		for (int i = 1; i <= count; i++) {
			System.out.println("�������" + i + "��ѧ����Ϣ");
			System.out.println("������ѧ��ID:");
			String stuNum = in.next();
			System.out.println("������ѧ��������");
			String stuName = in.next();
			Student student = new Student(stuNum, stuName);
			mainClass.addStudent(student);
		}
		System.out.println("��ѧ���б�");
		mainClass.displayAllStudent();
	}

	/**
	 * ���ѧ������ͨѧ���б����ѧ������ѧ���б��д���ֱ�����
	 */
	public void addStudentToClass() {
		System.out.println("������Ҫ��ӵİ༶���ƣ�");
		String className = in.next();
		Banji banji = school.searchByName(className);
		if (banji == null) {
			System.out.println("δ��ѯ���˰༶");
			return;
		} else {
			int count = 0;
			System.out.println("������Ҫ���ѧ����Ϣ������");
			try {
				count = in.nextInt();
			} catch (InputMismatchException e) {
				in.next();
				System.out.println("��������ݸ�ʽ����ȷ");
				return;
			}
			for (int i = 1; i <= count; i++) {
				System.out.println("�������" + i + "��ѧ����Ϣ");
				System.out.println("������ѧ��ID:");
				String stuNum = in.next();
				Student student = mainClass.searchStudentByNum(stuNum);
				if (student == null) {
					System.out.println("��ѧ����Ϣ����ѧ���б��в����ڣ�������ѧ����������Ϣ");
					System.out.println("������ѧ��������");
					String stuName = in.next();
					student = new Student(stuNum, stuName);
					mainClass.addStudent(student);
				}
				banji.addStudent(student);
			}
			System.out.println("��ѧ���б�");
			mainClass.displayAllStudent();
			System.out.println(banji.getClassName() + "�༶�б�");
			banji.displayAllStudent();
		}
	}

	/**
	 * ͨ��ѧ�Ų�ѯѧ����Ϣ
	 */
	public void searchStudent() {
		System.out.println("������Ҫ��ѯ�İ༶���ƣ�");
		String className = in.next();
		Banji banji = school.searchByName(className);
		if (banji == null) {
			System.out.println("�ð༶������");
		} else {
			System.out.println("������Ҫ��ѯ��ѧ��ID��");
			String stuNum = in.next();
			Student student = banji.searchStudentByNum(stuNum);
			if (student == null)
				System.out.println("ѧ��" + stuNum + "��" + className + "������");
			else
				System.out.println(student);
		}
	}

	/**
	 * ����༶�����ĳɼ�
	 */
	public void chineseScore() {
		System.out.println("������༶�����ƣ�");
		String className = in.next();
		Banji banji = school.searchByName(className);
		if (banji == null) {
			System.out.println("�ð༶������");
		} else {
			float score = 0.0f;
			for (Student student : banji.getStuList()) {
				System.out.println("ѧ��id��" + student.getStuNum() + "ѧ������" + student.getStuName());
				System.out.println("������ѧ�����ĳɼ���");
				while (true) {
					try {
						score = in.nextFloat();
						if (score < 0.0f || score > 100.0f) {
							System.out.println("����ķ���������Ч��Χ��0-100�����������룺");
							continue;
						}
					} catch (InputMismatchException e) {
						in.next();
						System.out.println("��������ݸ�ʽ����ȷ���������룺");
						continue;
					}
					break;
				}
				banji.insertChineseScore(student.getStuNum(), score);
			}
		}
	}

	/**
	 * ����༶����ѧ�ɼ�
	 */
	public void mathScore() {
		System.out.println("������༶�����ƣ�");
		String className = in.next();
		Banji banji = school.searchByName(className);
		if (banji == null) {
			System.out.println("�ð༶������");
		} else {
			float score = 0.0f;
			for (Student student : banji.getStuList()) {
				System.out.println("ѧ��id��" + student.getStuNum() + "ѧ������" + student.getStuName());
				System.out.println("������ѧ����ѧ�ɼ���");
				while (true) {
					try {
						score = in.nextFloat();
						if (score < 0.0f || score > 100.0f) {
							System.out.println("����ķ���������Ч��Χ��0-100�����������룺");
							continue;
						}
					} catch (InputMismatchException e) {
						in.next();
						System.out.println("��������ݸ�ʽ����ȷ���������룺");
						continue;
					}
					break;
				}
				banji.insertMathScore(student.getStuNum(), score);
			}
		}
	}

	/**
	 * ɾ��ѧ����Ϣ
	 */
	public void deleteStudent() {
		System.out.println("������༶�����ƣ�");
		String className = in.next();
		Banji banji = school.searchByName(className);
		if (banji == null) {
			System.out.println("�ð༶������");
		} else {
			System.out.println("������ѧ��ID��");
			String stuNum = in.next();
			banji.deleteStudent(stuNum);
		}
	}

	/**
	 * ����༶���Ʋ�ѯ�༶������ѧ����Ϣ
	 */
	public void displayClassStudent() {
		System.out.println("������༶�����ƣ�");
		String className = in.next();
		Banji banji = school.searchByName(className);
		if (banji == null) {
			System.out.println("�ð༶������");
		} else {
			System.out.println(banji.getClassName() + "�༶�б�");
			banji.displayAllStudent();
		}
	}

	/**
	 * �����༶���޷������Ѵ��ڵİ༶
	 */
	public void createClass() {
		System.out.println("��ѧУ����Ӱ༶");
		System.out.println("������༶��ţ�");
		String classId = in.next();
		System.out.println("������༶���ƣ�");
		String className = in.next();
		if (school.searchByName(className) == null) {
			Banji banji = new Banji(classId, className);
			school.addBanji(banji);
			System.out.println("�༶�����ɹ�!");
		} else {
			System.out.println("�༶" + className + "�Ѵ���");
		}
	}

	/**
	 * ɾ���༶,�޷�ɾ����ѧ���б��벻���ڵİ༶
	 */
	public void deleteClass() {
		System.out.println("������༶���ƣ�");
		String className = in.next();
		if (className.equals("��ѧ���б�")) {
			System.out.println("��ѧ���б���ɾ��");
			return;
		}
		Banji banji = school.searchByName(className);
		if (banji == null) {
			System.out.println("�ð༶������");
		} else {
			school.deleteBanji(banji);
			System.out.println("�༶ɾ���ɹ�");
		}
	}

	/**
	 * ����༶���Ʋ��Ұ༶
	 */
	public void searchClass() {
		System.out.println("������༶���ƣ�");
		String className = in.next();
		Banji banji = school.searchByName(className);
		if (banji == null)
			System.out.println("�ð༶������");
		else
			System.out.println(banji);
	}
}
