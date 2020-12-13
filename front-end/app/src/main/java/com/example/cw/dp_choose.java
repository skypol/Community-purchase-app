package com.example.cw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.util.SharedPreferencesUtils;

public class dp_choose extends Activity {
    Button d1,d2,d3,d4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dp_choose);
        d1=findViewById(R.id.d1);
        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferencesUtils.setParam(dp_choose.this,"dp","金陵湾");
                startActivity(new Intent(dp_choose.this,FragmentTab.class));
            }
        });
        d2=findViewById(R.id.d2);
        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferencesUtils.setParam(dp_choose.this,"dp","新和园");
                startActivity(new Intent(dp_choose.this,FragmentTab.class));
            }
        });
        d3=findViewById(R.id.d3);
        d3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferencesUtils.setParam(dp_choose.this,"dp","芳草园");
                startActivity(new Intent(dp_choose.this,FragmentTab.class));
            }
        });
        d4=findViewById(R.id.d4);
        d4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferencesUtils.setParam(dp_choose.this,"dp","汇贤居");
                startActivity(new Intent(dp_choose.this,FragmentTab.class));
            }
        });
    }
}
