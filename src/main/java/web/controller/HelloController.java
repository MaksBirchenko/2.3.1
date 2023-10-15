package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "index";
    }


    @GetMapping(value = "/cars")
    public String car(ModelMap model, @RequestParam(name = "count", required = false) Integer count) {
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("Mercedes", "White", 777);
        Car car2 = new Car("Bmw", "Black", 666);
        Car car3 = new Car("Audi", "Grey", 055);
        Car car4 = new Car("Opel", "Black", 531);
        Car car5 = new Car("Niva", "Blue", 351);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        model.addAttribute("cars", cars);
        if (count == null || count >= cars.size()) {
            model.addAttribute("cars", cars);
        } else {
            List<Car> selectedCars = cars.subList(0, count);
            model.addAttribute("cars", selectedCars);
        }

        return "car";
    }

}
