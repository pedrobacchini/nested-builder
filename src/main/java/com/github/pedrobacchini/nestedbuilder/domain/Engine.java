package com.github.pedrobacchini.nestedbuilder.domain;

import lombok.ToString;

@ToString
class Engine {

    private final int power;
    private final int type;

    private Engine(Builder builder) {
        this.power = builder.power;
        this.type = builder.type;
    }

    static Builder builder() { return new Builder(); }

    public static final class Builder {
        private int power;
        private int type;
        private Car.Builder carBuilder;

        private Builder() {}

        public Builder withPower(int power) {
            this.power = power;
            return this;
        }

        public Builder withType(int type) {
            this.type = type;
            return this;
        }

        public Car.Builder done() { return this.carBuilder.addEngine(this.build()); }

        void withCar(Car.Builder carBuilder) { this.carBuilder = carBuilder; }

        private Engine build() { return new Engine(this); }
    }
}
