package com.github.pedrobacchini.nestedbuilder;

import com.github.pedrobacchini.nestedbuilder.domain.Car;
import com.github.pedrobacchini.nestedbuilder.domain.Engine;
import com.github.pedrobacchini.nestedbuilder.domain.Wheel;
import com.github.pedrobacchini.nestedbuilder.domain.WheelListBuilder;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Engine engine = Engine.builder().power(100).type(5).build();

        Wheel wheel1 = Wheel.builder().withType(2).withColour(3).withSize(4).build();
        Wheel wheel2 = Wheel.builder(wheel1).build();
        Wheel wheel3 = Wheel.builder(wheel1).build();

//        With pure list
//        List<Wheel> wheels = new ArrayList<>();
//        wheels.add(wheel1);
//        wheels.add(wheel2);
//        wheels.add(wheel3);

//        With WheelListBuilder
        List<Wheel> wheelList = WheelListBuilder.newBuilder()
                .withNewList()
                .addWheel(wheel1)
                .addWheel(wheel2)
                .addWheel(wheel3)
                .build();

        Car car = Car.builder().engine(engine).wheelList(wheelList).build();

        System.out.println(car.toString());
    }
}
