package com.github.pedrobacchini.nestedbuilder.domain;

public class Wheel {

    private int size;
    private int type;
    private int colour;

    private Wheel(Builder builder) {
        this.size = builder.size;
        this.type = builder.type;
        this.colour = builder.colour;
    }

    public static Builder builder() { return new Builder(); }

    public static Builder builder(Wheel copy) {
        Builder builder = new Builder();
        builder.size = copy.size;
        builder.type = copy.type;
        builder.colour = copy.colour;
        return builder;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "size=" + size +
                ", type=" + type +
                ", colour=" + colour +
                '}';
    }

    public static final class Builder {
        private int size;
        private int type;
        private int colour;

        private Builder() {}

        public Builder withSize(int size) {
            this.size = size;
            return this;
        }

        public Builder withType(int type) {
            this.type = type;
            return this;
        }

        public Builder withColour(int colour) {
            this.colour = colour;
            return this;
        }

        public Wheel build() { return new Wheel(this); }
    }
}
