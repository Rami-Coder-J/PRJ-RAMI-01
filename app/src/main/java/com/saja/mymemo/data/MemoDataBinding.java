package com.saja.mymemo.data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MemoDataBinding extends ViewModel {
    public MutableLiveData<String> inputText = new MutableLiveData<>();
}
