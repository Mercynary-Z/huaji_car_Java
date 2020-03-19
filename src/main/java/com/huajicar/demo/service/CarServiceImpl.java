package com.huajicar.demo.service;

import com.huajicar.demo.entity.Car;
import com.huajicar.demo.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarMapper carMapper;

    @Override
    public List<String> getCarProperty(String property) {
        return carMapper.getProperty(property);
    }

    @Override
    public List<Car> getNRandomCar(int num) {
        return carMapper.getCarRandom(num);
    }

    @Override
    public List<Car> getCarByCondition(String car_brand, String car_type, String car_age, String car_shift, String car_color, String car_fuel, Integer price_min, Integer price_max) {
        Map<String, Object> map = new HashMap<>();
        if(car_brand!=null&&car_brand.equals("全部")){
            car_brand=null;
        }
        if(car_type!=null&&car_type.equals("全部")){
            car_type=null;
        }
        if(car_shift!=null&&car_shift.equals("全部")){
            car_shift=null;
        }
        if(car_age!=null&&car_age.equals("全部")){
            car_age=null;
        }
        if(car_color!=null&&car_color.equals("全部")){
            car_color=null;
        }
        if(car_fuel!=null&&car_fuel.equals("全部")){
            car_fuel=null;
        }
        map.put("car_brand",car_brand);
        map.put("car_type",car_type);
        map.put("car_age",car_age);
        map.put("car_shift",car_shift);
        map.put("car_color",car_color);
        map.put("car_fuel",car_fuel);
        map.put("price_min",price_min);
        map.put("price_max",price_max);
        return carMapper.getCarByCondition(map);
    }

    @Override
    public Car getCarById(int id) {
        return carMapper.getByCarId(id);
    }

    @Override
    public int addNewCar(Car car) {
        carMapper.insertCar(car);
        return car.getCar_id();
    }

    @Override
    public void updateCarImg(String image_path, int id) {
        carMapper.updateCarImg(image_path,id);
    }

    @Override
    public int getCount() {
        return carMapper.getCount();
    }


}
