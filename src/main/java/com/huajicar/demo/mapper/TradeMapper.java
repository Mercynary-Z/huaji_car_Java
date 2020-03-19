package com.huajicar.demo.mapper;

import com.huajicar.demo.entity.CarBought;
import com.huajicar.demo.entity.CarSold;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeMapper {

    @Select("SELECT * FROM car_bought WHERE user_account=#{user_account}")
    List<CarBought> getCarBoughtByUserAccount(@Param("user_account")String user_account);

    @Select("SELECT * FROM car_sold1 WHERE user_account=#{user_account}")
    List<CarSold> getCarOnSaleByUserAccount(@Param("user_account")String user_account);

    @Select("SELECT * FROM car_sold2 WHERE user_account=#{user_account}")
    List<CarSold> getCarSoldByUserAccount(@Param("user_account")String user_account);

    @Insert("INSERT INTO trade(car_id, user_account, date, trade_price, former_owner_account) VALUES (#{car_id} ,#{user_account} ,NOW(),#{trade_price} ,#{former_account})")
    void insertTrade(@Param("car_id")int car_id,@Param("user_account")String user_account,@Param("trade_price")float trade_price,@Param("former_account")String former_account);

    @Select("SELECT count(*) FROM trade")
    int getCount();
}
