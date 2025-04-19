package com.saja.mymemo.data;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.io.FileOutputStream;
import java.io.IOException;

public class MemoViewNodel extends AndroidViewModel {

    public MutableLiveData<String> inputText = new MutableLiveData<>();

    public MemoViewNodel(@NonNull Application application) {
        super(application);
    }

    public void onClickButton() {
        String editText = inputText.getValue();
        saveToFile(editText);
    }

    private void saveToFile(String content) {
        String filename = "my_memo.txt";

        try {
            FileOutputStream fos = getApplication().openFileOutput(filename, Context.MODE_PRIVATE);
            fos.write(content.getBytes());
            fos.close();
            Toast.makeText(getApplication(), "저장 완료! (파일명: " + filename + ")", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplication(), "저장 실패: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
