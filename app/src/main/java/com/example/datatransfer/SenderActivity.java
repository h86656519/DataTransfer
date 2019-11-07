package com.example.datatransfer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.common.Person2;

import java.util.ArrayList;

/* 在app之間做資料傳遞練習
 * */
public class SenderActivity extends AppCompatActivity {
    Button button,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        Log.i("getPackageName", "getPackageName : " + getApplicationContext().getPackageName()); // com.example.datatransfer

        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.example.getmessage"); //目標package，可以到看gradle中 applicationId 的值
                launchIntent.putExtra("channel", "傳遞的資料");
                startActivity(launchIntent);
            }
        });

        button2.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                final Person p = new Person();
                final Person2 p2 = new Person2("王小名",1,"男");
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.example.getmessage"); //目標package，可以到看gradle中 applicationId 的值
//                launchIntent.putExtra("Person", p);
                launchIntent.putExtra("Person", p2);
                startActivity(launchIntent);
            }
        });
    }
}
