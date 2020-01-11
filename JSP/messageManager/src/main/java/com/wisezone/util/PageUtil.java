package com.wisezone.util;

import java.util.List;

/**
 * 分页查询工具类
 * @param <T> T代表着被查询的数据的javabean
 */
public class PageUtil<T> {
    //默认起始页为1
    public static final int DEFAULT_PAGE_INDEX = 1;
    //默认每页显示5条数据
    public static final int DEFAULT_PAGE_SIZE = 3;

    //当前页码
    private Integer pageIndex = DEFAULT_PAGE_INDEX;

    //每页显示数据的条数，默认为5
    private Integer pageSize = DEFAULT_PAGE_SIZE;

    //数据库通过分页查询得到的结果集
    private List<T> data;

    //满足条件的数据总共有多少条
    private Integer total;

    //总共有多少页
    private Integer totalPages;

    private final int navigationCount = 5;//导航的页码数
    private int[] pageNavigation = null;  //用于存储分页数字

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * 总共有多少页
     * @return
     */
    public Integer totalPages(){
        //return this.total % this.pageSize == 0 ? this.total / this.pageSize : this.total / this.pageSize + 1;

        //向上取整
        double ceil = Math.ceil(this.total.doubleValue() / this.pageSize.doubleValue());
        return (int)ceil;
    }

    public Integer getTotalPage() {
        this.totalPages = totalPages();
        return totalPages;
    }

    /**
     * 获取下一页，最大页码为总页数
     * @return
     */
    public Integer nextPage(){
        if (this.pageIndex < this.totalPages()) {
            return this.pageIndex++;
        }
        return this.totalPages(); //直接返回最后一页
    }

    /**
     * 获取上一页页码
     * @return
     */
    public Integer prePage(){
        if (this.pageIndex > 1) {
            return this.pageIndex--;
        }
        return DEFAULT_PAGE_INDEX; //直接返回第一页
    }

    //是否有下一页
    public boolean hasNext() {
        return this.pageIndex < this.totalPages();
    }

    //是否有上一页
    public boolean hasPre() {
        return this.pageIndex > 1;
    }

    public int[] getNav(){
        //得到总页数
        this.totalPages = this.totalPages();
        //当总页数小于或等于导航页码数时
        if (this.totalPages <= navigationCount) {
            pageNavigation = new int[this.totalPages];//数组长度为总共页数的长度
            for (int i = 0; i < this.totalPages; i++) {
                pageNavigation[i] = i + 1;
            }
        } else { //当总页数大于导航页码数时
            pageNavigation = new int[navigationCount]; //肯定能够显示5页

            int startNum = pageIndex - navigationCount / 2; //页码的开始数
            int endNum = pageIndex + navigationCount / 2;   //页码的结束数

            if (startNum < 1) {
                startNum = 1;
                //(最前navPageCount页
                for (int i = 0; i < navigationCount; i++) {
                    pageNavigation[i] = startNum++;
                }
            } else if (endNum > this.totalPages) {
                endNum = this.totalPages;
                //最后navPageCount页
                for (int i = navigationCount - 1; i >= 0; i--) {
                    pageNavigation[i] = endNum--;
                }
            } else {
                //所有中间页
                for (int i = 0; i < navigationCount; i++) {
                    pageNavigation[i] = startNum++;
                }
            }
        }
        return pageNavigation;
    }
}
