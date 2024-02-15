package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import web.Service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
//@RequestMapping("/cars")
public class CarController {


    private CarServiceImpl car;

    @Autowired
    public CarController(CarServiceImpl car) {
        this.car = car;
    }

    @GetMapping("/cars")
    public String printCars(ModelMap model, Integer count) {
        model.addAttribute("Cars", car.getCars(count));
        return "cars";
    }

}
