package com.sbtest.projectjdbc.common;

import net.sf.json.JSONObject;

import java.io.Serializable;

public class BaseEntity implements Serializable{
    public String toJsonString(){
        return JSONObject.fromObject(this).toString();
    }
}
