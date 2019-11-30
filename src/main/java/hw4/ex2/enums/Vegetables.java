package hw4.ex2.enums;

public enum Vegetables {

    VEGETABLES("Vegetables"),
    CUCUMBER("Cucumber"),
    ONION("Onion"),
    TOMATO("Tomato");

    private String vegetableName;

    Vegetables(final String colorName) {
        this.vegetableName = colorName;
    }

    public String getVegetableName() {
        return vegetableName;
    }
}
