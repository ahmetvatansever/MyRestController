package com.ahmetvatansever.mynewrestcontroller.service;

import com.ahmetvatansever.mynewrestcontroller.models.Car;

import java.util.List;

public interface CarService {

    //varsayılan public oldugu icin yazmamıza gerek yok
    Car create(Car car);

    Car update(Long id, Car carRequest);

    void delete(Long id);

    List<Car> getAllCars();

    Car getById(Long id);

    List<Car> getCarsWithPriceFilter(Double min, Double max);

}