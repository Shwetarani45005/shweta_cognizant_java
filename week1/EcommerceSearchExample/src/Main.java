public class Main {
    public static void main(String[] args) {
        // Sample products
        Product[] products = new Product[] {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Smartphone", "Electronics"),
            new Product(103, "Book", "Books"),
            new Product(104, "Headphones", "Electronics"),
            new Product(105, "Coffee Mug", "Kitchen")
        };

        String searchName = "Headphones";

       
        System.out.println("=== Linear Search ===");
        int idxLinear = SearchUtils.linearSearch(products, searchName);
        if (idxLinear >= 0) {
            System.out.println("Found via linear search at index " + idxLinear + ": " + products[idxLinear]);
        } else {
            System.out.println("Not found via linear search: " + searchName);
        }

       
        Product[] sortedByName = products.clone();
        SearchUtils.sortByName(sortedByName);
        System.out.println("\nSorted products by name:");
        for (Product p : sortedByName) {
            System.out.println(p);
        }

   
        System.out.println("\n=== Binary Search ===");
        int idxBinary = SearchUtils.binarySearch(sortedByName, searchName);
        if (idxBinary >= 0) {
            System.out.println("Found via binary search at index " + idxBinary + ": " + sortedByName[idxBinary]);
        } else {
            System.out.println("Not found via binary search: " + searchName);
        }

    
        System.out.println("\n=== Timing Comparison (illustrative) ===");
        long start = System.nanoTime();
        SearchUtils.linearSearch(products, "NonExistingProduct");
        long end = System.nanoTime();
        System.out.println("Linear search time (unsuccessful) ~ " + (end - start) + " ns");

        start = System.nanoTime();
        SearchUtils.binarySearch(sortedByName, "NonExistingProduct");
        end = System.nanoTime();
        System.out.println("Binary search time (unsuccessful) ~ " + (end - start) + " ns");
        

        System.out.println("\n=== Best/Worst Cases Illustration ===");
        
        String firstName = products[0].getProductName();
        System.out.println("Linear search best-case target: " + firstName +
                           ", index: " + SearchUtils.linearSearch(products, firstName));
    
        System.out.println("Linear search worst-case target (not present): " +
                           SearchUtils.linearSearch(products, "XYZ"));
        
        int mid = sortedByName.length / 2;
        String midName = sortedByName[mid].getProductName();
        System.out.println("Binary search best-case target: " + midName +
                           ", index: " + SearchUtils.binarySearch(sortedByName, midName));
        System.out.println("Binary search worst-case target (not present): " +
                           SearchUtils.binarySearch(sortedByName, "XYZ"));
    }
}
