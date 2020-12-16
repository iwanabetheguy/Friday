package com.example.demo.service;

import com.example.demo.baen.PirateCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PirateService {
    @Autowired
    private FridayService fridayService;

    // 海盗牌（牌库）
    public ArrayList<PirateCard> pirate_cards;
}
