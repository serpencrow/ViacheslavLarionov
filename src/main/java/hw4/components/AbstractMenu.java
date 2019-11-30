package hw4.components;

import com.codeborne.selenide.SelenideElement;
import hw4.components.enums.MenuSection;

import java.util.List;

public abstract class AbstractMenu {

    protected abstract List<SelenideElement> getMenuItems();

    protected abstract List<SelenideElement> getServiceDropdownItems();

    public List<SelenideElement> getMenuItemsInSection(final MenuSection menuSection) {
        return (menuSection.equals(MenuSection.MAIN_SECTION))
                ? getMenuItems()
                : getServiceDropdownItems();
    }

    public void menuItemClick(final MenuSection menuSection, final String itemName) {
        for (SelenideElement menuItem : getMenuItemsInSection(menuSection)) {
            if (!"".equals(menuItem.getText())
                    && itemName.equalsIgnoreCase(menuItem.getText())) {
                menuItem.click();
                break;
            }
        }
    }

    public boolean isMenuContainsItem(final MenuSection menuSection, final String itemName) {
        for (SelenideElement menuItem : getMenuItemsInSection(menuSection)) {
            if (!"".equals(menuItem.getText())
                    && menuItem.getText().toUpperCase()
                        .contains(itemName.toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}
