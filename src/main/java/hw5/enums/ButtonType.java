package hw5.enums;

public enum  ButtonType {

    CHECKBOX("checkbox"),
    RADIOBUTTON("radiobutton");

    String buttonTypeName;

    ButtonType(String buttonTypeName) {
        this.buttonTypeName = buttonTypeName;
    }

    public String getButtonTypeName() {
        return buttonTypeName;
    }
}
