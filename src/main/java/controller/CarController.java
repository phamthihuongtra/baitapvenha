package controller;

import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.CarService;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    @Autowired
    public CarService carService;
    @GetMapping()
    public String car (Model model) {
        List<Car> carList = carService.getCarList();
        model.addAttribute("cars", carList);
        return ("/home");
    }
    @GetMapping("/add-car")
    public String showAddCarFrom(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);

        return ("/create");
    }
    @PostMapping("/create")
    public String createCar(@ModelAttribute Car car) {
        carService.createcar(car);

        return "redirect:/cars";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model){
        Car car = carService.getCarById(id);

        model.addAttribute("car", car);

        return "/edit";
    }

    @PostMapping("/update")
    public String updateCar(@ModelAttribute Car car) {
        carService.updateCar(car);
        return "redirect:/cars";
    }

}
