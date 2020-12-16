package com.example.demo.service;

import com.example.demo.baen.AgingCard;
import com.example.demo.baen.RobinsonCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class RobinsonService {
    @Autowired
    private FridayService fridayService;
    @Autowired
    private AgingService agingService;

    // 鲁滨逊牌（牌库）
    public ArrayList<RobinsonCard> robinson_cards;

    // 鲁滨逊阶段段（保存当前免费抽的鲁滨逊牌的次数）
    public Integer robinson_free_number;

    // 鲁滨逊阶段段（保存当前免费抽的鲁滨逊牌）
    public ArrayList<RobinsonCard> robinson_action_left_cards;
    // 鲁滨逊阶段段（保存当前额外抽的鲁滨逊牌）
    public ArrayList<RobinsonCard> robinson_action_rigth_cards;

    // 鲁滨逊阶段段（保存当前鲁滨逊牌的效果执行）
    public ArrayList<RobinsonCard> robinson_action_left_effect_card;
    public ArrayList<RobinsonCard> robinson_action_rigth_effect_card;

    // 鲁滨逊阶段段（保存当前鲁滨逊牌的预言牌）
    public ArrayList<RobinsonCard> robinson_action_effect_predict_cards;

    // 鲁滨逊阶段（保存当前的弃掉鲁滨逊牌）
    public ArrayList<RobinsonCard> robinson_dis_cards;

    // 检查鲁滨逊牌的数量
    public Boolean check_robinson_cards() {
        if (this.robinson_cards.size()>0){
            return true;
        } else {
            return false;
        }
    }

    // 抽鲁滨逊牌
    public ArrayList<RobinsonCard> daw_robinson_card() {
        if (this.robinson_cards.size() <= 0) {
            this.shuffle_adventure_cards();
        }
        if (this.robinson_free_number > 0) {
            RobinsonCard robinsonCard = this.robinson_cards.remove(0);
            if (robinsonCard.getName().equals("极度疲惫")) {
                robinsonCard.setIsUseEffect(false);
                this.robinson_free_number = 0;
            } else {
                this.robinson_free_number = this.robinson_free_number--;
            }
            this.robinson_action_left_cards.add(robinsonCard);
            return this.robinson_action_left_cards;
        } else {
            fridayService.life = fridayService.life--;
            this.robinson_action_rigth_cards.add(this.robinson_cards.remove(0));
            return this.robinson_action_rigth_cards;
        }
    }

    // 弃鲁滨逊牌
    public Boolean dis_robinson_card(String robinsonAction,int adventure_action_card_index) {
        if (robinsonAction.equals("right")){
            this.robinson_action_rigth_cards.remove(adventure_action_card_index);
        } else {
            this.robinson_action_left_cards.remove(adventure_action_card_index);
        }
        return true;
    }

    // 使用鲁滨逊牌的效果
    public Boolean effect_robinson_card(String robinsonAction,int adventure_action_card_index) {
        String robinson_card_effect;
        if (robinsonAction.equals("right")){
            this.robinson_action_rigth_cards.get(adventure_action_card_index).setIsUseEffect(false);
            robinson_card_effect = this.robinson_action_rigth_cards.get(adventure_action_card_index).getEffect();
        } else {
            this.robinson_action_left_cards.get(adventure_action_card_index).setIsUseEffect(false);
            robinson_card_effect = this.robinson_action_left_cards.get(adventure_action_card_index).getEffect();
        }
        switch (robinson_card_effect){
            case "+1生命值":
                if (fridayService.life < 20) {
                    fridayService.life = fridayService.life++;
                }
                break;
            case "+2生命值":
                if (fridayService.life < 19) {
                    fridayService.life = fridayService.life + 2;
                }
                break;
            case "1×牌库底":
                this.robinson_action_effect_card(robinsonAction,adventure_action_card_index);
                fridayService.friday_module = "robinson_effect_card:bottom";
                break;
            case "+1张牌":
                this.robinson_action_rigth_cards.add(this.robinson_cards.remove(0));
                break;
            case "1×摧毁":
                this.robinson_action_effect_card(robinsonAction,adventure_action_card_index);
                fridayService.friday_module = "robinson_effect_card:destroy";
                break;
            case "1×复制":
                this.robinson_action_effect_card(robinsonAction,adventure_action_card_index);
                fridayService.friday_module = "robinson_effect_card:copy";
                break;
            case "看3张牌":
                // 拿出3张鲁滨逊牌，并放入预言牌库
                if (this.robinson_cards.size() > 2) {
                    this.robinson_action_effect_predict_cards.add(this.robinson_cards.remove(0));
                    this.robinson_action_effect_predict_cards.add(this.robinson_cards.remove(0));
                    this.robinson_action_effect_predict_cards.add(this.robinson_cards.remove(0));
                } else if (this.robinson_cards.size() > 1) {
                    this.robinson_action_effect_predict_cards.add(this.robinson_cards.remove(0));
                    this.robinson_action_effect_predict_cards.add(this.robinson_cards.remove(0));
                    this.shuffle_adventure_cards();
                    this.robinson_action_effect_predict_cards.add(this.robinson_cards.remove(0));
                } else if (this.robinson_cards.size() > 0) {
                    this.robinson_action_effect_predict_cards.add(this.robinson_cards.remove(0));
                    this.shuffle_adventure_cards();
                    this.robinson_action_effect_predict_cards.add(this.robinson_cards.remove(0));
                    this.robinson_action_effect_predict_cards.add(this.robinson_cards.remove(0));
                } else {
                    this.shuffle_adventure_cards();
                    this.robinson_action_effect_predict_cards.add(this.robinson_cards.remove(0));
                    this.robinson_action_effect_predict_cards.add(this.robinson_cards.remove(0));
                    this.robinson_action_effect_predict_cards.add(this.robinson_cards.remove(0));
                }
                fridayService.friday_module = "robinson_effect_card:predict";
                break;
            case "阶段-1":
                // pass;
                break;
            default:
                break;
        }
        return true;
    }

    private Boolean robinson_action_effect_card(String robinsonAction,int adventure_action_card_index){
        if (robinsonAction.equals("right")) {
            // 移除鲁滨逊牌执行区的鲁滨逊牌并放入鲁滨逊牌的技能执行区
            robinson_action_rigth_effect_card.add(this.robinson_action_rigth_cards.remove(adventure_action_card_index));
        } else {
            // 移除鲁滨逊牌执行区的鲁滨逊牌并放入鲁滨逊牌的技能执行区
            robinson_action_left_effect_card.add(this.robinson_action_left_cards.remove(adventure_action_card_index));
        }
        return true;
    }

    // 重洗鲁滨逊弃牌区的牌并放回冒险牌区域（如有有老化牌则抽一张老化牌放入鲁滨逊弃牌区）
    public Boolean shuffle_adventure_cards() {
        // 如有有老化牌则抽一张老化牌放入鲁滨逊弃牌区
        if (agingService.aging_cards.size()>0) {
            AgingCard aging_card = agingService.aging_cards.remove(0);
            RobinsonCard robinsonCard = new RobinsonCard();
            robinsonCard.setLife(aging_card.getLife());
            robinsonCard.setEffect(aging_card.getEffect());
            robinsonCard.setIsUseEffect(aging_card.getIsUseEffect());
            robinsonCard.setName(aging_card.getName());
            robinsonCard.setNumber(aging_card.getNumber());
            this.robinson_dis_cards.add(robinsonCard);
        }
        Collections.shuffle(this.robinson_dis_cards);
        this.robinson_cards = this.robinson_dis_cards;
        this.robinson_dis_cards.clear();
        fridayService.friday_module = "daw_robinson_card";
        return true;
    }
}
