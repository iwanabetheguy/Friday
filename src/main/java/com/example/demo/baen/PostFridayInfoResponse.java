package com.example.demo.baen;

import lombok.Data;

import java.util.ArrayList;

@Data
public class PostFridayInfoResponse {
    private Integer code;

    private String message;

    private FridayInfoData data;

    @Data
    public static class FridayInfoData {
        private String stage;
        private String module;
        private Integer life;
        private Integer settleLife;
        private Integer robinsonFreeNumber;
        private ArrayList<AdventureCard> adventureActionCards;
        private ArrayList<RobinsonCard> robinsonActionLeftCards;
        private ArrayList<RobinsonCard> robinsonActionRightCards;
    }
}
