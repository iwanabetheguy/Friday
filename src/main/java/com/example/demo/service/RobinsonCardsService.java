package com.example.demo.service;

import com.example.demo.baen.RobinsonCard;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class RobinsonCardsService {
    public ArrayList<RobinsonCard> initializeRobinsonCards() {
        // 鲁滨逊牌
        ArrayList<RobinsonCard> robinsonCards = new ArrayList<>();

        RobinsonCard robinsonCard1 = new RobinsonCard();
        robinsonCard1.setName("发呆");
        robinsonCard1.setNumber(-1);
        robinsonCard1.setEffect("...");
        robinsonCard1.setLife(1);
        robinsonCard1.setIsUseEffect(false);
        for (int i = 0; i < 5; i++) {
            robinsonCards.add(robinsonCard1);
        }

        RobinsonCard robinsonCard2 = new RobinsonCard();
        robinsonCard2.setName("虚弱");
        robinsonCard2.setNumber(0);
        robinsonCard2.setEffect("...");
        robinsonCard2.setLife(1);
        robinsonCard2.setIsUseEffect(false);
        for (int i = 0; i < 8; i++) {
            robinsonCards.add(robinsonCard2);
        }

        RobinsonCard robinsonCard3 = new RobinsonCard();
        robinsonCard3.setName("专注");
        robinsonCard3.setNumber(1);
        robinsonCard3.setEffect("...");
        robinsonCard3.setLife(1);
        robinsonCard3.setIsUseEffect(false);
        for (int i = 0; i < 3; i++) {
            robinsonCards.add(robinsonCard3);
        }

        RobinsonCard robinsonCard4 = new RobinsonCard();
        robinsonCard4.setName("天才");
        robinsonCard4.setNumber(2);
        robinsonCard4.setEffect("...");
        robinsonCard4.setLife(1);
        robinsonCard4.setIsUseEffect(false);
        robinsonCards.add(robinsonCard4);

        RobinsonCard robinsonCard5 = new RobinsonCard();
        robinsonCard5.setName("进食");
        robinsonCard5.setNumber(0);
        robinsonCard5.setEffect("+2生命值");
        robinsonCard5.setLife(1);
        robinsonCard5.setIsUseEffect(true);
        robinsonCards.add(robinsonCard5);

        // 初始化鲁滨逊牌
        Collections.shuffle(robinsonCards);
        return robinsonCards;
    }
}
