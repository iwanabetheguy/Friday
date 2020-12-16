package com.example.demo.baen;
import lombok.Data;

@Data
public class AgingCard {
    private String  name;               // 名字
    private Integer number;             // 攻击值
    private String  effect;             // 效果
    private Integer life;               // 生命值
    private Boolean isUseEffect;        // 效果是否可以使用
}
