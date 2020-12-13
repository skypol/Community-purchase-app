package com.example.cw;
//购物车界面
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.util.DBHelper;
import com.example.util.HttpUtils;
import com.example.util.SharedPreferencesUtils;
import com.example.util.UUID;
import com.example.util.Url;
import com.example.util.news;

/**
 * 
 * @author yummy email:yummyl.lau@gmail.com
 */
public class TabFragmentTwo extends Fragment {
	ListView listview;
	List<news> l;
	TextView zong;
	TextView tj;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View parentView = inflater.inflate(R.layout.tabfragmenttwo, container,
				false);
		zong=(TextView)parentView.findViewById(R.id.zong);
		
		tj = (TextView) parentView.findViewById(R.id.tj);
		tj.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String ss=UUID.getUuid();
				for (int i = 0; i < l.size(); i++) {
					new tijiao().execute(
							SharedPreferencesUtils.getParam(getActivity(),
									"id", "").toString(), l.get(i).getTime(),
							ss);
				}



				DBHelper d = new DBHelper(getActivity());
				d.delAllData("s");
				d.close();
				Intent s=new Intent(getActivity(), pingjia.class);
				s.putExtra("did", ss);
				startActivity(s);

			}
		});
		listview = (ListView) parentView.findViewById(R.id.listView);
		DBHelper d = new DBHelper(getActivity());
		l = d.findAll();
		d.close();
		if (l != null) {
			System.out.println(l.size());
			double ds=0;
			for(int i=0;i<l.size();i++){
				ds=ds+Double.parseDouble(l.get(i).getPrice());
			}
			zong.setText("总价："+ds+"");
			listview.setAdapter(new gwc_adapter());
		}else{
			l=new ArrayList<news>();
			listview.setAdapter(new gwc_adapter());
		}
		return parentView;
	}

	// 提交
	private class tijiao extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... params) {
			// Simulates a background job.
			String result = null;
			result = HttpUtils.doGet(Url.url() + "news/adddingdan/" + params[0]
					+ "-" + params[1] + "-" + params[2]);
			return result;
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
		}
	}

	public class gwc_adapter extends BaseAdapter {

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
		public View getView(final int arg0, View v, ViewGroup arg2) {
			// TODO Auto-generated method stub
			v = LayoutInflater.from(getActivity()).inflate(R.layout.gwc_item,
					null);
			TextView name = (TextView) v.findViewById(R.id.name);
			TextView price = (TextView) v.findViewById(R.id.price);
			TextView del = (TextView) v.findViewById(R.id.del);
			TextView lxr = (TextView) v.findViewById(R.id.lxr);
			TextView tel = (TextView) v.findViewById(R.id.tel);
			lxr.setText(l.get(arg0).getName());
			tel.setText(l.get(arg0).getTel());
			del.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg) {
					// TODO Auto-generated method stub
					DBHelper dd = new DBHelper(getActivity());
					dd.del(l.get(arg0).getId());
					l = dd.findAll();
					if(l!=null){
						double ds=0;
						for(int i=0;i<l.size();i++){
							ds=ds+Double.parseDouble(l.get(i).getPrice());
						}
						zong.setText("总价："+ds+"");
					listview.setAdapter(new gwc_adapter());
					}else{
						zong.setText("总价：0");
						l=new ArrayList<news>();
						listview.setAdapter(new gwc_adapter());
					}
				}
			});
			name.setText(l.get(arg0).getTitle());
			price.setText(l.get(arg0).getPrice());
			return v;
		}

	}
}
