import java.util.Arrays;

public class SearchUtils {

   
    public static int linearSearch(Product[] arr, String targetName) {
        if (arr == null || targetName == null) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (targetName.equalsIgnoreCase(arr[i].getProductName())) {
                return i;
            }
        }
        return -1;
    }

    
    public static int binarySearch(Product[] sortedArr, String targetName) {
        if (sortedArr == null || targetName == null) {
            return -1;
        }
        int low = 0;
        int high = sortedArr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            Product midProd = sortedArr[mid];
            int cmp = midProd.getProductName().compareToIgnoreCase(targetName);
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void sortByName(Product[] arr) {
        if (arr != null) {
            Arrays.sort(arr); 
        }
    }
}
