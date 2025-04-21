import java.util.Arrays;
public class CountingSort{

	public static void sort(int[] arr){
		int max = arr[0];
		for(int num : arr){
			if(num > max) max = num;
		}
		
		int[] count = new int[max + 1];
		
		for(int num : arr){
			count[num]++;
		}
		
		int index = 0;
		for(int i=0; i<=max; i++){
			while(count[i] > 0){
				arr[index++] = i;
				count[i] = 0;
			}
		}
	}
	
	public static void main(String[] a){
		int[] arr = {16,12,13,15,17,18};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}