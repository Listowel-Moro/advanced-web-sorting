package listo.model;

import java.util.List;

public class DataSet {
    private List<Integer> data;

    public DataSet(List<Integer> data) {
        this.data = data;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }
}
