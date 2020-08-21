package com.xbh.schoolmanagement;

import java.util.Comparator;
import java.util.Map.Entry;

public class ScoreComparator implements Comparator<Entry<String, Float>> {

	@Override
	public int compare(Entry<String, Float> o1, Entry<String, Float> o2) {
		return o2.getValue().compareTo(o1.getValue());
	}
}
