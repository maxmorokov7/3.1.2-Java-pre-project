package web.Model;


import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Car {
    private String model;
    private int horsePower;
    private int year;

    public Car() {
    }

    public Car(String model, int horsePower, int year) {
        this.model = model;
        this.horsePower = horsePower;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static List<Car> getCarList() {
        Random rnd = new Random();
        List<Car> list = new ArrayList<>();
        list.add(new Car("BMW", rnd.nextInt(150, 350), rnd.nextInt(2000, 2024)));
        list.add(new Car("Honda", rnd.nextInt(50, 150), rnd.nextInt(2000, 2022)));
        list.add(new Car("Opel", rnd.nextInt(50, 180), rnd.nextInt(2000, 2018)));
        list.add(new Car("Nissan", rnd.nextInt(100, 150), rnd.nextInt(1990, 2010)));
        list.add(new Car("Porsche", rnd.nextInt(300, 500), rnd.nextInt(2005, 2023)));
        return list;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", horsePower=" + horsePower +
                ", year=" + year +
                '}';
    }

}

