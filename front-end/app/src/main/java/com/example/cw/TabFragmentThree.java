package com.example.cw;
//用户信息界面


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.util.HttpUtils;
import com.example.util.SharedPreferencesUtils;
import com.example.util.Url;

import java.net.URLEncoder;

public class TabFragmentThree extends Fragment {
	private TextView btn1;
	private TextView btn2;
	private EditText username;
	private EditText pass;
	private EditText queding;
	private Button login;
	private EditText nickname;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.tabfragmentfour, container, false);
		pass=(EditText)v.findViewById(R.id.pass);
		username=(EditText)v.findViewById(R.id.username);
		nickname=(EditText)v.findViewById(R.id.nickname);
		username.setText(SharedPreferencesUtils.getParam(getActivity(), "username", "").toString());
		nickname.setText(SharedPreferencesUtils.getParam(getActivity(), "nickname", "").toString());
		queding=(EditText)v.findViewById(R.id.queding);
		login=(Button)v.findViewById(R.id.tijiao);
		btn1=(TextView) v.findViewById(R.id.btn1);
		btn2=(TextView) v.findViewById(R.id.btn2);
		btn1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {


				Intent s=new Intent(getActivity(), FirstActivity.class);
				startActivity(s);

			}
		});

		btn2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {


				Intent s=new Intent(getActivity(), SecondActivity.class);
				startActivity(s);

			}
		});
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(username.getText().equals("")||nickname.getText().equals("")||pass.getText().equals("")||queding.getText().equals("")){
					Toast.makeText(getActivity(), "信息不能为空", Toast.LENGTH_SHORT).show();
				}else{
					if(pass.getText().toString().equals(queding.getText().toString())){
						useradd u=new useradd();
						u.execute(SharedPreferencesUtils.getParam(getActivity(), "id", "").toString(),username.getText().toString(),pass.getText().toString(),nickname.getText().toString());
					}else{
						Toast.makeText(getActivity(), "两次密码输入不一致", Toast.LENGTH_SHORT).show();
					}
				}
			}
		});
		return v;
	}



	/**
	 * 注册
	 * 
	 * @author Administrator
	 * 
	 */
	public class useradd extends AsyncTask<String, Void, String> {

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			String result = null;
			result= HttpUtils.doGet(Url.url()+"user/updateU/"+arg0[0]+"-"+arg0[1]+"-"+arg0[2]+"-"+URLEncoder.encode(arg0[3]));
			return result;
		}
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
					if(result.equals("success")){
						Toast.makeText(getActivity(), "成功", Toast.LENGTH_SHORT).show();
					}else{
						Toast.makeText(getActivity(), "失败", Toast.LENGTH_SHORT).show();
		}}

	}
}
