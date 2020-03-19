package com.huajicar.demo.mapper;

import com.huajicar.demo.entity.Agent;
import com.huajicar.demo.entity.Car;
import com.huajicar.demo.utility.SqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CarMapper {
    @Select("SELECT * FROM car WHERE car_id=#{id}")
    @Results(value = {@Result(property ="user",column = "user_account",one = @One(select = "com.huajicar.demo.mapper.UserMapper.getUserByAccount"))
    ,@Result(property ="agent",column = "agent_id",one = @One(select = "com.huajicar.demo.mapper.AgentMapper.getAgentById"))})
    Car getByCarId(@Param("id")int id);

    @Select("SELECT DISTINCT ${property} FROM car ORDER BY ${property}")
    List<String> getProperty(@Param("property")String property);

    @Select("SELECT * FROM car WHERE on_sale=1 ORDER BY rand() LIMIT ${num}")
    @Results(value = {@Result(property ="user",column = "user_account",one = @One(select = "com.huajicar.demo.mapper.UserMapper.getUserByAccount"))})
    List<Car> getCarRandom(@Param("num")int num);

    @SelectProvider(type = SqlProvider.class, method = "getCarsByCondition")
    List<Car> getCarByCondition(Map<String,Object>map);

    @Insert("INSERT INTO car(car_name,car_price,car_brand,car_type,car_mileage,car_door,car_seat,car_volume,car_shift,car_color,car_saleprice,note,user_account,description,car_age,car_fuel,sale_date,agent_id) VALUES (#{car_name},#{car_price},#{car_brand},#{car_type},#{car_mileage},#{car_door},#{car_seat},#{car_volume},#{car_shift},#{car_color},#{car_saleprice},#{note},#{user_account},#{description},#{car_age},#{car_fuel},NOW(),#{agent_id})")
    @Options(useGeneratedKeys=true, keyProperty="car_id")
    int insertCar(Car car);

    @Update("UPDATE car SET image_path=#{image_path} WHERE car_id=#{id}")
    void updateCarImg(@Param("image_path")String image_path,@Param("id")int id);

    @Update("UPDATE car SET user_account=#{user_account},on_sale = #{on_sale} WHERE car_id = #{car_id}")
    void updateCarStatus(@Param("user_account")String user_account,@Param("on_sale")int on_sale,@Param("car_id")int car_id);

    @Delete("delete from car where car_id = #{car_id}")
    void deleteById(@Param("car_id")int car_id);

    @Update("UPDATE car SET car_saleprice=#{car_saleprice} WHERE car_id = #{car_id}")
    void updateCarPrice(@Param("car_saleprice")float car_saleprice,@Param("car_id")int car_id);

    @Select("SELECT count(*) FROM car")
    int getCount();

    @Select("SELECT * FROM car")
    List<Car> getAllCar();
}
