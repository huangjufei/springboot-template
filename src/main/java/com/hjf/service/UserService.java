package com.hjf.service;

import com.github.pagehelper.PageInfo;
import com.hjf.model.UserDomain;

public interface UserService {

    int addUser(UserDomain user);

    PageInfo<UserDomain> findAllUser(int pageNum, int pageSize);
}