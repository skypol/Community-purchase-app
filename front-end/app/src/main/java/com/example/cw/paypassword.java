package com.example.cw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.example.cw.TabFragmentTwo;

public class paypassword extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.zhifu2);
        MNPasswordEditText payPasswordEditText = findViewById(R.id.mPswEditText);
        TextView closeTv = findViewById(R.id.dialog_close);
        TextView priceTv = findViewById(R.id.dialog_price);

        closeTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        payPasswordEditText.setOnTextChangeListener(new MNPasswordEditText.OnTextChangeListener() {
            @Override
            public void onTextChange(String text, boolean isComplete) {
                if (isComplete) {
                    Intent intent=new Intent(paypassword.this,success.class);
                    startActivity(intent);
                    finish();

                }
            }
        });

    }
}
