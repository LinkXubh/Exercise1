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
		schoolMap.remove(banji.getClassName());
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
		Map<String, Float> scoreMap = new HashMap<String, Float>();
		Set<String> classSet = schoolMap.keySet();
		// 将<班级名称，平均分数>放到scoreMap中
		for (String className : classSet) {
			if (className.equals("主学生列表"))
				continue;
			Banji banji = searchByName(className);
			// Banji banji = schoolMap.get(className);
			if (banji == null) {
				System.out.println("未找到此班级");
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
			System.out.println("还没有添加班级！");
			return;
		}
		// 将scoreMap转为List排序输出
		List<Entry<String, Float>> scoreList = new ArrayList<Entry<String, Float>>(scoreMap.entrySet());
		Collections.sort(scoreList, new ScoreComparator());
		System.out.println("各班语文成绩按平均分进行由大到小排序为：");
		for (Entry<String, Float> entry : scoreList) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	/**
	 * 对各班数学成绩按平均分进行由大到小排序
	 */
	public void sortMathByAverage() {
		Map<String, Float> scoreMap = new HashMap<String, Float>();
		Set<String> classSet = schoolMap.keySet();
		// 将<班级名称，平均分数>放到scoreMap中
		for (String className : classSet) {
			if (className.equals("主学生列表"))
				continue;
			Banji banji = searchByName(className);
			if (banji == null) {
				System.out.println("未找到此班级");
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
			System.out.println("还没有添加班级！");
			return;
		}
		// 将scoreMap转为List排序输出
		List<Entry<String, Float>> scoreList = new ArrayList<Entry<String, Float>>(scoreMap.entrySet());
		Collections.sort(scoreList, new ScoreComparator());
		System.out.println("各班数学成绩按平均分进行由大到小排序为：");
		for (Entry<String, Float> entry : scoreList) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	/**
	 * 显示所有班级名称
	 */
	public void displayBanJiName() {
		System.out.println("所有班级名称：");
		for (String className : schoolMap.keySet()) {
			if (!className.equals("主学生列表"))
				System.out.println(className);
		}
	}
}
