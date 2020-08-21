package com.xbh.schoolmanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class School {

	Map<String, Banji> schoolMap;

	public School() {
		schoolMap = new HashMap<String, Banji>();
	}

	public Map<String, Banji> getSchoolMap() {
		return schoolMap;
	}

	public void setSchoolMap(Map<String, Banji> schoolMap) {
		this.schoolMap = schoolMap;
	}

	/**
	 * ��Ӱ༶
	 * 
	 * @param banji
	 */
	public void addBanji(Banji banji) {
		schoolMap.put(banji.getClassName(), banji);
	}

	/**
	 * ɾ���༶
	 * 
	 * @param banji
	 */
	public void deleteBanji(Banji banji) {
		schoolMap.remove(banji.getClassName());
	}

	/**
	 * ͨ���༶���Ʋ�ѯ�༶
	 * 
	 * @param className
	 * @return
	 */
	public Banji searchByName(String className) {
		for (String str : this.schoolMap.keySet()) {
			if (str.equals(className))
				return schoolMap.get(str);
		}
		return null;
	}

	/**
	 * �Ը������ĳɼ���ƽ���ֽ����ɴ�С����
	 */
	public void sortChineseByAverage() {
		Map<String, Float> scoreMap = new HashMap<String, Float>();
		Set<String> classSet = schoolMap.keySet();
		// ��<�༶���ƣ�ƽ������>�ŵ�scoreMap��
		for (String className : classSet) {
			if (className.equals("��ѧ���б�"))
				continue;
			Banji banji = searchByName(className);
			// Banji banji = schoolMap.get(className);
			if (banji == null) {
				System.out.println("δ�ҵ��˰༶");
			} else {
				Iterator<Student> it = banji.getStuList().iterator();
				float score = 0.0f;
				int num = 0;
				while (it.hasNext()) {
					Student student = it.next();
					score += student.getChinese();
					num++;
				}
				scoreMap.put(banji.getClassName(), score / num);
			}
		}
		if (scoreMap.isEmpty()) {
			System.out.println("��û����Ӱ༶��");
			return;
		}
		// ��scoreMapתΪList�������
		List<Entry<String, Float>> scoreList = new ArrayList<Entry<String, Float>>(scoreMap.entrySet());
		Collections.sort(scoreList, new ScoreComparator());
		System.out.println("�������ĳɼ���ƽ���ֽ����ɴ�С����Ϊ��");
		for (Entry<String, Float> entry : scoreList) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	/**
	 * �Ը�����ѧ�ɼ���ƽ���ֽ����ɴ�С����
	 */
	public void sortMathByAverage() {
		Map<String, Float> scoreMap = new HashMap<String, Float>();
		Set<String> classSet = schoolMap.keySet();
		// ��<�༶���ƣ�ƽ������>�ŵ�scoreMap��
		for (String className : classSet) {
			if (className.equals("��ѧ���б�"))
				continue;
			Banji banji = searchByName(className);
			if (banji == null) {
				System.out.println("δ�ҵ��˰༶");
			} else {
				Iterator<Student> it = banji.getStuList().iterator();
				float score = 0.0f;
				int num = 0;
				while (it.hasNext()) {
					Student student = it.next();
					score += student.getMath();
					num++;
				}
				scoreMap.put(banji.getClassName(), score / num);
			}
		}
		if (scoreMap.isEmpty()) {
			System.out.println("��û����Ӱ༶��");
			return;
		}
		// ��scoreMapתΪList�������
		List<Entry<String, Float>> scoreList = new ArrayList<Entry<String, Float>>(scoreMap.entrySet());
		Collections.sort(scoreList, new ScoreComparator());
		System.out.println("������ѧ�ɼ���ƽ���ֽ����ɴ�С����Ϊ��");
		for (Entry<String, Float> entry : scoreList) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	/**
	 * ��ʾ���а༶����
	 */
	public void displayBanJiName() {
		System.out.println("���а༶���ƣ�");
		for (String className : schoolMap.keySet()) {
			if (!className.equals("��ѧ���б�"))
				System.out.println(className);
		}
	}
}
