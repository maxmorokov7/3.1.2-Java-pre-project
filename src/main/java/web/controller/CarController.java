package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

import web.Service.CarService;
import web.Service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
//@RequestMapping("/cars")
public class CarController {
    private CarService car;

    @Autowired
    public CarController(CarService car) {
        this.car = car;
    }

    @GetMapping("/cars")
    public String printCars(ModelMap model, Integer count) {
        model.addAttribute("Cars", car.getCars(count));
        return "cars";
    }

}
