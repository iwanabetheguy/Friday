package com.example.demo.service;

import com.example.demo.baen.AgingCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AgingService {
    @Autowired
    private FridayService fridayService;

    // 老化牌（牌库）
    public ArrayList<AgingCard> aging_cards;
}
