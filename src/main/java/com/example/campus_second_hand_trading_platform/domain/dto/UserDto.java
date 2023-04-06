package com.example.campus_second_hand_trading_platform.domain.dto;

public class UserDto {
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "User{" +
                "id = " + id +
                ", name = " + name +
                "}";
    }
}
