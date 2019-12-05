package hw5.enums;

public enum MenuType {

    HEADER_MENU("Header menu"),
    LEFT_SIDE_MENU("Left menu");

    String menuTypeName;

    MenuType(final String menuTypeName) {
        this.menuTypeName = menuTypeName;
    }

    public String getMenuTypeName() {
        return menuTypeName;
    }
}
