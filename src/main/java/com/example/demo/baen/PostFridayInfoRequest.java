package com.example.demo.baen;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PostFridayInfoRequest {
    @NotNull(message = "isFriday不能为空")
    private Boolean isFriday;

    private Integer disAdventureActionCardIndex;    // 需要弃除的冒险卡索引

    private String goFridayModule;  // 需要跳转的模块

    private DisRobinsonCard disRobinsonCard;   // 需要弃除的鲁滨逊牌

    @Data
    public static class DisRobinsonCard {
        private String disRobinsonCardAction;  // 需要弃除的鲁滨逊牌所在的区域

        private Integer disRobinsonCardActionIndex;  // 需要弃除的鲁滨逊牌索引
    }
}
