package com.example.demo.baen;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PostFridayInfoRequest {
    @NotNull(message = "isFriday不能为空")
    private Boolean isFriday;

    private Integer adventureActionCardIndex;
}
