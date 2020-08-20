package com.xbh.schoolmanagement;

import java.util.ArrayList;
import java.util.HashMap;
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
		schoolMap.remove(banji.getClassName(), banji);
		System.out.println("ɾ���ɹ���");
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
		Set<Entry<String,Banji>> set = this.schoolMap.entrySet();
		List<Entry<String,Double>> list = new ArrayList<Entry<String,Double>>();
		
	}

	/**
	 * �Ը�����ѧ�ɼ���ƽ���ֽ����ɴ�С����
	 */
	public void sortMathByAverage() {
	}

	/**
	 * ��ʾ���а༶����
	 */
	public void displayBanJiName() {
		System.out.println("���а༶���ƣ�");
		for (String className : schoolMap.keySet()) {
			System.out.println(className);
		}
	}
}
