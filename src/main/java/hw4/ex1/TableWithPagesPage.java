package hw4.ex1;

import com.codeborne.selenide.ElementsCollection;
import hw4.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

public class TableWithPagesPage extends AbstractBasePage {

    @FindBy(xpath = "//select[@name='table-with-pages_length']")
    private SelenideElement entriesCountSelector;

    @FindBy(xpath = "//ul[contains(@class, 'logs')]//li")
    private List<SelenideElement> logRows;

    @FindBy(xpath = "//table[@id='table-with-pages']//tbody")
    private SelenideElement entitiesTable;

    @FindBy(css = ".dataTables_filter:nth-child(2) input")
    private SelenideElement searchTextField;

    public TableWithPagesPage() {
        super();
    }

    public SelenideElement getEntriesCountSelector() {
        return entriesCountSelector;
    }

    public List<SelenideElement> getLogList() {
        return logRows;
    }

    public ElementsCollection getEntitiesFromTable() {
        return entitiesTable.$$(By.tagName("tr"));
    }

    public void fillSearchTextField(final String searchText) {
        searchTextField.setValue(searchText);
    }

    public ElementsCollection getTableEntitiesNowOptions() {
        return entitiesTable.$$(By.cssSelector("tr td:nth-child(2)"));
    }
}
