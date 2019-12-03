package hw4.ex2.enums;

public enum Numbers {

    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8");

    private String numberValue;

    Numbers(final String numberValue) {
        this.numberValue = numberValue;
    }

    public String getNumberValue() {
        return numberValue;
    }
}
