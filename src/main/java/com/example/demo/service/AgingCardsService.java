package com.example.demo.service;

import com.example.demo.baen.AgingCard;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class AgingCardsService {
    public ArrayList<AgingCard> initializeAgingCards() {

        // 普通老化牌
        ArrayList<AgingCard> normalAgingCards = new ArrayList<>();

        AgingCard aingCard1 = new AgingCard();
        aingCard1.setName("发呆");
        aingCard1.setNumber(-1);
        aingCard1.setEffect("...");
        aingCard1.setLife(2);
        aingCard1.setIsUseEffect(false);
        normalAgingCards.add(aingCard1);

        AgingCard aingCard2 = new AgingCard();
        aingCard2.setName("痴呆");
        aingCard2.setNumber(-2);
        aingCard2.setEffect("...");
        aingCard2.setLife(2);
        aingCard2.setIsUseEffect(false);
        for (int i = 0; i < 2; i++) {
            normalAgingCards.add(aingCard2);
        }

        AgingCard aingCard3 = new AgingCard();
        aingCard3.setName("老年痴呆");
        aingCard3.setNumber(-3);
        aingCard3.setEffect("...");
        aingCard3.setLife(2);
        aingCard3.setIsUseEffect(false);
        normalAgingCards.add(aingCard3);

        AgingCard aingCard4 = new AgingCard();
        aingCard4.setName("极度疲惫");
        aingCard4.setNumber(0);
        aingCard4.setEffect("停止");
        aingCard4.setLife(2);
        aingCard4.setIsUseEffect(true);
        normalAgingCards.add(aingCard4);

        AgingCard aingCard5 = new AgingCard();
        aingCard5.setName("饥饿");
        aingCard5.setNumber(0);
        aingCard5.setEffect("-1生命值");
        aingCard5.setLife(2);
        aingCard5.setIsUseEffect(true);
        normalAgingCards.add(aingCard5);

        AgingCard aingCard6 = new AgingCard();
        aingCard6.setName("惊吓");
        aingCard6.setNumber(0);
        aingCard6.setEffect("战斗值最高的牌=0");
        aingCard6.setLife(2);
        aingCard6.setIsUseEffect(true);
        for (int i = 0; i < 2; i++) {
            normalAgingCards.add(aingCard6);
        }

        // 严重老化牌
        ArrayList<AgingCard> badAgingCards = new ArrayList<>();

        AgingCard aingCard7 = new AgingCard();
        aingCard7.setName("非常饥饿");
        aingCard7.setNumber(0);
        aingCard7.setEffect("-2生命值");
        aingCard7.setLife(2);
        aingCard7.setIsUseEffect(true);
        badAgingCards.add(aingCard7);

        AgingCard aingCard8 = new AgingCard();
        aingCard8.setName("低能");
        aingCard8.setNumber(-4);
        aingCard8.setEffect("...");
        aingCard8.setLife(2);
        aingCard8.setIsUseEffect(false);
        badAgingCards.add(aingCard8);

        AgingCard aingCard9 = new AgingCard();
        aingCard9.setName("自杀");
        aingCard9.setNumber(-5);
        aingCard9.setEffect("...");
        aingCard9.setLife(2);
        aingCard9.setIsUseEffect(false);
        badAgingCards.add(aingCard9);

        // 初始化老化牌
        ArrayList<AgingCard> agingCards = new ArrayList<>();

        // 随机普通老化牌加入初始化老化牌
        Collections.shuffle(normalAgingCards);
        agingCards.addAll(normalAgingCards);

        // 随机严重老化牌加入初始化老化牌
        Collections.shuffle(badAgingCards);
        agingCards.addAll(badAgingCards);

        return agingCards;
    }
}
