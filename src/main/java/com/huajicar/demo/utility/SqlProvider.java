package com.huajicar.demo.utility;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class SqlProvider {
    public String getCarsByCondition(Map<String,Object> map){
        return new SQL(){
            {
                SELECT("*");
                FROM("car");
                String car_brand=map.get("car_brand")==null?null:map.get("car_brand").toString();
                String car_type=map.get("car_type")==null?null:map.get("car_type").toString();
                String car_age=map.get("car_age")==null?null:map.get("car_age").toString();
                String car_shift=map.get("car_shift")==null?null:map.get("car_shift").toString();
                String car_color=map.get("car_color")==null?null:map.get("car_color").toString();
                String car_fuel=map.get("car_fuel")==null?null:map.get("car_fuel").toString();

                String price_min=map.get("price_min")==null?null:map.get("price_min").toString();
                String price_max=map.get("price_max")==null?null:map.get("price_max").toString();

                if(car_brand!=null){
                    WHERE("car_brand='"+car_brand+"'");
                }
                if(car_type!=null){
                    WHERE("car_type='"+car_type+"'");
                }
                if(car_age!=null){
                    WHERE("car_age='"+car_age+"'");
                }
                if(car_shift!=null){
                    WHERE("car_shift='"+car_shift+"'");
                }
                if(car_color!=null){
                    WHERE("car_color='"+car_color+"'");
                }
                if(car_fuel!=null){
                    WHERE("car_fuel='"+car_fuel+"'");
                }
                if(price_min!=null &&price_max!=null){
                    WHERE("car_saleprice BETWEEN #{price_min} AND #{price_max}");
                }else {
                    String min="0";
                    String max=String.valueOf(Integer.MAX_VALUE);
                    if(price_min!=null){
                        min=price_min;
                    }
                    if(price_max!=null){
                        max=price_max;
                    }
                    WHERE("car_saleprice BETWEEN "+min+" AND "+max);
                }
                WHERE("on_sale=1");
            }
        }.toString();
    }
}
