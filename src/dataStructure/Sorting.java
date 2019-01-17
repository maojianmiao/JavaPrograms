package dataStructure;



public class Sorting {
	
	public static void main(String[] args) {
		int[] a = {1,2};
		BubbleSort(a);
		printArray(a);
	}
	
	public static void printArray(int[] a) {
		for (int item:a) {
			System.out.print(item +" ");
		}
	}
	
	static void BubbleSort(int[] a){
		int i =0,j=0,tmp=0;
		for (i=a.length-1;i>=0;i--)
			for (j=0;j<i;j++)
				if (a[j] > a[j+1]){
					tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
	}
	static void BubbleSort(String[] a){
			int i =0,j=0;
			String tmp="";
			for (i=a.length-1;i>=0;i--)
				for (j=0;j<i;j++)
					if (a[j].compareTo(a[j+1])>0){
						tmp = a[j];
						a[j] = a[j+1];
						a[j+1] = tmp;
					}
	}

	static void selectSort(int[] a){
		for (int i=0;i<a.length-1;i++){
			int m = i;
			for (int j=i+1;j<a.length;j++)
				if (a[m]>a[j])
					m = j;
			
			if (m != i){
				int tmp = a[i];
				a[i] = a[m];
				a[m] = tmp;
			}
		}
	}
	
	static void selectSort(String[] a){
		for (int i=0;i<a.length-1;i++){
			int m = i;
			for (int j=i+1;j<a.length;j++){
				if (a[m].compareTo(a[j])>0){
					m = j;
				}
			}
			if (m != i){
				String tmp = a[i];
				a[i] = a[m];
				a[m] = tmp;
			}
		}
	}
	
	static void insertSort(int[] a){
		for (int i =1; i<a.length;i++){
			int val = a[i];
			int j = i;
			while (j>0 &&val<a[j-1]){
				a[j] = a[j-1];
				j--;
			}
			a[j] = val;
		}
	}
	
	static void insertSort(String[] a){
		for (int i =1; i<a.length;i++){
			String val = a[i];
			int j = i;
			while (j>0 &&val.compareTo(a[j-1])<0){
				a[j] = a[j-1];
				j--;
			}
			a[j] = val;
		}
	}
	
	static void mergeSort(int [] a,int l,int r,int[] b){
		if (l <r){
			int mid = (l + r) / 2;
			mergeSort(a, l, mid, b);
			mergeSort(a, mid + 1, r, b);
			
			Program.merge(a, l, mid, a, mid + 1, r, b, l);
			for (int k = l;k<=r;k++)
				a[k] = b[k];
		}
	}
	
	static void quickSort(int[] a, int l, int r){
		int key = a[l];
		int i = l,j=l;
		
		while (i<r){
			for (i = l+1;i<=r;i++)
				if (a[i]<key){
					a[j] = a[i];
					a[i] = a[++j];
				}
			
			a[j] = key;
			quickSort(a, l, j-1);
			quickSort(a, j+1, r);
			System.out.println(" l: "+i);
		}
	}
} 