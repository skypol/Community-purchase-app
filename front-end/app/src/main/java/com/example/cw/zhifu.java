package com.example.cw;
//交易成功界面
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.util.DBHelper;

public class zhifu extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.zhifu1);
        Button confirm = findViewById(R.id.dialog_confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(zhifu.this, paypassword.class);
                startActivity(intent);
                finish();

            }
        });



        Button confirm1 = findViewById(R.id.dialog_cancel);
        confirm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                finish();


            }
        });


        }

}
