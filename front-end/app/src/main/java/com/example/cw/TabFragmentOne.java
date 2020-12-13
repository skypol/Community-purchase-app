package com.example.cw;
//商品分类及搜索功能
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.alibaba.fastjson.JSON;
import com.example.util.HttpUtils;
import com.example.util.LvHeightUtil;
import com.example.util.SharedPreferencesUtils;
import com.example.util.Url;
import com.example.util.news;
import com.google.gson.Gson;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author yummy email:yummyl.lau@gmail.com
 */
public class TabFragmentOne extends Fragment {
	List<news> l;
	ListView listview;
	EditText name;
	TextView t1, t2, t3, t4, ss,city,yuyin;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View parentView = inflater.inflate(R.layout.tabfragmentone, container,
				false);
		SpeechUtility.createUtility(getActivity(), SpeechConstant.APPID + "=5a1c2861");
		
		name = (EditText) parentView.findViewById(R.id.name);
		t1 = (TextView) parentView.findViewById(R.id.t1);
		t2 = (TextView) parentView.findViewById(R.id.t2);
		t3 = (TextView) parentView.findViewById(R.id.t3);
		t4 = (TextView) parentView.findViewById(R.id.t4);
		t1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new findBytype().execute("金陵湾");
			}
		});
		t2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new findBytype().execute("新和园");
			}
		});
		t3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new findBytype().execute("芳草园");
			}
		});
		t4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new findBytype().execute("汇贤居");
			}
		});
		ss = (TextView) parentView.findViewById(R.id.ss);
		ss.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (!name.getText().toString().equals("")) {
					new findByname().execute(name.getText().toString(),SharedPreferencesUtils.getParam(getActivity(),"dp","金陵湾").toString());
				}

			}
		});
		listview = (ListView) parentView.findViewById(R.id.listView);
		new findBytype().execute(SharedPreferencesUtils.getParam(getActivity(),"dp","金陵湾").toString());
		return parentView;
	}

	private class findByname extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... params) {
			// Simulates a background job.
			String result = null;
			try {
				result = HttpUtils.doGet(Url.url() + "news/findByName/"
						+ URLEncoder.encode(params[0], "utf-8")+"-"+ URLEncoder.encode(params[1], "utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}

		@Override
		protected void onPostExecute(String result) {
			if (!result.equals("1")) {
				l = JSON.parseArray(result, news.class);
				listview.setAdapter(new news_adapter(l, getActivity()));
				listview.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub
						Intent i = new Intent(getActivity(), news_des.class);
						Bundle b = new Bundle();
						b.putSerializable("news", l.get(arg2));
						i.putExtras(b);
						startActivity(i);
					}
				});
			}else{
				l=new ArrayList<news>();
				listview.setAdapter(new news_adapter(l, getActivity()));
			}
			super.onPostExecute(result);
		}
	}

	private class findBytype extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... params) {
			// Simulates a background job.
			String result = null;
			try {
				result = HttpUtils.doGet(Url.url() + "news/findByType/"
						+ URLEncoder.encode(params[0], "utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}

		@Override
		protected void onPostExecute(String result) {
			if (!result.equals("1")) {
				l = JSON.parseArray(result, news.class);
				listview.setAdapter(new news_adapter(l, getActivity()));
				listview.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub
						Intent i = new Intent(getActivity(), news_des.class);
						Bundle b = new Bundle();
						b.putSerializable("news", l.get(arg2));
						i.putExtras(b);
						startActivity(i);
					}
				});
			}else{
				l=new ArrayList<news>();
				listview.setAdapter(new news_adapter(l, getActivity()));
			}
			super.onPostExecute(result);
		}
	}

	private class GetDataTask extends AsyncTask<Void, Void, String> {
		@Override
		protected String doInBackground(Void... params) {
			// Simulates a background job.
			String result = null;
			result = HttpUtils.doGet(Url.url() + "news/findAlls/");
			return result;
		}

		@Override
		protected void onPostExecute(String result) {
			// Do some stuff here

			// Call onRefreshComplete when the list has been refreshed.
			l = JSON.parseArray(result, news.class);
			listview.setAdapter(new news_adapter(l, getActivity()));
			listview.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					Intent i = new Intent(getActivity(), news_des.class);
					Bundle b = new Bundle();
					b.putSerializable("news", l.get(arg2));
					i.putExtras(b);
					startActivity(i);
				}
			});
			LvHeightUtil.setListViewHeightBasedOnChildren(listview);
			super.onPostExecute(result);
		}
	}
	public String parseVoice(String resultString) {
		Gson gson = new Gson();
		Voice voiceBean = gson.fromJson(resultString, Voice.class);

		StringBuffer sb = new StringBuffer();
		ArrayList<Voice.WSBean> ws = voiceBean.ws;
		for (Voice.WSBean wsBean : ws) {
			String word = wsBean.cw.get(0).w;
			sb.append(word);
		}
		return sb.toString();
	}
	/**
	    */
		public class Voice {

			public ArrayList<WSBean> ws;

			public class WSBean {
				public ArrayList<CWBean> cw;
			}

			public class CWBean {
				public String w;
			}
		}
}
