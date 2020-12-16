package com.example.demo.baen;
import lombok.Data;

@Data
public class PirateCard {
    private String  name;               // 名字
    private Integer number;             // 攻击值
    private Integer draw;               // 抽牌的数量
    private String  effect;             // 效果
    private Boolean isUseEffect;        // 效果是否可以使用
}
