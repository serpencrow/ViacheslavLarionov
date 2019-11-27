package hw3.components;

import hw3.enums.MenuSection;
import org.openqa.selenium.WebElement;
import java.util.List;

public abstract class AbstractMenu {

    protected abstract List<WebElement> getMenuItems();

    protected abstract List<WebElement> getServiceDropdownItems();

    public List<WebElement> getMenuItemsInSection(final MenuSection menuSection) {
        return (menuSection.equals(MenuSection.MAIN_SECTION))
                ? getMenuItems()
                : getServiceDropdownItems();
    }

    public void menuItemClick(final MenuSection menuSection, final String itemName) {
        for (WebElement menuItem : getMenuItemsInSection(menuSection)) {
            if (!"".equals(menuItem.getText())
                    && itemName.equalsIgnoreCase(menuItem.getText())) {
                menuItem.click();
                break;
            }
        }
    }

    public boolean isMenuContainsItem(final MenuSection menuSection, final String itemName) {
        for (WebElement menuItem : getMenuItemsInSection(menuSection)) {
            if (!"".equals(menuItem.getText())
                    && menuItem.getText().toUpperCase()
                        .contains(itemName.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public boolean isAllMenuItemsDisplayed(final MenuSection menuSection) {
        for (WebElement menuItem : getMenuItemsInSection(menuSection)) {
            if (!"".equals(menuItem.getText())
                    && !menuItem.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public int getHeaderItemsCount() {
        int itemCount = 0;

        for (WebElement menuItem : getMenuItems()) {
            if (!"".equals(menuItem.getText())) {
                itemCount += 1;
            }
        }
        return itemCount;
    }
}
