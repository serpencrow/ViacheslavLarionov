package hw4.ex2;

import hw4.ex2.enums.*;

import java.util.List;

public class TestData {

    private List<Numbers> numbers;
    private List<Elements> elements;
    private Colors color;
    private Metals metal;
    private List<Vegetables> vegetables;

    private TestData(final List<Numbers> numbers, final List<Elements> elements,
                     final Colors color, final Metals metal,
                     final List<Vegetables> vegetables) {
        this.numbers = numbers;
        this.elements = elements;
        this.color = color;
        this.metal = metal;
        this.vegetables = vegetables;
    }

    public List<Numbers> getNumbers() {
        return numbers;
    }

    public List<Elements> getElements() {
        return elements;
    }

    public Colors getColor() {
        return color;
    }

    public Metals getMetal() {
        return metal;
    }

    public List<Vegetables> getVegetables() {
        return vegetables;
    }

    public static TestDataBuilder testDataBuilder() {
        return new TestDataBuilder();
    }

    public static class TestDataBuilder {

        private List<Numbers> numbers;
        private List<Elements> elements;
        private Colors color;
        private Metals metal;
        private List<Vegetables> vegetables;

        private TestDataBuilder() {
        }

        public TestDataBuilder setNumbers(List<Numbers> numbers) {
            this.numbers = numbers;
            return this;
        }

        public TestDataBuilder setElements(List<Elements> elements) {
            this.elements = elements;
            return this;
        }

        public TestDataBuilder setColor(Colors color) {
            this.color = color;
            return this;
        }

        public TestDataBuilder setMetal(Metals metal) {
            this.metal = metal;
            return this;
        }

        public TestDataBuilder setVegetables(List<Vegetables> vegetables) {
            this.vegetables = vegetables;
            return this;
        }

        public TestData build() {
            return new TestData(numbers, elements, color, metal, vegetables);
        }
    }
}
