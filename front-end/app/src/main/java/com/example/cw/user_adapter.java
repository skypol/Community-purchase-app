package com.example.cw;
//数据适配器,首页商品信息

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.util.DBHelper;
import com.example.util.Url;
import com.example.util.news;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class user_adapter extends BaseAdapter {

	private List<User> l;
	private Context con;

	public user_adapter(List<User> ll, Context c) {
		this.con = c;
		this.l = ll;
	}

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
		v = LayoutInflater.from(con).inflate(R.layout.user_item, null);
		TextView title = (TextView) v.findViewById(R.id.nickname);
		title.setText(l.get(arg0).getNickname()+"团购一件");

		return v;
	}


}
