package com.github.pedrobacchini.nestedbuilder.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Engine {

    private int power;
    private int type;

    @Builder
    public Engine(int power, int type) {
        this.power = power;
        this.type = type;
    }
}
