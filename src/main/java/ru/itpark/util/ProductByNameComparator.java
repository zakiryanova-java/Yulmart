package ru.itpark.util;

import ru.itpark.model.Product;

import java.util.Comparator;

public class ProductByNameComparator implements Comparator<Product> {

    @Override
    public int compare(Product a, Product b) {
        return a.getName().compareToIgnoreCase(b.getName());
    }
}

