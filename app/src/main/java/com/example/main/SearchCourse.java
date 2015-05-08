/*
package com.example.main;

import java.util.ArrayList;
import java.util.List;

import com.example.adatper.ListViewAdapter;
import com.example.data.CourseInfo;
import com.example.schedule.R;
import com.example.util.CheckedWifi;
//import com.example.util.GetCourseInfo;
import com.example.util.GetStream;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SearchCourse extends Activity {

	ListView listView;
	EditText editText;
	ImageView imageView;
	RelativeLayout titleRight;
	TextView SearchCourse;
	List<CourseInfo> courseInfos = new ArrayList<CourseInfo>();
	TextView title;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_course);
		listView = (ListView) findViewById(R.id.course_Info);
		editText = (EditText) findViewById(R.id.select_course_edtx_course_name);
		imageView = (ImageView) findViewById(R.id.title_imgv_left_icon);
		title=(TextView)findViewById(R.id.title_txv_title);
		title.setText("�γ̲�ѯ");
		
		Intent intent=getIntent();
		String temp=intent.getStringExtra("key");
		if(temp==null){
			titleRight = (RelativeLayout) findViewById(R.id.title_rlyt_right);
			titleRight.setVisibility(0);
			SearchCourse = (TextView) findViewById(R.id.title_txv_right_text);
			SearchCourse.setText("��ѯ");

			SearchCourse.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					if (editText.getText().length() == 0) {
						Toast toast = Toast.makeText(SearchCourse.this, "�����������ؼ���",
								Toast.LENGTH_SHORT);
						toast.show();
						return;
					}
					getInfo(editText.getText().toString(),null);

				}
			});
		}else{
			getInfo(temp,temp);
			
			char a=temp.charAt(0);
			String b=temp.subSequence(1,temp.length()).toString();
			switch(a){
			case'1':
				temp="��һ";
				break;
			case'2':
				temp="�ܶ�";
				break;
			case'3':
				temp="����";
				break;
			case'4':
				temp="����";
				break;
			case'5':
				temp="����";
				break;
			case'6':
				temp="����";
				break;
			case'7':
				temp="����";
				break;
			}
			temp=temp+"��"+b+"��";
			editText.setText(temp);
			editText.setFocusable(false);
			editText.setClickable(false);
			editText.setInputType(InputType.TYPE_NULL);
		}
		
		
		
		// �������ذ�ť
		imageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Intent intent = new Intent();
				//intent.setClass(SearchCourse.this, MainActivity.class);
				//startActivity(intent);
				SearchCourse.this.finish();

			}
		});

	}
	//�жϵ�ǰ�Ƿ���WiFi����


	// temp���������Ĺؼ���
	public void getInfo(String temp,String temp1) {

		// ��������ַ
		try {

			if (CheckedWifi.CheckNetworkState(SearchCourse.this)) {
				courseInfos = GetCourseInfo.getCourseInfo(new GetStream()
						.getStream(temp,temp1));
				ListViewAdapter adapter = new ListViewAdapter(
						SearchCourse.this, courseInfos, R.layout.item_course,
						new int[] { R.id.select_course_txv_course_name,
								R.id.select_course_txv_teacherName,
								R.id.select_course_txv_classroom,
								R.id.select_course_txv_section,
								R.id.select_course_txv_week,
								R.id.select_course_btn_control });
				listView.setAdapter(adapter);
			} else {
				Toast toast = Toast.makeText(SearchCourse.this, "��ǰ��WIFI����",
						Toast.LENGTH_SHORT);
				toast.show();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
*/
