package com.github.pedrobacchini.nestedbuilder.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Car {

    private Engine engine;
    private List<Wheel> wheelList;

    @Builder
    public Car(Engine engine, List<Wheel> wheelList) {
        this.engine = engine;
        this.wheelList = wheelList;
    }
}
