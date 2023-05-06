package com.ahmetvatansever.mynewrestcontroller.controller;

import com.ahmetvatansever.mynewrestcontroller.models.Car;
import com.ahmetvatansever.mynewrestcontroller.service.CarService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarRestController {
    private final CarService carService;

    @Autowired
    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    /*
    @PostMapping --> Post methodu olduğunu ifade eder. Aynı zamanda hangi adreste yayınlanacağını tanımlayabiliyoruz.
    Şu şekilde bir tanımda yapabiliriz --> @PostMapping("/create")
    Ya da hiçbir değer vermeden şu şekilde de tanımlanabilir. --> @PostMapping
    */

    //@RequestBody --> Request olarak gelen json ile Car classının eşleştirilmesini sağlıyoruz
    @PostMapping("/create")
    public Car create(@Valid @RequestBody Car car) {
        return carService.create(car);
    }

    @PutMapping("/{id}")
    public Car update(@RequestBody @Valid Car car, @PathVariable Long id){
        return carService.update(id, car);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        carService.delete(id);
    }

    @GetMapping
    public List<Car> getAll() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public Car getById(@PathVariable Long id){
        return carService.getById(id);
    }

    @GetMapping(params = {"minPrice", "maxPrice"})
    public List<Car> getAllFilteredByPrice(
            //Parametreleri almak icin @RequestParam anatosyonunu kullanıyoruz.
            //required özelliği parametrenin gerekliliğini, defaultValue parametre null olduğunda alacağı değeri ifade eder
            //Aşağıdaki şekildede tanimlanabilir.
            //@RequestParam(value = "id", required = false, defaultValue = "1234") Long id
            @RequestParam Double minPrice,
            @RequestParam Double maxPrice
    ){
        return carService.getCarsWithPriceFilter(minPrice, maxPrice);
    }

}