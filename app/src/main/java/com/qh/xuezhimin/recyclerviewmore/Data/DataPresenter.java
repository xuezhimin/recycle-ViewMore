package com.qh.xuezhimin.recyclerviewmore.Data;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.qh.xuezhimin.recyclerviewmore.bean.Root;

public class DataPresenter {

    private DataView dataView;

    public DataPresenter(DataView dataView) {
        this.dataView = dataView;
    }


    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            Root root = (Root) msg.obj;
            dataView.onDataSucess(root.getData());
        }
    };


    public void getData() {
        new Thread() {
            @Override
            public void run() {
                Root listData = DataModel.getListData();
                Message mMessage = mHandler.obtainMessage();
                mMessage.obj = listData;
                mHandler.sendMessage(mMessage);
            }
        }.start();
    }


}
