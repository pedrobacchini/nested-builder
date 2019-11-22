package com.github.pedrobacchini.nestedbuilder.domain;

import lombok.ToString;

@ToString
public class Engine {

    private final int power;
    private final int type;

    private Engine(Builder builder) {
        this.power = builder.power;
        this.type = builder.type;
    }

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private int power;
        private int type;

        public Builder withPower(int power) {
            this.power = power;
            return this;
        }

        public Builder withType(int type) {
            this.type = type;
            return this;
        }

        public Engine build() { return new Engine(this); }
    }
}
