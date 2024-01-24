package service;

import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CarRepository;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getCarList() {
        return carRepository.getCarList();
    }
    public void createcar(Car car) {
        carRepository.createCar(car);
    }
    public Car getCarById(int id) {
        return carRepository.getCarById(id);
    }
    public void updateCar(Car car){
        carRepository.updateCar(car);
    }
}
