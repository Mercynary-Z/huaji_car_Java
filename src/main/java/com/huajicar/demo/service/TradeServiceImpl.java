package com.huajicar.demo.service;

import com.huajicar.demo.entity.*;
import com.huajicar.demo.mapper.AgentMapper;
import com.huajicar.demo.mapper.CarMapper;
import com.huajicar.demo.mapper.ChopMapper;
import com.huajicar.demo.mapper.TradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

@Transactional
@Service
public class TradeServiceImpl implements TradeService {
    @Autowired
    private TradeMapper tradeMapper;

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private AgentMapper agentMapper;

    @Autowired
    private ChopMapper chopMapper;

    @Override
    public List<CarBought> getCarBoughtByUserAccount(String user_account) {
        return tradeMapper.getCarBoughtByUserAccount(user_account);
    }

    @Override
    public List<CarSold> getAllCarSoldByUserAccount(String user_account) {
        List<CarSold> carSold1=tradeMapper.getCarOnSaleByUserAccount(user_account);
        List<CarSold> carSold2=tradeMapper.getCarSoldByUserAccount(user_account);
        carSold1.addAll(carSold2);
        return carSold1;
    }

    @Override
    public void purchaseCar(Car car, User user) {
        carMapper.updateCarStatus(user.getUser_account(),0,car.getCar_id());
        chopMapper.timeoutChop(car.getCar_id());
        tradeMapper.insertTrade(car.getCar_id(),user.getUser_account(),car.getCar_saleprice(),car.getUser().getUser_account());
    }

    @Override
    public void deleteCar(Car car) {
        carMapper.deleteById(car.getCar_id());
        agentMapper.updateAgentCount();
        String car_img=car.getImage_path();
        String[] imgs=car_img.split(";");
        for(int i=0;i<imgs.length;i++){
            if(imgs[i].length()>0){
                File file = new File("./src/main/resources"+imgs[i]);
                file.delete();
                file=new File("./target/classes"+imgs[i]);
                file.delete();
            }
        }
    }

    @Override
    public int getCount() {
        return tradeMapper.getCount();
    }
}
