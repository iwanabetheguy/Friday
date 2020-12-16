package com.example.demo.service;

import com.alibaba.fastjson.JSON;
import com.example.demo.baen.PostFridayInfoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FridayService {
    @Autowired
    private PirateCardsService pirateCardsService;
    @Autowired
    private AgingCardsService agingCardsService;
    @Autowired
    private AdventureCardsService adventureCardsService;
    @Autowired
    private RobinsonCardsService robinsonCardsService;

    @Autowired
    private PirateService pirateService;
    @Autowired
    private AgingService agingService;
    @Autowired
    private AdventureService adventureService;
    @Autowired
    private RobinsonService robinsonService;

    // 星期五的阶段，1-绿色冒险阶段，2-黄色冒险阶段，3-红色冒险阶段，4-海盗阶段
    public Integer friday_stage;

    // 当前的执行的模块
    public String friday_module;

    // 鲁滨逊的生命值
    public Integer life;

    // 初始化
    public String initialize() {
        // 清空所有区域
        if (adventureService.adventure_action_cards != null){
            adventureService.adventure_action_cards.clear();
        }
        if (adventureService.adventure_dis_cards != null){
            adventureService.adventure_dis_cards.clear();
        }
        if (robinsonService.robinson_action_left_cards != null){
            robinsonService.robinson_action_left_cards.clear();
        }
        if (robinsonService.robinson_action_rigth_cards != null){
            robinsonService.robinson_action_rigth_cards.clear();
        }
        if (robinsonService.robinson_action_left_effect_card != null){
            robinsonService.robinson_action_left_effect_card.clear();
        }
        if (robinsonService.robinson_action_rigth_effect_card != null){
            robinsonService.robinson_action_rigth_effect_card.clear();
        }
        if (robinsonService.robinson_action_effect_predict_cards != null){
            robinsonService.robinson_action_effect_predict_cards.clear();
        }
        if (robinsonService.robinson_dis_cards != null){
            robinsonService.robinson_dis_cards.clear();
        }
        if (pirateService.pirate_cards != null){
            pirateService.pirate_cards.clear();
        }
        if (agingService.aging_cards != null){
            agingService.aging_cards.clear();
        }
        if (adventureService.adventure_cards != null){
            adventureService.adventure_cards.clear();
        }
        if (robinsonService.robinson_cards != null){
            robinsonService.robinson_cards.clear();
        }
        // 初始化鲁滨逊的生命值
        this.life = 18;
        // 初始化星期五的阶段
        this.friday_stage = 1;
        // 初始化当前的执行的模块
        this.friday_module = "daw_adventure_card";
        // 初始化抽牌数
        robinsonService.robinson_free_number = 0;
        // 初始化牌库
        pirateService.pirate_cards = pirateCardsService.initializePirateCards();
        agingService.aging_cards = agingCardsService.initializeAgingCards();
        adventureService.adventure_cards = adventureCardsService.initializeAdventureCards();
        robinsonService.robinson_cards = robinsonCardsService.initializeRobinsonCards();

        adventureService.adventure_action_cards = new ArrayList<>();
        adventureService.adventure_dis_cards = new ArrayList<>();
        return "Initialize Friday OK!";
    }

    // 开始
    public String start(PostFridayInfoRequest request){
        if (request.getIsFriday()) {
            switch (this.friday_module) {
                case "daw_adventure_card":
                    if (!adventureService.check_adventure_cards()) {
                        adventureService.shuffle_adventure_cards();
                    }
                    adventureService.daw_adventure_card();
                    this.friday_module = "choose_adventure_card";
                    break;
                case "choose_adventure_card":
                    Boolean check_adventure_action_cards = adventureService.dis_adventure_card(request.getAdventureActionCardIndex());
                    if (check_adventure_action_cards) {
                        this.friday_module = "daw_robinson_card";
                    } else {
                        this.friday_module = "change_friday_stage";
                    }
                    break;
                case "change_friday_stage":
                    this.change_friday_stage();
                    break;
                default:
                    break;
            }
        }
        return JSON.toJSONString(this.friday_module);
    }

    // 换阶段
    public Integer change_friday_stage() {
        switch (this.friday_stage){
            case 1:
            case 2:
            case 3:
                this.friday_stage = this.friday_stage++;
                return this.friday_stage;
            case 4:
                // 已经是最终阶段（海盗阶段）
                return this.friday_stage;
            default:
                return this.friday_stage;
        }
    }
}
