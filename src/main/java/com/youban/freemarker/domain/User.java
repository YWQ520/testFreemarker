package com.youban.freemarker.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class User implements Serializable {

    private Integer uid;
    private String username;
    private String upassword;
    private Date createtime;

}
