package com.example.demo.service;

import com.example.demo.baen.AdventureCard;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class AdventureCardsService {
    public ArrayList<AdventureCard> initializeAdventureCards() {
        // 冒险牌
        ArrayList<AdventureCard> adventureCards = new ArrayList<>();

        AdventureCard adventureCard1 = new AdventureCard();
        adventureCard1.setName("食物");
        adventureCard1.setNumber(0);
        adventureCard1.setEffect("+1生命值");
        adventureCard1.setLife(1);
        adventureCard1.setIsUseEffect(true);
        adventureCard1.setAdventure("乘木筏登破船");
        adventureCard1.setDraw(1);
        adventureCard1.setGreen(0);
        adventureCard1.setYellow(1);
        adventureCard1.setRed(3);
        for (int i = 0; i < 2; i++) {
            adventureCards.add(adventureCard1);
        }

        AdventureCard adventureCard2 = new AdventureCard();
        adventureCard2.setName("食物");
        adventureCard2.setNumber(1);
        adventureCard2.setEffect("+1生命值");
        adventureCard2.setLife(1);
        adventureCard2.setIsUseEffect(true);
        adventureCard2.setAdventure("探索岛屿");
        adventureCard2.setDraw(2);
        adventureCard2.setGreen(1);
        adventureCard2.setYellow(3);
        adventureCard2.setRed(6);
        for (int i = 0; i < 2; i++) {
            adventureCards.add(adventureCard2);
        }

        AdventureCard adventureCard3 = new AdventureCard();
        adventureCard3.setName("食物");
        adventureCard3.setNumber(2);
        adventureCard3.setEffect("+1生命值");
        adventureCard3.setLife(1);
        adventureCard3.setIsUseEffect(true);
        adventureCard3.setAdventure("深入岛屿");
        adventureCard3.setDraw(3);
        adventureCard3.setGreen(2);
        adventureCard3.setYellow(5);
        adventureCard3.setRed(8);
        adventureCards.add(adventureCard3);

        AdventureCard adventureCard4 = new AdventureCard();
        adventureCard4.setName("诡计");
        adventureCard4.setNumber(0);
        adventureCard4.setEffect("1×牌库底");
        adventureCard4.setLife(1);
        adventureCard4.setIsUseEffect(true);
        adventureCard4.setAdventure("乘木筏登破船");
        adventureCard4.setDraw(1);
        adventureCard4.setGreen(0);
        adventureCard4.setYellow(1);
        adventureCard4.setRed(3);
        adventureCards.add(adventureCard4);

        AdventureCard adventureCard5 = new AdventureCard();
        adventureCard5.setName("诡计");
        adventureCard5.setNumber(1);
        adventureCard5.setEffect("1×牌库底");
        adventureCard5.setLife(1);
        adventureCard5.setIsUseEffect(true);
        adventureCard5.setAdventure("探索岛屿");
        adventureCard5.setDraw(2);
        adventureCard5.setGreen(1);
        adventureCard5.setYellow(3);
        adventureCard5.setRed(6);
        adventureCards.add(adventureCard5);

        AdventureCard adventureCard6 = new AdventureCard();
        adventureCard6.setName("经验");
        adventureCard6.setNumber(2);
        adventureCard6.setEffect("+1张牌");
        adventureCard6.setLife(1);
        adventureCard6.setIsUseEffect(true);
        adventureCard6.setAdventure("探索岛屿");
        adventureCard6.setDraw(3);
        adventureCard6.setGreen(2);
        adventureCard6.setYellow(5);
        adventureCard6.setRed(8);
        adventureCards.add(adventureCard6);

        AdventureCard adventureCard7 = new AdventureCard();
        adventureCard7.setName("经验");
        adventureCard7.setNumber(3);
        adventureCard7.setEffect("+1张牌");
        adventureCard7.setLife(1);
        adventureCard7.setIsUseEffect(true);
        adventureCard7.setAdventure("野兽");
        adventureCard7.setDraw(4);
        adventureCard7.setGreen(4);
        adventureCard7.setYellow(7);
        adventureCard7.setRed(11);
        adventureCards.add(adventureCard7);

        AdventureCard adventureCard8 = new AdventureCard();
        adventureCard8.setName("装备");
        adventureCard8.setNumber(0);
        adventureCard8.setEffect("+2张牌");
        adventureCard8.setLife(1);
        adventureCard8.setIsUseEffect(true);
        adventureCard8.setAdventure("乘木筏登破船");
        adventureCard8.setDraw(1);
        adventureCard8.setGreen(0);
        adventureCard8.setYellow(1);
        adventureCard8.setRed(3);
        for (int i = 0; i < 2; i++) {
            adventureCards.add(adventureCard8);
        }

        AdventureCard adventureCard9 = new AdventureCard();
        adventureCard9.setName("策略");
        adventureCard9.setNumber(2);
        adventureCard9.setEffect("1×交换");
        adventureCard9.setLife(1);
        adventureCard9.setIsUseEffect(true);
        adventureCard9.setAdventure("深入岛屿");
        adventureCard9.setDraw(3);
        adventureCard9.setGreen(2);
        adventureCard9.setYellow(5);
        adventureCard9.setRed(8);
        adventureCards.add(adventureCard9);

        AdventureCard adventureCard10 = new AdventureCard();
        adventureCard10.setName("策略");
        adventureCard10.setNumber(3);
        adventureCard10.setEffect("1×交换");
        adventureCard10.setLife(1);
        adventureCard10.setIsUseEffect(true);
        adventureCard10.setAdventure("野兽");
        adventureCard10.setDraw(4);
        adventureCard10.setGreen(4);
        adventureCard10.setYellow(7);
        adventureCard10.setRed(11);
        adventureCards.add(adventureCard10);

        AdventureCard adventureCard11 = new AdventureCard();
        adventureCard11.setName("策略");
        adventureCard11.setNumber(0);
        adventureCard11.setEffect("2×交换");
        adventureCard11.setLife(1);
        adventureCard11.setIsUseEffect(true);
        adventureCard11.setAdventure("野兽");
        adventureCard11.setDraw(1);
        adventureCard11.setGreen(0);
        adventureCard11.setYellow(1);
        adventureCard11.setRed(3);
        for (int i = 0; i < 2; i++) {
            adventureCards.add(adventureCard11);
        }

        AdventureCard adventureCard12 = new AdventureCard();
        adventureCard12.setName("预知");
        adventureCard12.setNumber(2);
        adventureCard12.setEffect("看3张牌");
        adventureCard12.setLife(1);
        adventureCard12.setIsUseEffect(true);
        adventureCard12.setAdventure("深入岛屿");
        adventureCard12.setDraw(3);
        adventureCard12.setGreen(2);
        adventureCard12.setYellow(5);
        adventureCard12.setRed(8);
        adventureCards.add(adventureCard12);

        AdventureCard adventureCard13 = new AdventureCard();
        adventureCard13.setName("预知");
        adventureCard13.setNumber(3);
        adventureCard13.setEffect("看3张牌");
        adventureCard13.setLife(1);
        adventureCard13.setIsUseEffect(true);
        adventureCard13.setAdventure("野兽");
        adventureCard13.setDraw(4);
        adventureCard13.setGreen(4);
        adventureCard13.setYellow(7);
        adventureCard13.setRed(11);
        adventureCards.add(adventureCard13);

        AdventureCard adventureCard14 = new AdventureCard();
        adventureCard14.setName("领悟");
        adventureCard14.setNumber(0);
        adventureCard14.setEffect("1×摧毁");
        adventureCard14.setLife(1);
        adventureCard14.setIsUseEffect(true);
        adventureCard14.setAdventure("乘木筏登破船");
        adventureCard14.setDraw(1);
        adventureCard14.setGreen(0);
        adventureCard14.setYellow(1);
        adventureCard14.setRed(3);
        adventureCards.add(adventureCard14);

        AdventureCard adventureCard15 = new AdventureCard();
        adventureCard15.setName("领悟");
        adventureCard15.setNumber(1);
        adventureCard15.setEffect("1×摧毁");
        adventureCard15.setLife(1);
        adventureCard15.setIsUseEffect(true);
        adventureCard15.setAdventure("探索岛屿");
        adventureCard15.setDraw(2);
        adventureCard15.setGreen(1);
        adventureCard15.setYellow(3);
        adventureCard15.setRed(6);
        adventureCards.add(adventureCard15);

        AdventureCard adventureCard16 = new AdventureCard();
        adventureCard16.setName("领悟");
        adventureCard16.setNumber(2);
        adventureCard16.setEffect("1×摧毁");
        adventureCard16.setLife(1);
        adventureCard16.setIsUseEffect(true);
        adventureCard16.setAdventure("探索岛屿");
        adventureCard16.setDraw(3);
        adventureCard16.setGreen(2);
        adventureCard16.setYellow(5);
        adventureCard16.setRed(8);
        adventureCards.add(adventureCard16);

        AdventureCard adventureCard17 = new AdventureCard();
        adventureCard17.setName("领悟");
        adventureCard17.setNumber(3);
        adventureCard17.setEffect("1×摧毁");
        adventureCard17.setLife(1);
        adventureCard17.setIsUseEffect(true);
        adventureCard17.setAdventure("野兽");
        adventureCard17.setDraw(4);
        adventureCard17.setGreen(4);
        adventureCard17.setYellow(7);
        adventureCard17.setRed(11);
        adventureCards.add(adventureCard17);

        AdventureCard adventureCard18 = new AdventureCard();
        adventureCard18.setName("模仿");
        adventureCard18.setNumber(0);
        adventureCard18.setEffect("1×复制");
        adventureCard18.setLife(1);
        adventureCard18.setIsUseEffect(true);
        adventureCard18.setAdventure("乘木筏登破船");
        adventureCard18.setDraw(1);
        adventureCard18.setGreen(0);
        adventureCard18.setYellow(1);
        adventureCard18.setRed(3);
        adventureCards.add(adventureCard18);

        AdventureCard adventureCard19 = new AdventureCard();
        adventureCard19.setName("模仿");
        adventureCard19.setNumber(1);
        adventureCard19.setEffect("1×复制");
        adventureCard19.setLife(1);
        adventureCard19.setIsUseEffect(true);
        adventureCard19.setAdventure("探索岛屿");
        adventureCard19.setDraw(2);
        adventureCard19.setGreen(1);
        adventureCard19.setYellow(3);
        adventureCard19.setRed(6);
        adventureCards.add(adventureCard19);

        AdventureCard adventureCard20 = new AdventureCard();
        adventureCard20.setName("再来一次");
        adventureCard20.setNumber(1);
        adventureCard20.setEffect("1×加倍");
        adventureCard20.setLife(1);
        adventureCard20.setIsUseEffect(true);
        adventureCard20.setAdventure("探索岛屿");
        adventureCard20.setDraw(2);
        adventureCard20.setGreen(1);
        adventureCard20.setYellow(3);
        adventureCard20.setRed(6);
        adventureCards.add(adventureCard20);

        AdventureCard adventureCard21 = new AdventureCard();
        adventureCard21.setName("再来一次");
        adventureCard21.setNumber(2);
        adventureCard21.setEffect("1×加倍");
        adventureCard21.setLife(1);
        adventureCard21.setIsUseEffect(true);
        adventureCard21.setAdventure("深入岛屿");
        adventureCard21.setDraw(3);
        adventureCard21.setGreen(2);
        adventureCard21.setYellow(5);
        adventureCard21.setRed(8);
        adventureCards.add(adventureCard21);

        AdventureCard adventureCard22 = new AdventureCard();
        adventureCard22.setName("书籍");
        adventureCard22.setNumber(0);
        adventureCard22.setEffect("阶段-1");
        adventureCard22.setLife(1);
        adventureCard22.setIsUseEffect(true);
        adventureCard22.setAdventure("乘木筏登破船");
        adventureCard22.setDraw(1);
        adventureCard22.setGreen(0);
        adventureCard22.setYellow(1);
        adventureCard22.setRed(3);
        adventureCards.add(adventureCard22);

        AdventureCard adventureCard23 = new AdventureCard();
        adventureCard23.setName("武器");
        adventureCard23.setNumber(2);
        adventureCard23.setEffect("...");
        adventureCard23.setLife(1);
        adventureCard23.setIsUseEffect(false);
        adventureCard23.setAdventure("探索岛屿");
        adventureCard23.setDraw(2);
        adventureCard23.setGreen(1);
        adventureCard23.setYellow(3);
        adventureCard23.setRed(6);
        for (int i = 0; i < 2; i++) {
            adventureCards.add(adventureCard23);
        }

        AdventureCard adventureCard24 = new AdventureCard();
        adventureCard24.setName("武器");
        adventureCard24.setNumber(4);
        adventureCard24.setEffect("...");
        adventureCard24.setLife(1);
        adventureCard24.setIsUseEffect(false);
        adventureCard24.setAdventure("食人族");
        adventureCard24.setDraw(5);
        adventureCard24.setGreen(5);
        adventureCard24.setYellow(9);
        adventureCard24.setRed(14);
        for (int i = 0; i < 2; i++) {
            adventureCards.add(adventureCard24);
        }

        // 初始化冒险牌
        Collections.shuffle(adventureCards);
        return adventureCards;
    }
}
