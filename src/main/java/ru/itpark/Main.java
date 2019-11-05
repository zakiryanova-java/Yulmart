package ru.itpark;

import ru.itpark.model.Product;
import ru.itpark.service.ProductService;
import ru.itpark.comparator.ProductByNameComparator;
import ru.itpark.comparator.ProductByRatingComparator;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        ProductService service = new ProductService();
        service.addAll(
                new Product(1, "Smartphones", "9Lite", "Honor", 15_990, 4.4),
                new Product(2, "PC", "Probook", "HP", 59_990, 4.0),
                new Product(3, "TV", "Ultra HD (4K) LED", "Samsung", 23_990, 3.8),
                new Product(4, "T-Shirts", "Disney", "ZARA", 1_990, 3.2),
                new Product(5, "Pots", "Flower", "Tek.A.Тek", 599, 3.1),
                new Product(6, "Pots", "Banana", "Tek.A.Тek", 299, 5.0),
                new Product(7, "Pots", "Disney", "Tek.A.Тek", 799, 2.9),
                new Product(8, "Pots", "Apple", "ChinChin", 199, 4.9)
        );
        int maxResults = 3;
        List<Product> resultName = service.searchByName("Disney");
        int totalMatches = resultName.size();
        if (totalMatches > maxResults) {
            resultName = resultName.subList(0, maxResults);
        }
        System.out.println("Unsorted list by name: " + resultName);
        resultName.sort(Product::compareTo);
        System.out.println("Sorted list by price: " + resultName);
        resultName.sort(new ProductByRatingComparator());
        System.out.println("Sorted list by rating: " + resultName);

        List<Product> resultCategory = service.searchByCategory("pots");
        int totalMatches2 = resultCategory.size();
        if (totalMatches2 > maxResults) {
            resultCategory = resultCategory.subList(0, maxResults);
        }
        System.out.println("Unsorted list by category: " + resultCategory);
        resultCategory.sort(new ProductByRatingComparator());
        System.out.println("Sorted list by rating: " + resultCategory);
        resultCategory.sort(Product::compareTo);
        System.out.println("Sorted list by price: " + resultCategory);
        resultCategory.sort(new ProductByNameComparator());
        System.out.println("Sorted list by name: " + resultCategory);

    }
}
