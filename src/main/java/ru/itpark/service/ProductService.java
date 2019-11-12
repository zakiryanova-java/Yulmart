package ru.itpark.service;

import ru.itpark.comparator.ProductByNameComparator;
import ru.itpark.comparator.ProductByRatingComparator;
import ru.itpark.model.Product;

import java.util.*;

public class ProductService {
    private final Collection<Product> products = new ArrayList<>();

    public void addAll(Product... products) {
        Collections.addAll(this.products, products);
    }

    public List<Product> searchByName(String name, String sortBy) {
        List<Product> list = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name))
                list.add(product);
        }
        if (sortBy.equals("Featured")) {
            Collections.sort(list, new ProductByRatingComparator());
        }
        if (sortBy.equals("Price - Low to High")) {
            Collections.sort(list, Product::compareTo);
        }
        return list;
    }

    public List<Product> searchByCategory(String category, String sortBy) {
        List<Product> list = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equalsIgnoreCase(category))
                list.add(product);
        }
        if (sortBy.equals("Featured")) {
            Collections.sort(list, new ProductByRatingComparator());
        }
        if (sortBy.equals("Price - Low to High")) {
            Collections.sort(list, Product::compareTo);
        }
        if (sortBy.equals("A-Z")) {
            Collections.sort(list, new ProductByNameComparator());
        }
        return list;
    }
}
