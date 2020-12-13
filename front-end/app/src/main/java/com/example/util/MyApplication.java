package com.example.util;
import java.io.File;

import android.app.Application;
import android.app.Service;
import android.os.Vibrator;

import com.baidu.mapapi.SDKInitializer;
import com.example.cw.R;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.utils.StorageUtils;

public class MyApplication extends Application {
	public LocationService locationService;
	public Vibrator mVibrator;
	@Override
	public void onCreate() {
		// 初始化ImageLoader
		@SuppressWarnings("deprecation")
		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.showStubImage(R.drawable.a15) // 设置图片下载期间显示的图片
				.showImageForEmptyUri(R.drawable.a15) // 设置图片Uri为空或是错误的时候显示的图片
				.showImageOnFail(R.drawable.ic_error) // 设置图片加载或解码过程中发生错误显示的图片
				.cacheInMemory(true) // 设置下载的图片是否缓存在内存中
				.cacheOnDisc(true) // 设置下载的图片是否缓存在SD卡中
				// .displayer(new RoundedBitmapDisplayer(20)) // 设置成圆角图片
				.build(); // 创建配置过得DisplayImageOption对象
		File cacheDir = StorageUtils.getOwnCacheDirectory(this,
				"imageloader/Cache");
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				getApplicationContext()).defaultDisplayImageOptions(options)
				.threadPriority(Thread.NORM_PRIORITY - 2)
				.denyCacheImageMultipleSizesInMemory()
				.discCache(new UnlimitedDiscCache(cacheDir))
				// 自定义缓存路径
				.discCacheFileNameGenerator(new Md5FileNameGenerator())
				.tasksProcessingOrder(QueueProcessingType.LIFO).build();
		ImageLoader.getInstance().init(config);
		locationService = new LocationService(getApplicationContext());
		mVibrator = (Vibrator) getApplicationContext().getSystemService(
				Service.VIBRATOR_SERVICE);
		SDKInitializer.initialize(getApplicationContext());
	}
}
