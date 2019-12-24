package hw_jdi.enums;

public enum HeaderMenuItem {
    HOME("HOME"),
    SEARCH("SEARCH"),
    SERVICE("SERVICE"),
    METALS_AND_COLORS("METALS & COLORS");

    private String itemName;

    HeaderMenuItem(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }
}
