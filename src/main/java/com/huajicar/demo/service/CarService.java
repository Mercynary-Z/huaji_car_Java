package com.huajicar.demo.service;

import com.huajicar.demo.entity.Car;

import java.util.List;

public interface CarService {
    List<String> getCarProperty(String property);

    List<Car> getNRandomCar(int num);

    List<Car> getCarByCondition(String car_brand,String car_type,String car_age,String car_shift,
                                String car_color,String car_fuel,Integer price_min,Integer price_max);

    Car getCarById(int id);

    int addNewCar(Car car);

    void updateCarImg(String image_path,int id);

    int getCount();
}
