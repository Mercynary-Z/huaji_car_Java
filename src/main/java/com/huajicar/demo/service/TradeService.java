package com.huajicar.demo.service;

import com.huajicar.demo.entity.*;

import java.util.List;

public interface TradeService {
    List<CarBought> getCarBoughtByUserAccount(String user_account);

    List<CarSold> getAllCarSoldByUserAccount(String user_account);

    void purchaseCar(Car car, User user);

    void deleteCar(Car car);

    int getCount();
}
