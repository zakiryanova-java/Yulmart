package ru.itpark.util;

import ru.itpark.model.Product;

import java.util.Comparator;

public class ProductByRatingComparator implements Comparator<Product> {

    @Override
    public int compare(Product a, Product b) {
        if (a.getRating() == b.getRating())
            return 0;
        else if (a.getRating() < b.getRating())
            return 1;
        else
            return -1;
    }
}
