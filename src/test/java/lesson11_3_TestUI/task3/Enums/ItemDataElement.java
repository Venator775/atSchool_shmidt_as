package lesson11_3_TestUI.task3.Enums;

public enum ItemDataElement {
    NAME("name"),
    DESC("desc"),
    PRICE("price"),
    ;

    public String getValue() {
        return value;
    }

    private String value;

    ItemDataElement(String value) {
        this.value = value;
    }
}
