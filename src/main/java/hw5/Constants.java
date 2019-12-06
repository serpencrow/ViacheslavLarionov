package hw5;

import java.util.Arrays;
import java.util.List;

public interface Constants {

    String HOME_URL = "https://epam.github.io/JDI/index.html";

    int HEADER_ITEM_COUNT = 4;

    int IMAGE_COUNT = 4;

    String HOME_PAGE_TITLE = "Home Page";

    List<String> HEADER_ITEM_NAMES = Arrays.asList(
            "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"
    );

    List<String> SERVICE_SUBCATEGORIES = Arrays.asList(
            "Support", "Dates", "Complex Table",
            "Simple Table", "Table with pages",
            "Different elements");

    List<String> TEXTS_UNDER_IMAGES = Arrays.asList(
            "To include good practices\n" +
                    "and ideas from successful\n" +
                    "EPAM project",
            "To be flexible and\n" +
                    "customizable",
            "To be multiplatform",
            "Already have good base\n" +
                    "(about 20 internal and\n" +
                    "some external projects),\n" +
                    "wish to get more…"
    );

    String FIRST_HEADER_TEXT = "EPAM FRAMEWORK WISHES…";

    String SECOND_HEADER_TEXT = "LOREM IPSUM DOLOR SIT AMET," +
            " CONSECTETUR ADIPISICING ELIT," +
            " SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
            "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI " +
            "UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT " +
            "IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";

    String SUBHEADER_TEXT = "JDI GITHUB";

    String SUBHEADER_LINK_TEXT = "https://github.com/epam/JDI";

    String DIFFERENT_ELEMENTS_PAGE = "https://epam.github.io/JDI/different-elements.html";

    List<String> CHECKBOX_NAMES = Arrays.asList("Water", "Wind");

    int CHECKBOX_COUNT = 4;

    int RADIOBUTTON_COUNT = CHECKBOX_COUNT;

    String RADIOBUTTON_NAME = "Selen";

    String COLOR = "Yellow";

    String PATH_TO_PROPERTIES = "src/test/resources/hw3/user.properties";

    String CHECKBOX_TRUE_LOG = ": condition changed to true";

    String CHECKBOX_FALSE_LOG = ": condition changed to false";

    String RADIOBUTTON_LOG = "metal: value changed to ";

    String SELECTION_LOG = "Colors: value changed to ";
}
