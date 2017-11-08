package com.ltz.baohuodemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ltz.baohuodemo.viewpagerdialog.ViewPagerAlertDialog;
import com.ltz.baohuodemo.viewpagerdialog.ViewPagerDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * 主页面
 */
public class MainActivity extends AppCompatActivity {

    private Button btn_start,btn_html,btn_dialog,btn_dialog1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             startActivity(new Intent(MainActivity.this,Location_Activity.class));
            }
        });

        btn_html = (Button) findViewById(R.id.btn_html);
        btn_html.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,WebViewActivity.class));
            }
        });

        btn_dialog = (Button)findViewById(R.id.btn_dialog);
        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        btn_dialog1 = (Button) findViewById(R.id.btn_dialog1);
        btn_dialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog1();
            }
        });
    }

    private void showDialog1(){
        ViewPagerAlertDialog dialog = new ViewPagerAlertDialog(this);
    }

    private void showDialog(){
        ViewPagerDialog dialog = new ViewPagerDialog(this,R.style.dialogstyle);
        dialog.show();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();

    }
}
