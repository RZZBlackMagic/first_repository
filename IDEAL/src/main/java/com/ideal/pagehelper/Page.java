/*
	The MIT License (MIT)

	Copyright (c) 2014 abel533@gmail.com

	Permission is hereby granted, free of charge, to any person obtaining a copy
	of this software and associated documentation files (the "Software"), to deal
	in the Software without restriction, including without limitation the rights
	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
	copies of the Software, and to permit persons to whom the Software is
	furnished to do so, subject to the following conditions:

	The above copyright notice and this permission notice shall be included in
	all copies or substantial portions of the Software.

	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
	THE SOFTWARE.
*/

package com.ideal.pagehelper;

import org.apache.ibatis.session.RowBounds;

import java.util.ArrayList;
import java.util.List;

/**
 * Mybatis - 鍒嗛〉瀵硅薄
 *
 * @author liuzh/abel533/isea533
 * @version 3.3.0
 *          椤圭洰鍦板潃 : http://git.oschina.net/free/Mybatis_PageHelper
 */
public class Page<E> extends ArrayList<E> {
    private static final long serialVersionUID = 1L;

    /**涓嶈繘琛宑ount鏌ヨ*/
    private static final int NO_SQL_COUNT = -1;
    /**杩涜count鏌ヨ*/
    private static final int SQL_COUNT = 0;
    /**椤电爜锛屼粠1寮�濮�*/
    private int pageNum;
    /**椤甸潰澶у皬*/
    private int pageSize;
    /**璧峰琛�*/
    private int startRow;
    /**鏈*/
    private int endRow;
    /**鎬绘暟*/
    private long total;
    /**鎬婚〉鏁�*/
    private int pages;
    /**鍒嗛〉鍚堢悊鍖�*/
    private boolean reasonable;

    public Page(){
    	super();
    }

    public Page(int pageNum, int pageSize) {
        this(pageNum, pageSize, SQL_COUNT);
    }

    public Page(int pageNum, int pageSize, boolean count) {
        this(pageNum, pageSize, count ? Page.SQL_COUNT : Page.NO_SQL_COUNT);
    }

    public Page(int pageNum, int pageSize, int total) {
        super(pageSize > -1 ? pageSize : 0);
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        calculateStartAndEndRow();
    }

    public Page(RowBounds rowBounds, boolean count) {
        this(rowBounds, count ? Page.SQL_COUNT : Page.NO_SQL_COUNT);
    }


    public Page(RowBounds rowBounds, int total) {
        super(rowBounds.getLimit() > -1 ? rowBounds.getLimit() : 0);
        this.pageSize = rowBounds.getLimit();
        this.startRow = rowBounds.getOffset();
        //RowBounds鏂瑰紡榛樿涓嶆眰count鎬绘暟锛屽鏋滄兂姹俢ount,鍙互淇敼杩欓噷涓篠QL_COUNT
        this.total = total;
        this.endRow = this.startRow + this.pageSize;
    }

    public List<E> getResult() {
        return this;
    }

    public int getPages() {
        return pages;
    }

    public int getEndRow() {
        return endRow;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        //鍒嗛〉鍚堢悊鍖栵紝閽堝涓嶅悎鐞嗙殑椤电爜鑷姩澶勭悊
        this.pageNum = (reasonable && pageNum <= 0) ? 1 : pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartRow() {
        return startRow;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
        if (pageSize > 0) {
            pages = (int) (total / pageSize + ((total % pageSize == 0) ? 0 : 1));
        } else {
            pages = 0;
        }
        //鍒嗛〉鍚堢悊鍖栵紝閽堝涓嶅悎鐞嗙殑椤电爜鑷姩澶勭悊
        if (reasonable && pageNum > pages) {
            pageNum = pages;
            calculateStartAndEndRow();
        }
    }

    public void setReasonable(boolean reasonable) {
        this.reasonable = reasonable;
        //鍒嗛〉鍚堢悊鍖栵紝閽堝涓嶅悎鐞嗙殑椤电爜鑷姩澶勭悊
        if (this.reasonable && this.pageNum <= 0) {
            this.pageNum = 1;
            calculateStartAndEndRow();
        }
    }

    /**
     * 璁＄畻璧锋琛屽彿
     */
    private void calculateStartAndEndRow() {
        this.startRow = this.pageNum > 0 ? (this.pageNum - 1) * this.pageSize : 0;
        this.endRow = this.startRow + this.pageSize * (this.pageNum > 0 ? 1 : 0);
    }

    public boolean isCount() {
        return this.total > NO_SQL_COUNT;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", startRow=" + startRow +
                ", endRow=" + endRow +
                ", total=" + total +
                ", pages=" + pages +
                '}';
    }
}
