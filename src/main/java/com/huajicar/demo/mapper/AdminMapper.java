package com.huajicar.demo.mapper;

import com.huajicar.demo.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {

    @Select("SELECT * FROM admin WHERE admin_account=#{admin_account} AND admin_password=#{admin_password}")
    Admin selectAdminByNameAndPassword(@Param("admin_account")String admin_account,@Param("admin_password")String admin_password);
}
