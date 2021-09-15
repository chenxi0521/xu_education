package com.youxue.util;

import java.util.List;

/**
 * @author chenxi
 * @date 2021/9/7 21:03
 * @description
 */
public class PageUtil<T> {

    private int currentPage;//当前页数
    private int rows;//每页行数
    private int index;//偏移量
    private int totalPage;//总页数
    private int totalRows;//总条数
    private int prePage;//上一页
    private int nextPage;//下一页
    private List<T> list;


    public PageUtil(int currentPage,int rows,int totalRows) {
        this.currentPage = currentPage;
        this.rows = rows;
        this.totalRows = totalRows;
        setIndex();
        setTotalPage();
        setPrePage();
        setNextPage();
    }

    private void setIndex(){
        this.index = (currentPage-1)*rows;
    }

    private void setTotalPage(){
        this.totalPage = (int) Math.ceil(totalRows*1.0/rows);
    }

    private void setPrePage(){
        if (this.currentPage<=1){
            this.prePage = 1;
        }else {
            this.prePage =this.currentPage - 1;
        }
    }

    private void setNextPage(){
        if (this.currentPage>=this.totalPage){
            this.nextPage = totalPage;
        }else {
            this.nextPage = this.currentPage + 1;
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getRows() {
        return rows;
    }

    public int getIndex() {
        return index;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getPrePage() {
        return prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "currentPage=" + currentPage +
                ", rows=" + rows +
                ", index=" + index +
                ", totalPage=" + totalPage +
                ", totalRows=" + totalRows +
                ", prePage=" + prePage +
                ", nextPage=" + nextPage +
                '}';
    }
}
