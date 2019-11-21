package com.github.pedrobacchini.nestedbuilder.domain;

import lombok.ToString;

import java.util.List;

@ToString
public class Car {

    private final Engine engine;
    private final List<Wheel> wheelList;

    private Car(Builder builder) {
        this.engine = builder.engine;
        this.wheelList = builder.wheelList;
    }

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private Engine engine;
        private List<Wheel> wheelList;

        Builder addEngine(Engine engine) {
            this.engine = engine;
            return this;
        }

        Builder addWheels(List<Wheel> wheelList) {
            this.wheelList = wheelList;
            return this;
        }

        public Engine.Builder addEngine() {
            Engine.Builder builder = Engine.builder();
            builder.withCar(this);
            return builder;
        }

        public WheelListBuilder addWheels() {
            WheelListBuilder builder = WheelListBuilder.builder();
            builder.withCar(this);
            return builder;
        }

        public Car build() { return new Car(this); }
    }
}
