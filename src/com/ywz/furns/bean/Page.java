package com.ywz.furns.bean;

import java.util.List;

/**
 * @author 于汶泽
 */
public class Page<T> {
    public  static final Integer PAGE_SIZE = 3;
    // 当前页码
    private Integer pageNo;
    // 一页最多可以显示几页数据
    private Integer page_size = PAGE_SIZE;
    // 总共有多少页数据 是算出来的
    private Integer pageTotal;
    //总共有多少行数据
    private Integer pageTotalCount;
    // 数据集合
    private List<T> dataList;
    private String url;

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Page() {
    }

    @Override
    public String toString() {
        return "Page{" +
                "PAGE_SIZE=" + PAGE_SIZE +
                ", pageNo=" + pageNo +
                ", page_size=" + page_size +
                ", pageTotal=" + pageTotalCount +
                ", dataList=" + dataList +
                ", url='" + url + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Page(Integer pageNo, Integer page_size, Integer pageTotalCount, List<T> dataList, String url) {
        this.pageNo = pageNo;
        this.page_size = page_size;
        this.pageTotalCount = pageTotalCount;
        this.dataList = dataList;
        this.url = url;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPage_size() {
        return page_size;
    }

    public void setPage_size(Integer page_size) {
        this.page_size = page_size;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public Page(Integer pageNo, Integer page_size, Integer pageTotalCount, List<T> dataList) {
        this.pageNo = pageNo;
        this.page_size = page_size;
        this.pageTotalCount = pageTotalCount;
        this.dataList = dataList;
    }
}
