package com.ahmetvatansever.mynewrestcontroller.service;

import com.ahmetvatansever.mynewrestcontroller.models.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarServiceImpl implements CarService{
    private List<Car> cars = new ArrayList<>(
            Arrays.asList(
                    new Car(1L,"i20", "Hyundai", 100, 15000d),
                    new Car(2L, "Golf", "Volkswagen", 120, 20000d),
                    new Car(3L, "Model 3", "Tesla", 140, 25000d),
                    new Car(4L, "Model S", "Tesla", 145, 29000d),
                    new Car(5L, "Model Y", "Tesla", 150, 30000d)
            )       );

    @Override
    public Car create(Car car) {
        Long newId = cars.stream().mapToLong(car_ -> Long.valueOf(car_.getId())).max().orElse(0L) + 1L;
        car.setId(newId);
        cars.add(car);
        return getById(car.getId());
    }

    @Override
    public Car update(Long id, Car carRequest) {
        Car carToBeUpdated = getById(id);
        carToBeUpdated.setBrand(carRequest.getBrand());
        carToBeUpdated.setHorses(carRequest.getHorses());
        carToBeUpdated.setModel(carRequest.getModel());
        carToBeUpdated.setPrice(carRequest.getPrice());
        return carToBeUpdated;
    }

    @Override
    public void delete(Long id) {
        boolean successfulDeletion = cars.removeIf(car -> car.getId().equals(id));
        if(!successfulDeletion){
            throw new NoSuchElementException();
        }
    }

    @Override
    public List<Car> getAllCars() {
        return cars;
    }

    @Override
    public Car getById(Long id) {
        return cars.stream()
                .filter(car -> car.getId().equals(id))
                .findAny()
                .orElseThrow();
    }

    @Override
    public List<Car> getCarsWithPriceFilter(Double min, Double max) {
        return cars.stream()
                .filter(car -> car.getPrice() >= min && car.getPrice() <= max)
                .toList();
    }

}
