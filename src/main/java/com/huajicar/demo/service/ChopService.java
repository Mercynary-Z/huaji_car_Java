package com.huajicar.demo.service;

import com.huajicar.demo.entity.Chop;
import com.huajicar.demo.entity.User;

import java.util.List;

public interface ChopService {
    List<Chop> getChopByUserAccount(String user_account);

    List<Chop> getChoppedByUserAccount(String user_account);

    void newChop(Chop chop);

    Chop getChopById(int id);

    void applyChop(User user,Chop chop);

    void rejectChop(Chop chop);
}
