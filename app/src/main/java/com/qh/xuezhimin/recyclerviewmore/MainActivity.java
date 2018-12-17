package com.qh.xuezhimin.recyclerviewmore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.qh.xuezhimin.recyclerviewmore.Data.DataPresenter;
import com.qh.xuezhimin.recyclerviewmore.Data.DataView;
import com.qh.xuezhimin.recyclerviewmore.adapter.DataAdapter;
import com.qh.xuezhimin.recyclerviewmore.bean.Data;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DataView {

    private ImageView mMainHead;
    /**
     * 昵称
     */
    private TextView mMianName;
    /**
     * 请登录
     */
    private Button mBtnLogin;
    private XRecyclerView mXRecycleView;
    private DataPresenter mDataPresenter;
    private List<Data> mListData;
    private DataAdapter dataAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mListData = new ArrayList<>();


        //实例化p层
        mDataPresenter = new DataPresenter(this);
        mDataPresenter.getData();

        //适配器
        dataAdapter = new DataAdapter(getBaseContext(), mListData);
        mXRecycleView.setAdapter(dataAdapter);

        //线性布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        mXRecycleView.setLayoutManager(layoutManager);

    }

    private void initView() {
        mMainHead = findViewById(R.id.main_head);
        mMianName = findViewById(R.id.mian_name);
        mBtnLogin = findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(this);
        mXRecycleView = findViewById(R.id.x_recycle_view);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                break;
        }
    }


    //DataView 接口实现的方法
    @Override
    public void onDataSucess(List<Data> entityList) {
        if (entityList != null) {
            mListData.clear();
            mListData.addAll(entityList);
            dataAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFailer(Exception e) {

    }
}
