package com.xbh.schoolmanagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	private static final Scanner in = new Scanner(System.in);
	private static Banji mainClass = new Banji("mainClassList", "��ѧ���б�");
	private static School school = new School();

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
			System.out.println("�������Ӧ���ֽ��в���");
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
			System.out.println("�������Ӧ���ֽ��в���");
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
				break;
			case 2:
				System.out.println("���ѧ����Ϣ����ͨѧ���б�");
				break;
			case 3:
				System.out.println("ͨ��ѧ�Ų�ѯѧ����Ϣ");
				break;
			case 4:
				System.out.println("����༶�����ĳɼ�");
				break;
			case 5:
				System.out.println("����༶����ѧ�ɼ�");
				break;
			case 6:
				System.out.println("ɾ��ѧ����Ϣ");
				break;
			case 7:
				System.out.println("��ʾ����ѧ����Ϣ");
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
			System.out.println("�������Ӧ���ֽ��в���");
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
		System.out.println("������༶����");
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
			System.out.println("�༶ɾ���ɹ���");
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
			System.out.println("�ð༶�����ڣ�");
		else
			System.out.println(banji);
	}
}
