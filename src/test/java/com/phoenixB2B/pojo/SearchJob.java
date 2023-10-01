package com.phoenixB2B.pojo;

//http://139.59.91.96:9000/v1/job/search Method: Post

public class SearchJob {
    private String searchText;

    public SearchJob(String searchText) {
        this.searchText = searchText;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    @Override
    public String toString() {
        return "Search{" +
                "searchText='" + searchText + '\'' +
                '}';
    }
}
