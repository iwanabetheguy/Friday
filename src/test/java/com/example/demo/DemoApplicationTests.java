package com.example.demo;

import com.example.demo.baen.AdventureCard;
import com.example.demo.baen.AgingCard;
import com.example.demo.baen.PirateCard;
import com.example.demo.baen.RobinsonCard;
import com.example.demo.service.AdventureCardsService;
import com.example.demo.service.AgingCardsService;
import com.example.demo.service.PirateCardsService;
import com.example.demo.service.RobinsonCardsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private PirateCardsService pirateCardsService;
    @Autowired
    private RobinsonCardsService robinsonCardsService;
    @Autowired
    private AgingCardsService agingCardsService;
    @Autowired
    private AdventureCardsService adventureCardsService;

    @Test
    public void testInitializePirateCards() {
        for (int i = 0; i < 9; i++) {
            ArrayList<PirateCard> initializePirateCards = pirateCardsService.initializePirateCards();
            System.out.println(initializePirateCards);
            System.out.println(initializePirateCards.size());
        }
    }

    @Test
    public void testInitializeAgingCards() {
        for (int i = 0; i < 9; i++) {
            ArrayList<AgingCard> initializeAgingCards = agingCardsService.initializeAgingCards();
            System.out.println(initializeAgingCards);
            System.out.println(initializeAgingCards.size());
        }
    }

    @Test
    public void testInitializeRobinsonCards() {
        for (int i = 0; i < 9; i++) {
            ArrayList<RobinsonCard> initializeRobinsonCards = robinsonCardsService.initializeRobinsonCards();
            System.out.println(initializeRobinsonCards);
            System.out.println(initializeRobinsonCards.size());
        }
    }

    @Test
    public void testInitializeAdventureCards() {
        for (int i = 0; i < 9; i++) {
            ArrayList<AdventureCard> initializeAdventureCards = adventureCardsService.initializeAdventureCards();
            System.out.println(initializeAdventureCards);
            System.out.println(initializeAdventureCards.size());
        }
    }

}
