package dataStructure;

public class test {
	
	public static void rec(int i){
		int j;
		if (i >8)
			System.out.println("this is:" + i);
		else{
			for (j=0;j<8;j++){
			System.out.println("Before:" + i + " J: " + j);
			rec(i+1);
			System.out.println("Later:" + i+ " J: " + j);
			}
		}
		System.out.println("Latest:" + i);
	}

}
