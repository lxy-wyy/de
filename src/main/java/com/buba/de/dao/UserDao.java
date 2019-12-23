package com.buba.de.dao;

import com.buba.de.pojo.Limits;
import com.buba.de.pojo.User;

import java.util.List;

public interface UserDao {

    User getUser(User u);

    List<Limits> getlimits(Integer id);

    List<Limits> getli();

    int delLi(int id);

    int insrtLimtis(Limits l);

    int updateli(Limits li);

}
