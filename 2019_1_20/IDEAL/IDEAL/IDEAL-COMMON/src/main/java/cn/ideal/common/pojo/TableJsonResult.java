package cn.ideal.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author XINER
 * @create 2018-11-27 18:51
 * @desc BOOTSTRAP TABLE JSON对象
 **/
public class TableJsonResult implements Serializable {

    private long total;
    private List rows;

    public TableJsonResult() {
    }


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

    @Override
    public String toString() {
        return "TableJsonResult{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
