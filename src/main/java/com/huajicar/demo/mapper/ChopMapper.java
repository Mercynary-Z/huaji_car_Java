package com.huajicar.demo.mapper;

import com.huajicar.demo.entity.Chop;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

@Repository
public interface ChopMapper {
    @Select("SELECT * FROM chop WHERE account_name=#{account_name}")
    @Results(value = {@Result(property ="car",column = "car_id",one = @One(select = "com.huajicar.demo.mapper.CarMapper.getByCarId"))})
    List<Chop> getChopByAccount(@Param("account_name")String account_name);

    @Select("SELECT * FROM chop WHERE former_owner_name=#{former_owner_name}")
    @Results(value = {@Result(property ="car",column = "car_id",one = @One(select = "com.huajicar.demo.mapper.CarMapper.getByCarId"))})
    List<Chop> getChoppedByAccount(@Param("former_owner_name")String former_owner_name);

    @Insert("INSERT INTO chop(account_name,former_owner_name,chop_price,car_id) VALUES (#{account_name} ,#{former_owner_name} ,#{chop_price},#{car_id})")
    void insertChop(Chop chop);

    @Select("SELECT * FROM chop WHERE chop_id=#{chop_id}")
    Chop getChopById(@Param("chop_id")int chop_id);

    @Update("UPDATE chop SET deal_or_not=#{num} WHERE chop_id=#{chop_id}")
    void updateChopNum(@Param("num")int num,@Param("chop_id")int chop_id);

    @SuppressWarnings("rawtypes")
    @Select("call update_chop_saled(#{chop_id},#{car_id})")
    @Options(statementType = StatementType.CALLABLE)
    HashMap rejectAllOtherChop(@Param("chop_id")int chop_id,@Param("car_id")int car_id);

    @Update("UPDATE chop SET deal_or_not=2 WHERE chop_id!=#{chop_id} AND car_id=#{car_id}")
    void rejectOtherChop(@Param("chop_id")int chop_id,@Param("car_id")int car_id);

    @Update("UPDATE chop SET deal_or_not=3 WHERE deal_or_not=0 AND car_id=#{car_id}")
    void timeoutChop(@Param("car_id")int car_id);
}
