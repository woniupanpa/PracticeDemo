package com.example.admin.frameworkdemo.RecycleView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.frameworkdemo.R;

/**
 * Created by Administrator on 2017/11/27.
 */
public class RecycleviewTestActivity extends Activity {
    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private HomeAdapter mAdapter;
    MyItemOnclickListener mMyItemOnClickListener;
    private static final String TAG = "RecycleviewTestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycleview_activity_single);

        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        mRecyclerView.setAdapter(mAdapter = new HomeAdapter());
        //垂直
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL_LIST));

        mAdapter.setItemOnClickListener(new MyItemOnclickListener() {
            @Override
            public void onItemOnclick(View view, int postion) {
                Log.d("yjm",postion+"");
            }
        });

        //水平
      /*  mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.HORIZONTAL_LIST));*/
        //grid
        /*mRecyclerView.setLayoutManager(new GridLayoutManager(this,9));
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));*/

        //瀑布流
       /* mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));*/
    }

    protected void initData(){
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++)
        {
            mDatas.add("" + (char) i);
        }
    }

    class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
    {

        //当RecyclerView需要一个新的类型的item的ViewHolder的时候调用这个方法
        //是用来配合写好的ViewHolder来返回一个ViewHolder对象。这里也涉及到了条目布局的加载。
        // viewType则表示需要给当前position生成的是哪一种ViewHolder，
        // 这个参数也说明了RecyclerView对多类型ItemView的支持。
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            Log.d(TAG, "onCreateViewHolder--->");
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(RecycleviewTestActivity.this).inflate(R.layout.recycleview_item_home, parent,
                    false), mMyItemOnClickListener);
            return holder;
        }

        //专门用来绑定ViewHolder里的控件和数据源中position位置的数据。
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
        {
            Log.d(TAG, "onBindViewHolder--->" + position);
            //瀑布流在该函数里面设置随意高度
           /* Random random = new Random();
            ViewGroup.LayoutParams layoutParams = ((MyViewHolder)holder).tv.getLayoutParams();
            layoutParams.height=random.nextInt(200)+50;
            ((MyViewHolder)holder).tv.setLayoutParams(layoutParams);*/
            ((MyViewHolder)holder).tv.setText(mDatas.get(position)+position);
        }

        @Override
        public int getItemCount()
        {
            return mDatas.size();
        }

        //2、在ViewHolder中实现单击监听：
        class MyViewHolder extends ViewHolder implements View.OnClickListener
        {

            TextView tv;
            MyItemOnclickListener mListener;
            //构造函数
            public MyViewHolder(View view, MyItemOnclickListener myItemOnClickListener)
            {
                super(view);
                tv = (TextView) view.findViewById(R.id.id_num);
                this.mListener = myItemOnClickListener;
                tv.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                if(mListener!=null){
                    mListener.onItemOnclick(view, getPosition());
                }
            }





            //上面的代码就是ViewHolder，在itemView或是里面包含的子View实现setOnClickListener，
            // 在OnClick中接受接口实例化传入的具体处理事件，即mListener。在这里也能看的出来，
            // 只有viewholder中可以实现点击监听。
        }

        public void setItemOnClickListener(MyItemOnclickListener listener){
            mMyItemOnClickListener=listener;
        }

        //是用来根据position的不同来实现RecyclerView中对不同布局的要求。从这个方法中所返回的值会在onCreateViewHolder中用到。比如头部，尾部，等等的特殊itemView（这里说成ViewHolder比较好）都可以在这里进行判断。
        //getItemViewType(int position)

    }

    //1:定义接口：在接口中，定义接口方法onItemOnClick方法，
    // 在里面实现具体的点击响应事件，同时传入两个参数：view和postion。
    // 和ListView中item的点击一样
    public interface MyItemOnclickListener{
        public void onItemOnclick(View view, int position);
    }
}

