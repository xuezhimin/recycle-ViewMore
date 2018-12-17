package com.qh.xuezhimin.recyclerviewmore.Data;

import com.google.gson.Gson;
import com.qh.xuezhimin.recyclerviewmore.bean.Root;
import com.qh.xuezhimin.recyclerviewmore.http.Utils;

public class DataModel {

    public static Root getListData() {
        String listShowData = Utils.get("http://www.xieast.com/api/news/news.php?page=1");
        Gson gson = new Gson();
        Root root = gson.fromJson(listShowData, Root.class);
        return root;
    }


}
