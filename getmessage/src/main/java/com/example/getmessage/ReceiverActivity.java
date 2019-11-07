package com.example.getmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.TextView;

import com.example.common.Person2;

public class ReceiverActivity extends AppCompatActivity {
    private String TAG = "ReceiverActivity";
    TextView info;
    Person2 p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info = (TextView) findViewById(R.id.info);
        Log.i("getPackageName", "getPackageName : " + getApplicationContext().getPackageName()); //com.example.getmessage
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            info.setText("接收到的資料是：" + bundle.getString("channel"));
        } else {
            return;
        }
/*
放棄~ 做不出來QQ，只能單純傳String，int... 不能傳物件，用試不出來
* */
//        Intent intent = getIntent();
//        if (intent != null) {
//            if(getIntent() == null) {
//                return;
//            }
//            p = (Person2) bundle.getSerializable("Person"); //記得要轉型
//            if (p != null){
//                Log.i("getPackageName", "Person : " + p.getName());
//                info.setText("接收到的資料是：" + "\n" +
//                        "姓名 : " + p.getName() + "\n" +
//                        "性別 : " + p.getSex() + "\n" +
//                        " ID : " + p.getID());
//            }
//        }

    }

}
