package web.controller;

import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String printWelcome(@RequestParam(name = "count", required = false, defaultValue = "5") int carNumber, ModelMap model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW 5", 2024, "white"));
        cars.add(new Car("Ford 2", 2018, "black"));
        cars.add(new Car("Subaru", 2022, "blue"));
        cars.add(new Car("KIA", 2023, "brown"));
        cars.add(new Car("Toyota", 2021, "white"));
        cars = CarService.getCars(cars, carNumber);
        model.addAttribute("carList", cars);
        return "cars";
    }
}
