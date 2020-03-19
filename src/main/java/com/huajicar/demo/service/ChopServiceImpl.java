package com.huajicar.demo.service;

import com.huajicar.demo.entity.Car;
import com.huajicar.demo.entity.Chop;
import com.huajicar.demo.entity.User;
import com.huajicar.demo.mapper.CarMapper;
import com.huajicar.demo.mapper.ChopMapper;
import com.huajicar.demo.mapper.TradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ChopServiceImpl implements ChopService {
    @Autowired
    private ChopMapper chopMapper;

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private TradeMapper tradeMapper;

    @Override
    public List<Chop> getChopByUserAccount(String user_account) {
        return chopMapper.getChopByAccount(user_account);
    }

    @Override
    public List<Chop> getChoppedByUserAccount(String user_account) {
        return chopMapper.getChoppedByAccount(user_account);
    }

    @Override
    public void newChop(Chop chop) {
        chopMapper.insertChop(chop);
    }

    @Override
    public Chop getChopById(int id) {
        return chopMapper.getChopById(id);
    }

    @Override
    public void applyChop(User user, Chop chop) {
//        chopMapper.rejectAllOtherChop(chop.getChop_id(),chop.getCar_id());
        chopMapper.updateChopNum(1,chop.getChop_id());
        chopMapper.rejectOtherChop(chop.getChop_id(),chop.getCar_id());
        carMapper.updateCarPrice(chop.getChop_price(),chop.getCar_id());
        Car car=carMapper.getByCarId(chop.getCar_id());
        carMapper.updateCarStatus(chop.getAccount_name(),0,chop.getCar_id());
        tradeMapper.insertTrade(car.getCar_id(),chop.getAccount_name(),chop.getChop_price(),user.getUser_account());
    }

    @Override
    public void rejectChop(Chop chop) {
        chopMapper.updateChopNum(2,chop.getChop_id());
    }
}
