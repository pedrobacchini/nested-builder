package com.github.pedrobacchini.nestedbuilder.domain;

import java.util.ArrayList;
import java.util.List;

public class WheelListBuilder {

    public static WheelListBuilder newBuilder() {
        return new WheelListBuilder();
    }

    private WheelListBuilder() { }

    private List<Wheel> wheelList;

    public WheelListBuilder withNewList() {
        this.wheelList = new ArrayList<>();
        return this;
    }

    public WheelListBuilder withList(List<Wheel> wheelList) {
        this.wheelList = wheelList;
        return this;
    }

    public WheelListBuilder addWheel(Wheel wheel) {
        this.wheelList.add(wheel);
        return this;
    }

    public List<Wheel> build() {
        if (this.wheelList.size() > 4) throw new IllegalArgumentException("the maximum of wheel is 4");
        return this.wheelList;
    }
}
