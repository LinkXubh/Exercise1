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
	 * 添加班级
	 * 
	 * @param banji
	 */
	public void addBanji(Banji banji) {
		schoolMap.put(banji.getClassName(), banji);
	}

	/**
	 * 删除班级
	 * 
	 * @param banji
	 */
	public void deleteBanji(Banji banji) {
		schoolMap.remove(banji.getClassName(), banji);
		System.out.println("删除成功！");
	}

	/**
	 * 通过班级名称查询班级
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
	 * 对各班语文成绩按平均分进行由大到小排序
	 */
	public void sortChineseByAverage() {
		Set<Entry<String,Banji>> set = this.schoolMap.entrySet();
		List<Entry<String,Double>> list = new ArrayList<Entry<String,Double>>();
		
	}

	/**
	 * 对各班数学成绩按平均分进行由大到小排序
	 */
	public void sortMathByAverage() {
	}

	/**
	 * 显示所有班级名称
	 */
	public void displayBanJiName() {
		System.out.println("所有班级名称：");
		for (String className : schoolMap.keySet()) {
			System.out.println(className);
		}
	}
}
