package com.example.cw;
//交易成功界面
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class success extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.success);
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
					finish();
			}
		}, 2000);
	}

}
