package com.example.demo.entity;

import lombok.Data;

import java.util.List;

@Data
public class TUser {
    private int id;
    private String tuserName;
    private String tuserPassword;
    private String summary;
    private List<Relate> relates;
}
