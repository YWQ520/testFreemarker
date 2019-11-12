package com.youban.freemarker.service.impl;

import com.youban.freemarker.service.UserService;
import com.youban.freemarker.controller.data.Result;
import com.youban.freemarker.domain.User;
import com.youban.freemarker.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public Result selectAll() {
        List<User> users = userMapper.selectAll();
        Result result = new Result();
        result.setCore(1);
        result.setData(users);
        result.setMsg("查询成功!");
        return result;
    }

}
