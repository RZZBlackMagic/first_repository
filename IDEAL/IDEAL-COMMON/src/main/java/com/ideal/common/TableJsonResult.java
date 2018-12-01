package com.ideal.common;

import java.io.Serializable;
import java.util.List;

public class TableJsonResult implements Serializable {

    private long total;
    private List rows;

    public TableJsonResult(){}

    public TableJsonResult(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public List getRows() {
        return rows;
    }
    public void setRows(List rows) {
        this.rows = rows;
    }
}
