package com.example.admin.frameworkdemo.Fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.admin.frameworkdemo.R;

public class LeftFragment extends Fragment
{
    /** Acitivity要实现这个接口，这样Fragment和Activity就可以共享事件触发的资源了 */
    //当activity通过这个接口接收到一个回调，它可以同布局中的其他fragment分享这个信息。
    public interface MyListener
    {
        public void showMessage(int index);
    }

    private MyListener myListener;
    private Button firstButton;
    private Button secondButton;
    private Button thirdButton;

    /** Fragment第一次附属于Activity时调用,在onCreate之前调用 */
    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        System.out.println("LeftFragment--->onAttach");
        //为了确保宿主activity实现这个接口，fragment A的onAttach() 方法
        //（这个方法在fragment 被加入到activity中时由系统调用）中通过将传入的activity强制类型转换
        //实例化一个MyListener对象
        myListener = (MyListener) activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        System.out.println("LeftFragment--->onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        System.out.println("LeftFragment--->onCreateView");
        return inflater.inflate(R.layout.leftfragment, container, false);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        System.out.println("LeftFragment--->onResume");

        //fragment可以通过getActivity() 方法来获得Activity的实例，然后就可以调用一些例如findViewById()之类的方法。
        //但是注意调用getActivity()时，fragment必须和activity关联（attached to an activity），否则将会返回一个null。
        firstButton = (Button) getActivity().findViewById(R.id.first_button);
        secondButton = (Button) getActivity().findViewById(R.id.second_button);
        thirdButton = (Button) getActivity().findViewById(R.id.third_button);

        MyButtonClickListener clickListener = new MyButtonClickListener();
        firstButton.setOnClickListener(clickListener);
        secondButton.setOnClickListener(clickListener);
        thirdButton.setOnClickListener(clickListener);
    }

    /** 按钮的监听器 */
    class MyButtonClickListener implements OnClickListener
    {
        public void onClick(View v)
        {
            Button button = (Button) v;
            if (button == firstButton)
                myListener.showMessage(1);
            if (button == secondButton)
                myListener.showMessage(2);
            if (button == thirdButton)
                myListener.showMessage(3);
        }
    }
}  
