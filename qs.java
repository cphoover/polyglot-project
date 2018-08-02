import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    System.out.println("Quick Sort Demo:");
    int[] unsorted = new int[]{0, 1, 3, 45, 3, 12, 1, 23, 431, 432, 54, 6};
    int[] sorted = qs(unsorted);
    System.out.println("unsorted:" + Arrays.toString(unsorted));
    System.out.println("sorted:" + Arrays.toString(sorted));
  }
  
  public static int[] qs(int[] arr) {
    if (arr.length < 2) {
      return arr;
    }
    
    int pivot = arr[0];
    int[] rest = Arrays.copyOfRange(arr, 1, arr.length);
    
    List<Integer> left = new ArrayList<Integer>();
    List<Integer> right = new ArrayList<Integer>();

    for (int num: rest) {
      if (num <= pivot) {
        left.add(num);
      } else {
        right.add(num);
      }
    }

    int[] leftArray = qs(left.stream().mapToInt(i -> i).toArray());
    int[] rightArray = qs(right.stream().mapToInt(i -> i).toArray());

    int[] result = new int[leftArray.length + rightArray.length + 1]; // +1 for pivot
    System.arraycopy(leftArray, 0, result, 0, leftArray.length);
    result[leftArray.length] = pivot;
    System.arraycopy(rightArray, 0, result,  leftArray.length + 1, rightArray.length);
  	return result;
  }
}
