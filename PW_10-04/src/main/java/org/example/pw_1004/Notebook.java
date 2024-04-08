package org.example.pw_1004;

public class Notebook {
    private int id;
    private String manufacturer;
    private String notebookName;
    private int numberOfPages;
    private String coverType;
    private String country;
    private String pageStyle;
    public int getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getNotebookName() {
        return notebookName;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getCoverType() {
        return coverType;
    }

    public String getCountry() {
        return country;
    }

    public String getPageStyle() {
        return pageStyle;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setNotebookName(String notebookName) {
        this.notebookName = notebookName;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPageStyle(String pageStyle) {
        this.pageStyle = pageStyle;
    }
}
