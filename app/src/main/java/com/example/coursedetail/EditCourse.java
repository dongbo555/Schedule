package com.example.coursedetail;


import com.example.data.CourseInfo;
import com.example.db.CourseInfoDB;
import com.example.dialog.CourseTimeWheel;
import com.example.dialog.WeekWheel;
import com.example.schedule.R;
import com.example.main.Main_tab;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EditCourse extends Activity {
	ImageView back;
	AutoCompleteTextView courseName;
	AutoCompleteTextView coursePlace;
	AutoCompleteTextView teacherName;
	TextView courseTime;
	TextView weekNum;
	TextView title;
	RelativeLayout titleRight;
	TextView done;
	
	CourseInfo courseInfo = new CourseInfo();

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        EditCourse.this.finish();
    }

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_course);
		back = (ImageView) findViewById(R.id.title_imgv_left_icon);
		courseName = (AutoCompleteTextView) findViewById(R.id.edt_course_edt_courseName);
		coursePlace = (AutoCompleteTextView) findViewById(R.id.edit_course_edt_classroom);
		teacherName = (AutoCompleteTextView) findViewById(R.id.edit_course_edt_teacher);
		courseTime = (TextView) findViewById(R.id.edit_course_txv_section);
		weekNum = (TextView) findViewById(R.id.edit_course_txv_week);
		title = (TextView) findViewById(R.id.title_txv_title);
		titleRight = (RelativeLayout) findViewById(R.id.title_rlyt_right);
		titleRight.setVisibility(View.VISIBLE);
		title.setText("�༭�γ�");
		done = (TextView) findViewById(R.id.title_txv_right_text);
		done.setText("���");

		// ����һ��activity��������

		Intent intent = this.getIntent();
		final CourseInfo courseinfo = (CourseInfo) intent
				.getSerializableExtra("courseInfo");
		if (courseinfo != null) {
			courseName.setText(courseinfo.getCourseName());
			coursePlace.setText(courseinfo.getCoursePlace());
			teacherName.setText(courseinfo.getTeacherName());
			courseTime.setText(courseinfo.getWeekString()
					+ courseinfo.getCourseTime());
			weekNum.setText(courseinfo.getWeekNumString());
            /*String s=null;
            for(int i=0;i<courseinfo.getWeekNumArray().size();i++){
                s+=courseinfo.getWeekNumArray().get(i).toString();
            }
            weekNum.setText(s);*/
		}

		// final SharedPreferences course_Time =
		// getSharedPreferences("course_Time", Activity.MODE_PRIVATE);
		courseTime.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				int currentIndex = 0;
				String[][] terms = null;
				terms = new String[3][];
				terms[0] = new String[] { "��һ", "�ܶ�", "����", "����", "����", "����",
						"����" };
				terms[1] = new String[] { "��1��", "��2��", "��3��", "��4��", "��5��",
						"��6��", "��7��", "��8��", "��9��", "��10��", "��11��" };
				terms[2] = new String[] { "��1��", "��2��", "��3��", "��4��", "��5��",
						"��6��", "��7��", "��8��", "��9��", "��10��", "��11��" };

				final CourseTimeWheel wheel = new CourseTimeWheel(
						EditCourse.this, R.style.MyDialog, terms, currentIndex);

				wheel.show();
				wheel.setTitle("��ѡ���Ͽνڴ�");
				wheel.setPositiveButton("ȷ��", new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						if (wheel.getItemID(1) > wheel.getItemID(2)) {
							Toast toast = Toast.makeText(EditCourse.this,
									"ѡ����Ϣ������������", Toast.LENGTH_SHORT);
							toast.show();
						} else {
							courseInfo.setWeek(wheel.getItemID(0) + 1);
							courseInfo.setCourseTime(wheel.getItemID(1) + 1
									+ "-" + (wheel.getItemID(2) + 1) + "��");
							wheel.dismiss();
							courseTime.setText(courseInfo.getWeekString()
									+ courseInfo.getCourseTime());
						}
					}
				});

			}
		});

		// ����������
		weekNum.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// ��wheel����ʾ��λ��
				int currentIndex = 0;

				// num��ʾһѧ���������
				int num = 25;
				String[][] terms = new String[2][];
				terms[0] = new String[num];
				terms[1] = new String[num];
				for (int i = 1; i <= num; i++) {
					terms[0][i - 1] = "��" + i + "��";
					terms[1][i - 1] = "��" + i + "��";
				}
				final WeekWheel wheel = new WeekWheel(EditCourse.this,
						R.style.MyDialog, terms, currentIndex);
				wheel.show();
				wheel.setTitle("��ѡ���Ͽ�����");
				wheel.setPositiveButton("ȷ��", new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						if (wheel.getItemID(0) > wheel.getItemID(1)) {
							Toast toast = Toast.makeText(EditCourse.this,
									"ѡ����Ϣ������������", Toast.LENGTH_SHORT);
							toast.show();
						} else {
							//courseInfo.setWeekNum(wheel.getItemID(0) + 1 + "-"
									//+ (wheel.getItemID(1) + 1) + "��");
                            String s="";
                            for(int i=wheel.getItemID(0)+1;i<=wheel.getItemID(1)+1;i++){
                                s+=i+"��";
                            }
                            courseInfo.setWeekNumString(s);
							wheel.dismiss();
							weekNum.setText(s);
						}
					}
				});
			}
		});

		// Ϊ��ɰ�ť���ü�����
		done.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if (courseinfo == null) {

					if (courseName.getText().length()==0) {
						Toast toast = Toast.makeText(EditCourse.this,
								"�γ����Ʋ���Ϊ��", Toast.LENGTH_SHORT);
						toast.show();
					} else if (coursePlace.getText().length()==0) {
						Toast toast = Toast.makeText(EditCourse.this,
								"���Ҳ���Ϊ��", Toast.LENGTH_SHORT);
						toast.show();
					} else if (courseInfo.getCourseTime().length()==0) {
						Toast toast = Toast.makeText(EditCourse.this,
								"�Ͽν�������Ϊ��", Toast.LENGTH_SHORT);
						toast.show();
					}else {
						//��������
						
						courseInfo.setCourseName(courseName.getText().toString());
						courseInfo.setTeacherName(teacherName.getText().toString());
						courseInfo.setCoursePlace(coursePlace.getText().toString());


                        CourseInfoDB courseDB=new CourseInfoDB(EditCourse.this);
						courseInfo.setCourseId(courseDB.queryMaxID()+1);
						if(courseDB.insertCourse(courseInfo)){
							Toast toast=Toast.makeText(EditCourse.this, "��ӳɹ�",Toast.LENGTH_SHORT);
							toast.show();
						}
						courseDB.close();
                        EditCourse.this.finish();
					}

				} else {
					//����������õ���ɾ���ٲ��룬�Ժ��پ���
					CourseInfoDB courseDB=new CourseInfoDB(EditCourse.this);	
					courseInfo.setCourseName(courseName.getText().toString());
					courseInfo.setTeacherName(teacherName.getText().toString());
					courseInfo.setCoursePlace(coursePlace.getText().toString());


                    //������
                    courseInfo.setWeekNumString(weekNum.getText().toString());


					//�жϿγɵ��Ͽ�ʱ���Ƿ��иĶ�
					String temp=courseinfo.getWeekString()+courseinfo.getCourseTime();
					if(courseTime.getText().toString().equals(temp)){
						courseInfo.setWeek(courseinfo.getWeek());
						courseInfo.setCourseTime(courseinfo.getCourseTime());
					}
					courseInfo.setCourseId(courseinfo.getCourseId());
					if(courseDB.delete(courseinfo.getCourseId())&&courseDB.insertCourse(courseInfo)){
						Toast toast = Toast.makeText(EditCourse.this, "�����޸ĳɹ�",
								Toast.LENGTH_SHORT);
						toast.show();

                        EditCourse.this.finish();

					}
					
					
					
					
				}

			}
		});

		// �������ذ�ť
		back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
                /*Intent intent = new Intent();
                intent.setClass(EditCourse.this, Main_tab.class);*/
                EditCourse.this.finish();
                //startActivity(intent);


			}
		});
	}

}
