package hw5.enums;

public enum MenuSection {

    MAIN_SECTION("main menu"),
    SERVICE_SECTION("service dropdown");

    String menuSectionName;

    MenuSection(final String menuSectionName) {
        this.menuSectionName = menuSectionName;
    }

    public String getMenuSectionName() {
        return menuSectionName;
    }
}
