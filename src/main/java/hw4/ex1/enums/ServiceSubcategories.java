package hw4.ex1.enums;

public enum ServiceSubcategories {

    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex table"),
    SIMPLE_TABLE("Simple table"),
    TABLE_WITH_PAGES("Table with pages"),
    DIFFERENT_ELEMENTS("Different elements");

    private String categoryName;

    ServiceSubcategories(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
