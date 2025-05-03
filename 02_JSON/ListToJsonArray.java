package org.example;

import com.google.gson.Gson;
import java.util.List;
import java.util.ArrayList;

class Cars{
    private String brand;
    private String model;
    private int year;

    public Cars(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
}

public class ListToJsonArray {
    public static void main(String[] args) {
        List<Cars> cars = new ArrayList<>();
        cars.add(new Cars("Toyota", "Camry", 2022));
        cars.add(new Cars("Honda", "Civic", 2023));
        cars.add(new Cars("Ford", "Mustang", 2024));

        Gson gson = new Gson();
        String jsonArray = gson.toJson(cars);

        System.out.println(jsonArray);
    }
}

