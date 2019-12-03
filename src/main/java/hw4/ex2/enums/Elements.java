package hw4.ex2.enums;

public enum Elements {

    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    private String elementName;

    Elements(final String elementName) {
        this.elementName = elementName;
    }

    public String getElementName() {
        return elementName;
    }
}
