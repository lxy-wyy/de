package com.buba.de.service;

import com.buba.de.dao.UserDao;
import com.buba.de.pojo.Limits;
import com.buba.de.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicelmpl implements UserService {

    @Autowired
    private UserDao ud;


    @Override
    public User getUser(User u) {
        return ud.getUser(u);
    }

    @Override
    public List<Limits> getlimits(Integer id) {
        return ud.getlimits(id);
    }

    @Override
    public List<Limits> getli() {
        return ud.getli();
    }

    @Override
    public int delLi(int id) {
        return ud.delLi(id);
    }

    @Override
    public int insrtLimtis(Limits l) {
        return ud.insrtLimtis(l);
    }

    @Override
    public int updateli(Limits li) {
        return ud.updateli(li);
    }
}
