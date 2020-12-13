package com.example.cw;
//订单界面
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.alibaba.fastjson.JSON;
import com.example.cw.R.id;
import com.example.util.HttpUtils;
import com.example.util.SharedPreferencesUtils;
import com.example.util.Url;
import com.example.util.des;

import java.util.List;

/**
 * 
 */
public class TabFragmantThree extends Fragment {

	List<des> l;
	ListView listView;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View parentView = inflater.inflate(R.layout.tabfragmentthree,
				container, false);
		listView=(ListView)parentView.findViewById(id.listView);
		new getAll().execute(SharedPreferencesUtils.getParam(getActivity(),"id","").toString());
		return parentView;
	}
	// 提交
		private class getAll extends AsyncTask<String, Void, String> {
			@Override
			protected String doInBackground(String... params) {
				// Simulates a background job.
				String result = null;
				result = HttpUtils.doGet(Url.url() + "news/findAllDingdans/" + params[0]);
				return result;
			}

			@Override
			protected void onPostExecute(String result) {
				super.onPostExecute(result);
				if(!result.equals("1")){
				   l=JSON.parseArray(result, des.class);
				   listView.setAdapter(new dd_adapter());
				}
			}
		}
		public class dd_adapter extends BaseAdapter{

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return l.size();
			}

			@Override
			public Object getItem(int arg0) {
				// TODO Auto-generated method stub
				return l.get(arg0);
			}

			@Override
			public long getItemId(int arg0) {
				// TODO Auto-generated method stub
				return arg0;
			}

			@Override
			public View getView(int arg0, View v, ViewGroup arg2) {
				// TODO Auto-generated method stub
				v=LayoutInflater.from(getActivity()).inflate(R.layout.dd_item, null);
				TextView text=(TextView)v.findViewById(id.name);
				TextView price=(TextView)v.findViewById(id.price);
				TextView addtime=(TextView)v.findViewById(id.addtime);
				TextView type=(TextView)v.findViewById(id.type);
				text.setText("商品："+l.get(arg0).getName());
				price.setText("价格："+l.get(arg0).getPrice()+"元");
				addtime.setText("下单时间："+l.get(arg0).getAddtime());
				type.setText("当前状态："+l.get(arg0).getType()+l.get(arg0).getState());
				
				return v;
			}
			
		}
}
