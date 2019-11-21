package com.github.pedrobacchini.nestedbuilder.domain;

import java.util.ArrayList;
import java.util.List;

public class WheelListBuilder {

    static WheelListBuilder builder() { return new WheelListBuilder(); }

    private WheelListBuilder() { }

    private final List<Wheel> wheelList = new ArrayList<>();
    private Car.Builder carBuilder;

    WheelListBuilder addWheel(Wheel wheel) {
        this.wheelList.add(wheel);
        return this;
    }

    public Wheel.Builder addWheel() {
        Wheel.Builder builder = Wheel.builder();
        builder.withWheelListBuilder(this);
        return builder;
    }

    public Car.Builder done() { return this.carBuilder.addWheels(this.build()); }

    void withCar(Car.Builder carBuilder) { this.carBuilder = carBuilder; }

    private List<Wheel> build() {
        if (this.wheelList.size() > 4) throw new IllegalArgumentException("the maximum of wheel is 4");
        return this.wheelList;
    }
}
