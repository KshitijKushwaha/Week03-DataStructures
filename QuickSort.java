import java.util.Arrays;
public class QuickSort{

	public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

	
	public static void main(String[] a){
		int[] arr = {99,199,349,299,249,149,599,999,1999,1199,234,456,745,36,6735,63,46,456,567,456,35,354,746,74,533};
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}