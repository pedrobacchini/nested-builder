package com.github.pedrobacchini.nestedbuilder.domain;

import lombok.ToString;

import java.util.List;
import java.util.function.Consumer;

@ToString
public class Car {

    private Engine engine;
    private List<Wheel> wheelList;

    public static Builder builder() { return new Builder(); }

    public static final class Builder {

        private final Car car = new Car();

        public Builder addEngine(Consumer<Engine.Builder> engineBuilderConsumer) {
            Engine.Builder engineBuilder = Engine.builder();
            engineBuilderConsumer.accept(engineBuilder);
            this.car.engine = engineBuilder.build();
            return this;
        }

        public Builder addWheels(Consumer<WheelListBuilder> wheelListBuilderConsumer) {
            WheelListBuilder wheelListBuilder = WheelListBuilder.builder();
            wheelListBuilderConsumer.accept(wheelListBuilder);
            this.car.wheelList = wheelListBuilder.build();
            return this;
        }

        public Car build() { return car; }
    }
}
