package com.example.demo.json;

import com.example.demo.entity.TUser;
import lombok.Data;

@Data
public class TUserJson {
    private boolean flag;
    private TUser tuser = null;
    private String msg = "";
}
