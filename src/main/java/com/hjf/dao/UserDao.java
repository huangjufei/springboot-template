package com.hjf.dao;

import com.hjf.dto.UserDomain;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserDao {

    int insert(UserDomain record);

    List<UserDomain> selectUsers();
}