import java.util.ArrayList;

public class Basic{
	public static void main(String[] args) {
		// Basic.print1to255();
		// Basic.printOdds1to255();
		// Basic.intsAndSums255();
		// Basic.iterateAndPrint(new int[]{5,10,15,20});
		// Basic.printMax(new int[]{45,50,60,30});
		// Basic.printAvg(new int[]{50,60,70,80,90,100});
		// System.out.println(Basic.arrOdds1To255());
		// Basic.squareVals(new int[]{10,20,30,40,50});
		// Basic.greaterThanY(new int[]{5,10,15,20,25,30},20);
		// Basic.zeroNegatives(new int[]{10,20,-10,-20});
		// Basic.minMaxAvg(new int[]{12,14,16,18,20,2,4,6,8,10});
		// Basic.shiftValsLeft(new int[]{5,10,15,20,25,30});
		Basic.swapStringForNegatives(new int[]{20,30,-123,-456},"Hello");
	}
	// 1
	public static void print1to255(){
		for(int i=1; i<256; i++){
			System.out.println(i);
		}
	}
	// 2
	public static void printOdds1to255(){
		for(int i=1; i<256; i+= 2){
			System.out.println(i);
		}
	}
	// 3
	public static void intsAndSums255(){
		int sum = 0;

		for(int i=1;i<256;i++){
			sum += i;
		}

		System.out.println(sum);
	}
	// 4
	public static void iterateAndPrint(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	// 5
	public static void printMax(int[] arr){
		int max = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println(max);
	}
	// 6
	public static void printAvg(int[] arr){
		int avg = 0;

		for(int i = 0; i<arr.length; i++) avg+=arr[i];

		avg/=arr.length;
		System.out.println(avg);

	}
	// 7
	public static ArrayList<Integer> arrOdds1To255(){
		ArrayList<Integer> array = new ArrayList<Integer>();

		for (int i=1; i <256; i+=2){
			array.add(i);
		}

		return array;
	}
	// 8
	public static void squareVals(int[] arr){
		for(int i = 0; i< arr.length; i++){
			arr[i] = arr[i]*arr[i];
			System.out.println(arr[i]);
		}
	}
	// 9
	public static void greaterThanY(int[] arr,int y){
		for(int i = 0; i< arr.length; i++){
			if(arr[i] > y){
				System.out.println(arr[i]);
			}
		}
	}
	// 10
	public static void zeroNegatives(int[] arr){
		for (int i=0; i<arr.length; i++){
			if(arr[i]<0){
				arr[i]=0;
			}
			System.out.println(arr[i]);
		}
	}
	// 11
	public static void minMaxAvg(int[] arr){
		int sum=0;
		int min=arr[0];
		int max=min;
		for(int i=0; i<arr.length; i++){
			sum+=arr[i];
			if(arr[i] < min)
				min = arr[i];
			if(arr[i] > max)
				max = arr[i];
		}
		int average = sum/arr.length;
		System.out.println(min);
		System.out.println(max);
		System.out.println(average);
	}
	// 12
	public static void shiftValsLeft(int[] arr){
		for(int i=0; i<arr.length-1; i++){
			arr[i] = arr[i+1];
		}
		arr[arr.length -1] = 0;

		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}
	// 13
	public static void swapStringForNegatives(int[] arr,String str){
		ArrayList<Object> array = new ArrayList<Object>();

		for (int i = 0; i<arr.length; i++ ){
			if(arr[i] < 0){
				array.add(str);
			}
			else {
				array.add(arr[i]);
			}
		}

		System.out.println(array);
	}
}
