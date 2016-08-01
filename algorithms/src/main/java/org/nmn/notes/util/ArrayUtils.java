package org.nmn.notes.util;

/**
 * Utility methods for array
 */
public final class ArrayUtils {

	public static void printArray(int [] arr) {
		System.out.print("(");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length-1) {
				System.out.print(",");
			}
		}
		System.out.println(")");
	}
}
