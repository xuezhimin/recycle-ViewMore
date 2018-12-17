package com.qh.xuezhimin.recyclerviewmore.Data;

import com.qh.xuezhimin.recyclerviewmore.bean.Data;

import java.util.List;

public interface DataView {

    void onDataSucess(List<Data> entityList);

    void onFailer(Exception e);



}
