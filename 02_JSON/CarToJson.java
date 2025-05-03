package org.example;


import com.google.gson.Gson;

class Car {
    private String brand;
    private String model;
    private int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
}

public class CarToJson {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 2022);

        Gson gson = new Gson();
        String json = gson.toJson(car);

        System.out.println("Car object as JSON:");
        System.out.println(json);
    }
}

