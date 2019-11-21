package com.github.pedrobacchini.nestedbuilder;

import com.github.pedrobacchini.nestedbuilder.domain.Car;

class Main {

    public static void main(String[] args) {

        Car car = Car.builder()
                .addEngine().withPower(100).withType(5).done()
                .addWheels()
                    .addWheel().withType(1).withSize(2).withColour(2).addWheelToList()
                    .addWheel().withType(1).withSize(2).withColour(2).addWheelToList()
                    .addWheel().withType(1).withSize(2).withColour(2).addWheelToList()
                    .addWheel().withType(1).withSize(2).withColour(2).addWheelToList()
                .done()
                .build();

        System.out.println(car.toString());
    }
}
