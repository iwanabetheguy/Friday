package com.example.demo.service;

import com.example.demo.baen.AdventureCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class AdventureService {
    @Autowired
    private FridayService fridayService;
    @Autowired
    private RobinsonService robinsonService;

    // 冒险牌（牌库）
    public ArrayList<AdventureCard> adventure_cards;

    // 冒险阶段（保存当前的行动冒险牌）
    public ArrayList<AdventureCard> adventure_action_cards;

    // 冒险阶段（保存当前的弃掉冒险牌）
    public ArrayList<AdventureCard> adventure_dis_cards;

    // 检查冒险牌的数量
    public Boolean check_adventure_cards() {
        if (this.adventure_cards.size()>0){
            return true;
        } else {
            return false;
        }
    }

    // 检查冒险牌执行区的数量
    public Boolean check_adventure_action_cards() {
        if (this.adventure_action_cards.size()>0){
            return true;
        } else {
            return false;
        }
    }

    // 抽冒险牌
    public ArrayList<AdventureCard> daw_adventure_card() {
        if (this.adventure_cards.size() > 1) {
            // 抽2张冒险牌(进入选择冒险牌阶段)
            this.adventure_action_cards.add(this.adventure_cards.remove(0));
            this.adventure_action_cards.add(this.adventure_cards.remove(0));
            return this.adventure_action_cards;
        } else {
            // 抽1张冒险牌(进入选择冒险牌阶段)
            this.adventure_action_cards.add(this.adventure_cards.remove(0));
            return this.adventure_action_cards;
        }
    }

    // 弃冒险牌，返回执行区有没有牌
    public Boolean dis_adventure_card(int adventure_action_card_index) {
        this.adventure_dis_cards.add(adventure_action_cards.remove(adventure_action_card_index));
        Boolean check_adventure_action_cards = this.check_adventure_action_cards();
        if (check_adventure_action_cards) {
            robinsonService.robinson_free_number = adventure_action_cards.get(0).getDraw();
        } else {
            robinsonService.robinson_free_number = 0;
        }
        return check_adventure_action_cards;
    }

    // 重洗冒险牌弃牌区的牌并放回冒险牌区域
    public Boolean shuffle_adventure_cards() {
        Collections.shuffle(this.adventure_dis_cards);
        this.adventure_cards = this.adventure_dis_cards;
        this.adventure_dis_cards.clear();
        return true;
    }
}
