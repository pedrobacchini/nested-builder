package com.github.pedrobacchini.nestedbuilder;

import com.github.pedrobacchini.nestedbuilder.domain.Car;
import com.github.pedrobacchini.nestedbuilder.domain.Engine;
import com.github.pedrobacchini.nestedbuilder.domain.Wheel;

class Main {

    public static void main(String[] args) {

        Car carSimple = Car.builder().build();
        Engine engineSimple = Engine.builder().build();
        Wheel wheelSimple = Wheel.builder().build();

        System.out.println(carSimple);
        System.out.println(engineSimple.toString());
        System.out.println(wheelSimple.toString());

        Car car = Car.builder()
                .addEngine(engine -> engine.withPower(100).withType(5))
                .addWheels(wheelListBuilder -> wheelListBuilder
                        .addWheel(wheel -> wheel.withType(1).withSize(2).withColour(2))
                        .addWheel(wheel -> wheel.withType(1).withSize(2).withColour(2))
                        .addWheel(wheel -> wheel.withType(1).withSize(2).withColour(2))
                        .addWheel(wheel -> wheel.withType(1).withSize(2).withColour(2))
                )
                .build();

        System.out.println(car.toString());

    }
}
