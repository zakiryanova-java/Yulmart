package ru.itpark.service;

import ru.itpark.model.Product;

import java.util.*;

public class ProductService {
    private final Collection<Product> products = new ArrayList<>();

    public void addAll(Product... products) {
        Collections.addAll(this.products, products);
    }

    public List<Product> searchByName(String name) {
        List<Product> list = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name))
                list.add(product);
        }
        return list;
    }

    public List<Product> searchByCategory(String category) {
        List<Product> list = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equalsIgnoreCase(category))
                list.add(product);
        }
        return list;
    }
}
