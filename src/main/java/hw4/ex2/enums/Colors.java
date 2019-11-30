package hw4.ex2.enums;

public enum Colors {

    COLORS("Colors"),
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    private String colorName;

    Colors(final String colorName) {
        this.colorName = colorName;
    }

    public String getColorName() {
        return colorName;
    }
}
