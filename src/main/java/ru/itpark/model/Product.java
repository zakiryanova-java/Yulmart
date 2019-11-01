package ru.itpark.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Product implements Comparable<Product> {
    private long id;
    private String category;
    private String name;
    private String brand;
    private int price;
    private double rating;


    public boolean equals(Product other) {
        return this.getPrice() == other.getPrice();
    }

    @Override
    public int compareTo(Product other) {
        if (this.equals(other))
            return 0;
        else if (getPrice() > other.getPrice())
            return 1;
        else
            return -1;
    }


}

