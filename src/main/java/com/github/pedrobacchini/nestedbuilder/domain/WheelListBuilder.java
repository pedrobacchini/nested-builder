package com.github.pedrobacchini.nestedbuilder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class WheelListBuilder {

    static WheelListBuilder builder() { return new WheelListBuilder(); }

    private WheelListBuilder() { }

    private final List<Wheel> wheelList = new ArrayList<>();

    public WheelListBuilder addWheel(Consumer<Wheel.Builder> wheelBuilderConsumer) {
        Wheel.Builder wheelBuilder = Wheel.builder();
        wheelBuilderConsumer.accept(wheelBuilder);
        this.wheelList.add(wheelBuilder.build());
        return this;
    }

    List<Wheel> build() {
        if (this.wheelList.size() > 4) throw new IllegalArgumentException("the maximum of wheel is 4");
        return this.wheelList;
    }
}
