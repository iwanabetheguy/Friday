package com.example.demo.service;

import com.example.demo.baen.AdventureCard;
import com.example.demo.baen.PostFridayInfoRequest;
import com.example.demo.baen.PostFridayInfoResponse;
import com.example.demo.baen.RobinsonCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

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

    // 星期五是否已经初始化
    public Boolean friday_initialize;

    // 星期五的阶段，1-绿色冒险阶段，2-黄色冒险阶段，3-红色冒险阶段，4-海盗阶段
    public Integer friday_stage;

    // 当前的执行的模块
    public String friday_module;

    // 鲁滨逊的生命值
    public Integer life;
    // 结算扣除的生命值
    public Integer sttle_life;

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
        if (robinsonService.robinson_action_right_cards != null){
            robinsonService.robinson_action_right_cards.clear();
        }
        if (robinsonService.robinson_action_left_effect_card != null){
            robinsonService.robinson_action_left_effect_card.clear();
        }
        if (robinsonService.robinson_action_right_effect_card != null){
            robinsonService.robinson_action_right_effect_card.clear();
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
        // 初始化标记
        this.friday_initialize = true;
        // 初始化鲁滨逊的生命值
        this.life = 18;
        // 初始化结算扣除的生命值
        this.sttle_life = 0;
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
        robinsonService.robinson_action_left_cards = new ArrayList<>();
        robinsonService.robinson_action_right_cards = new ArrayList<>();
        robinsonService.robinson_dis_cards = new ArrayList<>();
        return "Initialize Friday OK!";
    }

    // 开始
    public PostFridayInfoResponse start(PostFridayInfoRequest request){
        if (this.friday_initialize == null) {
            this.initialize();
        }
        if (request.getIsFriday()) {
            String module;
            if (request.getGoFridayModule() == null) {
                module = this.friday_module;
            } else {
                module = request.getGoFridayModule();
            }
            switch (module) {
                case "daw_adventure_card":
                    if (adventureService.check_adventure_cards()) {
                        adventureService.daw_adventure_card();
                        this.friday_module = "choose_adventure_card";
                    } else {
                        adventureService.shuffle_adventure_cards();
                        this.friday_module = "change_friday_stage";
                    }
                    break;
                case "choose_adventure_card":
                    Boolean check_adventure_action_cards = adventureService.dis_adventure_card(request.getDisAdventureActionCardIndex());
                    if (check_adventure_action_cards) {
                        this.friday_module = "daw_robinson_card";
                    } else {
                        this.friday_module = "change_friday_stage";
                    }
                    break;
                case "daw_robinson_card":
                    robinsonService.daw_robinson_card();
                    break;
                case "settle":
                    if (this.settle()) {
                        this.friday_module = "daw_adventure_card";
                    } else {
                        if (this.life <= 0) {
                            this.friday_module = "fail";
                        } else {
                            this.friday_module = "dis_card";
                        }
                    }
                    break;
                case "dis_card":
                    this.dis_cards(request.getDisRobinsonCard());
                    break;
                case "change_friday_stage":
                    Integer stage = this.change_friday_stage();
                    if (stage < 4) {
                        this.friday_module = "daw_adventure_card";
                    } else {
                        // 进入海盗阶段
                    }
                    break;
                default:
                    break;
            }
        }
        String stageString = this.stageToString();
        PostFridayInfoResponse.FridayInfoData fridayInfoData = new PostFridayInfoResponse.FridayInfoData();
        fridayInfoData.setStage(stageString);
        fridayInfoData.setModule(this.friday_module);
        fridayInfoData.setLife(this.life);
        fridayInfoData.setSettleLife(this.sttle_life);
        fridayInfoData.setRobinsonFreeNumber(robinsonService.robinson_free_number);
        fridayInfoData.setAdventureActionCards(adventureService.adventure_action_cards);
        fridayInfoData.setRobinsonActionLeftCards(robinsonService.robinson_action_left_cards);
        fridayInfoData.setRobinsonActionRightCards(robinsonService.robinson_action_right_cards);
        PostFridayInfoResponse postFridayInfoResponse = new PostFridayInfoResponse();
        postFridayInfoResponse.setCode(200);
        postFridayInfoResponse.setMessage("星期五获取成功");
        postFridayInfoResponse.setData(fridayInfoData);
        return postFridayInfoResponse;
    }

    // 换阶段
    public Integer change_friday_stage() {
        switch (this.friday_stage){
            case 1:
            case 2:
            case 3:
                ++this.friday_stage;
                return this.friday_stage;
            case 4:
                // 已经是最终阶段（海盗阶段）
                return this.friday_stage;
            default:
                return this.friday_stage;
        }
    }

    // 星期五的阶段
    public String stageToString() {
        String stageString;
        switch (this.friday_stage){
            case 1:
                stageString = "绿色";
                break;
            case 2:
                stageString = "黄色";
                break;
            case 3:
                stageString = "红色";
                break;
            case 4:
                // 已经是最终阶段（海盗阶段）
                stageString = "海盗";
                break;
            default:
                stageString = "未知状态";
                break;
        }
        return stageString;
    }

    // 战斗结算
    public Boolean settle() {
        // 抽卡次数清零
        robinsonService.robinson_free_number = 0;
        // 当前结算的总战斗值
        Integer robinson_number = 0;
        // 免费抽的鲁滨逊牌
        for (RobinsonCard robinson_action_left_card:robinsonService.robinson_action_left_cards) {
            // 重置鲁滨逊牌的使用状态
            if (!Objects.equals(robinson_action_left_card.getEffect(), "...")) {
                robinson_action_left_card.setIsUseEffect(true);
            }
            robinson_number += robinson_action_left_card.getNumber();
        }
        // 额外抽的鲁滨逊牌
        for (RobinsonCard robinson_action_right_card:robinsonService.robinson_action_right_cards) {
            // 重置鲁滨逊牌的使用状态
            if (!Objects.equals(robinson_action_right_card.getEffect(), "...")) {
                robinson_action_right_card.setIsUseEffect(true);
            }
            robinson_number += robinson_action_right_card.getNumber();
        }
        // 当前的冒险牌
        AdventureCard adventure_action_card = adventureService.adventure_action_cards.get(0);
        // 冒险牌需要的战斗值
        Integer adventure_card_number = 0;
        switch (this.friday_stage){
            case 1:
                adventure_card_number = adventure_action_card.getGreen();
                break;
            case 2:
                adventure_card_number = adventure_action_card.getYellow();
                break;
            case 3:
                adventure_card_number = adventure_action_card.getRed();
                break;
            case 4:
                // 已经是最终阶段（海盗阶段）
                break;
            default:
                break;
        }
        if (robinson_number >= adventure_card_number) {
            // 把当前的冒险牌转化为鲁滨逊牌放入鲁滨逊牌弃牌区并清空
            RobinsonCard adventure_card = new RobinsonCard();
            adventure_card.setIsUseEffect(adventure_action_card.getIsUseEffect());
            adventure_card.setLife(adventure_action_card.getLife());
            adventure_card.setEffect(adventure_action_card.getEffect());
            adventure_card.setName(adventure_action_card.getName());
            adventure_card.setNumber(adventure_action_card.getNumber());
            robinsonService.robinson_dis_cards.add(adventure_card);
            adventureService.adventure_action_cards.clear();
            // 免费抽的鲁滨逊牌放入鲁滨逊牌弃牌区并清空
            robinsonService.robinson_dis_cards.addAll(robinsonService.robinson_action_left_cards);
            robinsonService.robinson_action_left_cards.clear();
            // 额外抽的鲁滨逊牌放入鲁滨逊牌弃牌区并清空
            robinsonService.robinson_dis_cards.addAll(robinsonService.robinson_action_right_cards);
            robinsonService.robinson_action_right_cards.clear();
            return true;
        } else {
            // 结算扣除的生命值
            this.sttle_life = adventure_card_number - robinson_number;
            // 结算生命值
            this.life = this.life - this.sttle_life;
            // 把当前的冒险牌放入冒险牌弃牌区并清空
            adventureService.adventure_dis_cards.add(adventure_action_card);
            adventureService.adventure_action_cards.clear();
            return false;
        }
    }

    // 结算弃牌
    public Boolean dis_cards(PostFridayInfoRequest.DisRobinsonCard disRobinsonCard) {
        String disRobinsonCardAction = disRobinsonCard.getDisRobinsonCardAction();
        int disRobinsonCardActionIndex = disRobinsonCard.getDisRobinsonCardActionIndex();
        if (disRobinsonCardAction.equals("right")){
            Integer cardLife = robinsonService.robinson_action_right_cards.get(disRobinsonCardActionIndex).getLife();
            if (this.sttle_life >= cardLife) {
                this.sttle_life -= cardLife;
                robinsonService.robinson_action_right_cards.remove(disRobinsonCardActionIndex);
            }
        } else {
            Integer cardLife = robinsonService.robinson_action_left_cards.get(disRobinsonCardActionIndex).getLife();
            if (this.sttle_life >= cardLife) {
                this.sttle_life -= cardLife;
                robinsonService.robinson_action_left_cards.remove(disRobinsonCardActionIndex);
            }
        }
        return true;
    }
}
