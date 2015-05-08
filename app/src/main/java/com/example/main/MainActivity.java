/*
package com.example.main;


import com.example.schedule.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	protected Button settingButton;
	protected Button couresTableButton;
	protected Button searchCourse;
	protected Button realQuery;
	protected Button classRoom;
	RelativeLayout titleLeft;
	TextView title;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);  //�����Զ������
		setContentView(R.layout.main_layout);
		//getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.title);//�����Զ������
		
		settingButton=(Button)findViewById(R.id.button_setting);
		couresTableButton=(Button)findViewById(R.id.button_course_table);
		searchCourse=(Button)findViewById(R.id.button_search);
		realQuery=(Button)findViewById(R.id.button_real_time_query);
		titleLeft=(RelativeLayout)findViewById(R.id.title_rlyt_left);
		classRoom=(Button)findViewById(R.id.button_empty_query);
		titleLeft.setVisibility(View.GONE);
		title=(TextView)findViewById(R.id.title_txv_title);
		title.setText("�γ̲�ѯϵͳ");
		init();
		
		
		
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void init(){
		
		//��ȥ�����ý���
		
		settingButton.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, SettingActivity.class);
				startActivity(intent);
				
			}
		});
		//��ȥ���γ̱����
		couresTableButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, Schedule_main.class);
				startActivity(intent);
				
			}
		});
		searchCourse.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, SearchCourse.class);
				startActivity(intent);
				
			}
		});
		
		

		
		
		//����ս��Ҳ�ѯ����
		classRoom.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				*/
/*Intent intent = new Intent();
				intent.setClass(MainActivity.this,Classroom.class);
				startActivity(intent);*//*

				Toast toast=Toast.makeText(MainActivity.this, "�˹������ڿ������С�������",Toast.LENGTH_SHORT);
				toast.show();
			}
		});
		
	}
}
*/
