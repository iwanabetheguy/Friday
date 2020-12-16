package com.example.demo.baen;
import lombok.Data;

@Data
public class AdventureCard {
    private String  name;               // 名字
    private Integer number;             // 攻击值
    private String  effect;             // 效果
    private Integer life;               // 生命值
    private Boolean isUseEffect;        // 效果是否可以使用
    private String  adventure;          // 冒险名称
    private Integer draw;               // 抽牌的数量
    private Integer green;              // 绿色阶段要达到的冒险值
    private Integer yellow;             // 黄色阶段要达到的冒险值
    private Integer red;                // 红色阶段要达到的冒险值
}
