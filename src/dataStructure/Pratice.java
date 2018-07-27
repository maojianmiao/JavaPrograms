package dataStructure;

import javax.print.attribute.standard.RequestingUserName;

public class Pratice {
	///3.1
	public static boolean checkSort(int[] a, int left, int right){
		for (int i=left;i<right;i++)
			if (a[i]>a[i+1]){
				System.out.println("This array isn't a INS sorting");
				return false;
			}
		return true;
	}
	///3.2
	public static void reverse(int[] a,int left, int right){
		int sum = left + right;
		int mid = sum / 2;
		//int count = right - left + 1;
		//int v = count / 2;
		
		for (int i=left;i<=mid;i++){
			int tmp = a[i];
			a[i] = a[sum - i];
			a[sum - i] = tmp;
		}
	}
	
	///3.3
	public static boolean isPalndrome(char[] a,int left, int right){
		int sum = left + right;
		int mid = sum / 2;
		//int count = right - left + 1;
		//int v = count / 2;
		
		for (int i=left;i<=mid;i++)
			if (a[i] != a[sum -i])
				return false;
		return true;
	}
	
} //Class
