package week4;

public class BinarySearch {
	//1 2 5 8 11 15 20 25
	
	public static void main(String[] args) {
		int[] arr = {2, 2, 2, 5, 8, 11, 15, 20, 20};
		
		
		
		System.out.println(lowerBound(arr, 2));
	}
	
	public static int search(int[] arr, int target) {
		//low = 0 high = 7 - len = 7
		// low =3 high =7 - mid 5
		int low = 0;
		int high = arr.length - 1;
		
		while(low <= high) {
			//int mid =  (low + high) / 2;
			int mid = low + ((high - low) / 2);
			if (arr[mid] == target) {
				return mid;
			}
			else if (arr[mid] > target) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		
		}
		
		return -1;
	}
	
	public static int upperBound(int[] arr, int target) {
		int targetIndex = search(arr, target);
		
		if (targetIndex == -1) {
			return -1;
		}
		
		int result = -1;
		
		for (int i = targetIndex + 1; i < arr.length; i++) {
			if (arr[i] > arr[targetIndex]) {
				result = i;
				break;
			}
		}
		
		return result;
	}
	
	public static int lowerBound(int[] arr, int target) {
		int targetIndex = search(arr, target);
		
		if (targetIndex == -1) {
			return -1;
		}
		
		int result = -1;
		
		for (int i = targetIndex - 1; i >= 0; i--) {
			
			if (arr[i] < arr[targetIndex]) {
				result = i;
				break;
			}
		}
		
		return result;
	}
	
	
}
