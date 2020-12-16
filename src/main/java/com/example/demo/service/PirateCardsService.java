package com.example.demo.service;

import com.example.demo.baen.PirateCard;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PirateCardsService {
    // 海盗数量配置
    private static final int PIRATE_CARDS_COUNT = 2;

    public ArrayList<PirateCard> initializePirateCards() {
        // 海盗牌
        ArrayList<PirateCard> pirateCardsAll = new ArrayList<>();

        PirateCard pirateCard1 = new PirateCard();
        pirateCard1.setName("海盗");
        pirateCard1.setNumber(20);
        pirateCard1.setDraw(6);
        pirateCard1.setEffect("...");
        pirateCard1.setIsUseEffect(false);
        pirateCardsAll.add(pirateCard1);

        PirateCard pirateCard2 = new PirateCard();
        pirateCard2.setName("海盗");
        pirateCard2.setNumber(25);
        pirateCard2.setDraw(7);
        pirateCard2.setEffect("...");
        pirateCard2.setIsUseEffect(false);
        pirateCardsAll.add(pirateCard2);

        PirateCard pirateCard3 = new PirateCard();
        pirateCard3.setName("海盗");
        pirateCard3.setNumber(30);
        pirateCard3.setDraw(8);
        pirateCard3.setEffect("...");
        pirateCard3.setIsUseEffect(false);
        pirateCardsAll.add(pirateCard3);

        PirateCard pirateCard4 = new PirateCard();
        pirateCard4.setName("海盗");
        pirateCard4.setNumber(35);
        pirateCard4.setDraw(9);
        pirateCard4.setEffect("...");
        pirateCard4.setIsUseEffect(false);
        pirateCardsAll.add(pirateCard4);

        PirateCard pirateCard5 = new PirateCard();
        pirateCard5.setName("海盗");
        pirateCard5.setNumber(40);
        pirateCard5.setDraw(10);
        pirateCard5.setEffect("...");
        pirateCard5.setIsUseEffect(false);
        pirateCardsAll.add(pirateCard5);

        PirateCard pirateCard6 = new PirateCard();
        pirateCard6.setName("海盗");
        pirateCard6.setNumber(0);
        pirateCard6.setDraw(0);
        pirateCard6.setEffect("和剩下的所有冒险牌战斗");
        pirateCard6.setIsUseEffect(true);
        pirateCardsAll.add(pirateCard6);

        PirateCard pirateCard7 = new PirateCard();
        pirateCard7.setName("海盗");
        pirateCard7.setNumber(0);
        pirateCard7.setDraw(5);
        pirateCard7.setEffect("每张老化牌+2冒险值");
        pirateCard7.setIsUseEffect(true);
        pirateCardsAll.add(pirateCard7);

        PirateCard pirateCard8 = new PirateCard();
        pirateCard8.setName("海盗");
        pirateCard8.setNumber(16);
        pirateCard8.setDraw(7);
        pirateCard8.setEffect("每张额外的战斗牌必须支付2生命值");
        pirateCard8.setIsUseEffect(true);
        pirateCardsAll.add(pirateCard8);

        PirateCard pirateCard9 = new PirateCard();
        pirateCard9.setName("海盗");
        pirateCard9.setNumber(22);
        pirateCard9.setDraw(9);
        pirateCard9.setEffect("翻开的战斗牌只能算一半（翻开的老化牌必须包含在内）");
        pirateCard9.setIsUseEffect(true);
        pirateCardsAll.add(pirateCard9);

        PirateCard pirateCard10 = new PirateCard();
        pirateCard10.setName("海盗");
        pirateCard10.setNumber(52);
        pirateCard10.setDraw(10);
        pirateCard10.setEffect("每张翻开的战斗牌都+1战斗值");
        pirateCard10.setIsUseEffect(true);
        pirateCardsAll.add(pirateCard10);

        // 随机2张,pirateCardsCount可配置
        ArrayList<PirateCard> pirateCards = new ArrayList<>();
        for (int i = 0; i < PIRATE_CARDS_COUNT; i++) {
            int pirateCardListIndex = (int) (Math.random() * pirateCardsAll.size());
            pirateCards.add(pirateCardsAll.remove(pirateCardListIndex));
        }
        return pirateCards;
    }
}
