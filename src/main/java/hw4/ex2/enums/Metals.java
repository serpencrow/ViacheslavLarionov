package hw4.ex2.enums;

public enum Metals {

    METALS("Metals"),
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    private String metalName;

    Metals(final String metalName) {
        this.metalName = metalName;
    }

    public String getMetalName() {
        return metalName;
    }
}
