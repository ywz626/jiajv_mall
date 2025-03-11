package com.ywz.furns.service.impl;

import com.ywz.furns.bean.Furn;
import com.ywz.furns.bean.Page;
import com.ywz.furns.dao.impl.FurnsDAOImpl;
import com.ywz.furns.service.FurnsService;

import java.util.List;

/**
 * @author 于汶泽
 */
public class FurnsServiceImpl implements FurnsService {
    private FurnsDAOImpl furnsDAO = new FurnsDAOImpl();
    @Override
    public List<Furn> getFurns() {
        return furnsDAO.getAllFurns();
    }

    @Override
    public Page<Furn> getPage(Integer pageNo, Integer pageSize) {
//        private Integer pag
//        // 一页最多可以显示几页数据
//        private Integer page_size = PAGE_SIZE;
//        // 总共有多少页数据 是算出来的
//        private Integer pageTotal;
//        //总共有多少行数据
//        private Integer pageTotalCount;
//        // 数据集合
//        private List<T> dataList;
//        private String url;
        Page<Furn> Page = new Page<>();
        Page.setPage_size(pageSize);
        Page.setPageTotalCount(furnsDAO.getTotalRows());
        int totalRows = furnsDAO.getTotalRows();
        int pageTotal = totalRows/pageSize;
        if(totalRows % pageSize!= 0){
            pageTotal++;
        }
        Page.setPageTotal(pageTotal);
        Page.setPage(pageNo);
        int begin = (pageNo-1) * pageSize;
        furnsDAO.getPageData(begin,pageSize);
        return Page;
    }

    @Override
    public boolean addFurn(Furn furn) {
        return furnsDAO.insertFurn(furn) != -1;
    }
    @Override
    public boolean deleteFurn(Furn furn){
        return furnsDAO.deleteFurn(furn)!= -1;
    }
    @Override
    public boolean updateFurn(Furn furn) {
        return furnsDAO.updateFurn(furn)!= -1;
    }

    @Override
    public Furn getFurnById(Integer id) {
        return furnsDAO.getFurn(id);
    }
}
