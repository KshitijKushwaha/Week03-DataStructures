import java.util.Arrays;
public class InsertionSort{

	public static void sort(int[] arr){
		int n = arr.length;
		for(int i=1; i<n; i++){
			int temp = arr[i];
			int j = i-1;
			while(j >= 0 && arr[j] > temp){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
	}
	
	public static void main(String[] a){
		int[] arr = {101,20,324,644,3453,12253,1422,13,211,23,535,114};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}