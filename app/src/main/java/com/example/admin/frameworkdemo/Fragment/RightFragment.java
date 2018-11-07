package com.example.admin.frameworkdemo.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.frameworkdemo.R;

public class RightFragment extends Fragment   
{   
    @Override   
    public void onCreate(Bundle savedInstanceState)   
    {   
        System.out.println("RightFragment--->onCreate");   
        super.onCreate(savedInstanceState);   
    }   
     
    @Override   
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)   
    {   
        System.out.println("RightFragment--->onCreateView");   
        return inflater.inflate(R.layout.rightfragment, container, false);
    }   
}  
