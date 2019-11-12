package com.youban.freemarker.service;

import com.youban.freemarker.controller.data.Result;
import com.youban.freemarker.domain.User;

import java.util.List;

public interface UserService {

    /**
     * 查询所哟局用户信息
     * @return
     */
    Result selectAll();


}
