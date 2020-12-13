package com.example.cw;
//商品详情界面
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;

import androidx.fragment.app.Fragment;
import com.alibaba.fastjson.JSON;
import com.example.cw.R;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.example.util.SharedPreferencesUtils;
import com.example.util.HttpUtils;
import com.example.util.Url;
import com.example.util.news;
import com.example.util.des;
import com.nostra13.universalimageloader.core.ImageLoader;

public class news_des extends Activity {
	TextView title, mes, jg, lxr, lxdh,ps;
	ImageView img;
	news n;

	List<User> list;
	ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_des);
		listView=findViewById(R.id.listView);
		mes = (TextView) findViewById(R.id.mes);
		title = (TextView) findViewById(R.id.title);
		img = (ImageView) findViewById(R.id.img);
		jg = (TextView) findViewById(R.id.jg);
		lxr = (TextView) findViewById(R.id.lxr);
		lxdh = (TextView) findViewById(R.id.lxdh);
		ps = (TextView) findViewById(R.id.ps);
		n = (news) getIntent().getExtras().getSerializable("news");
		jg.setText(n.getPrice() + "元");
		lxr.setText(n.getName());
		lxdh.setText(n.getTel());
		ps.setText(n.getPs());
		mes.setText(n.getMsg());
		title.setText(n.getTitle());
		gettouxiang g = new gettouxiang(img);
		g.execute(Url.url() + "upload/" + n.getImg());
		findByname f=new findByname();
		f.execute(n.getId());
	}

	private class findByname extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... params) {
			// Simulates a background job.
			String result = null;
			try {
				result = HttpUtils.doGet(Url.url() + "news/getuser/"
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
				list = JSON.parseArray(result, User.class);
				listView.setAdapter(new user_adapter(list, news_des.this));

			}else{
				list=new ArrayList<User>();
				listView.setAdapter(new user_adapter(list, news_des.this));
			}
			super.onPostExecute(result);
		}
	}



	// 获取网络图片
	public class gettouxiang extends AsyncTask<String, Void, Bitmap> {

		private ImageView img;

		public gettouxiang(ImageView i) {
			this.img = i;
		}

		@Override
		protected Bitmap doInBackground(String... arg0) {
			// TODO Auto-generated method stub

			return ImageLoader.getInstance().loadImageSync(arg0[0]);
		}

		@Override
		protected void onPostExecute(Bitmap result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);

			if (result != null) {
				if (img.getId() == R.id.img) {
					img.setImageBitmap(result);
				} else {
					img.setImageBitmap(result);
				}
			}

		}
	}
}
