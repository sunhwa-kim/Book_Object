package com.sh.object.ch10.Instrumented;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		InstrumentedHashSet<String> languages = new InstrumentedHashSet<>();
		List<String> c = Arrays.asList("Java", "Ruby", "Kotlin");
		languages.addAll(c);

		System.out.println(languages.getAddCount());		// 6
		// System.out.println(languages.getAddCount()==3);   // false
	}
}
