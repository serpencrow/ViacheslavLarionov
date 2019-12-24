package hw_jdi;

import java.util.List;

public class MetalsAndColorsFormData {

    private List<Integer> summary;

    private List<String> elements;

    private String color;

    private String metals;

    private List<String> vegetables;

    public List<Integer> getSummary() {
        return summary;
    }

    public void setSummary(final List<Integer> summary) {
        this.summary = summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public void setElements(final List<String> elements) {
        this.elements = elements;
    }

    public String getColor() {
        return color;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public String getMetals() {
        return metals;
    }

    public void setMetals(final String metals) {
        this.metals = metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public void setVegetables(final List<String> vegetables) {
        this.vegetables = vegetables;
    }

    @Override
    public String toString() {
        return "MetalsAndColorsFormData{" +
                "summary=" + summary +
                ", elements=" + elements +
                ", color='" + color + '\'' +
                ", metals=" + metals +
                ", vegetables=" + vegetables +
                '}';
    }
}
