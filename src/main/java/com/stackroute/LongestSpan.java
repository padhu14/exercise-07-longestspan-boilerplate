package com.stackroute;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSpan {

	// Do not print anything other than what's expected/asked in problem
	public static void main(String[] args) {
		// Use Scanner to get input from console
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		String result = findLongestSpan(arr);
		if (result == "-1") {
			System.out.println("Empty Array");
		} else {
			System.out.println(result);
		}
	}

	public static String findLongestSpan(int[] numbers) {

		if (numbers == null || numbers.length == 0) {
			return "-1";
		}

		Map<Integer, Integer> first = new LinkedHashMap<Integer, Integer>();
		int maxspan = 0; // max span so far.
		int maxspanNumber = 0;
		for (int i = 0; i < numbers.length; i++) {
			int num = numbers[i];
			if (first.containsKey(num)) {
				int span = i - first.get(num) + 1;
				if (span == maxspan) {
					if (num > maxspanNumber) {
						maxspanNumber = num;
					}
				}
				if (span > maxspan) {
					maxspan = span;
					maxspanNumber = num;
				}
			} else {
				first.put(num, i);
			}
		}
		if (maxspanNumber == 0) {
			int max = Arrays.stream(numbers).max().getAsInt();
			return "" + max + ":1";
		}

		return "" + maxspanNumber + ":" + maxspan;

	}

}
