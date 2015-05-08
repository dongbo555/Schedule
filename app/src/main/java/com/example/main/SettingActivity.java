package com.example.main;

import java.util.Calendar;


import com.example.db.CourseInfoDB;
import com.example.dialog.ConfirmDialog;
import com.example.dialog.OneWheel;
import com.example.schedule.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends Activity {

	ImageView imageView;
	TextView title;
	RelativeLayout settingWeek;
	RelativeLayout settingmaxcount,settingmycount,logoutacount;
	RelativeLayout currentTerm;
	TextView curTerm;
	TextView maxNum;
	TextView curWeek;
    TextView account_status;
    TextView user_organization;


    //˫�����ؼ��˳�
    private long exitTime=0;
    @Override
    public void onBackPressed() {
        if((System.currentTimeMillis()-exitTime)>2000){
            Toast.makeText(this, "�ٰ�һ���˳�����", Toast.LENGTH_SHORT).show();
            exitTime=System.currentTimeMillis();
        }else{
            super.onBackPressed();
            SettingActivity.this.finish();
            System.exit(0);
        }

    }


    @Override
    protected void onResume() {
        super.onResume();

        refresh();
    }

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_settings);
		title = (TextView) findViewById(R.id.title_txv_title);
		title.setText("�γ�����");
		imageView = (ImageView) findViewById(R.id.title_imgv_left_icon);
		currentTerm = (RelativeLayout) findViewById(R.id.setting_rlyt_switch_semester);
		settingWeek = (RelativeLayout) findViewById(R.id.setting_rlyt_cur_week);
		settingmaxcount = (RelativeLayout) findViewById(R.id.setting_rlyt_maxcount);
        settingmycount=(RelativeLayout)findViewById(R.id.setting_item_rlyt_super_account);
        user_organization=(TextView)findViewById(R.id.setting_organization);


        logoutacount=(RelativeLayout)findViewById(R.id.setting_rlyt_logout);
		curWeek=(TextView)findViewById(R.id.setting_txv_cur_week);
		maxNum=(TextView)findViewById(R.id.setting_txv_maxcount);
		curTerm=(TextView)findViewById(R.id.setting_txv_switch_semester);
        imageView.setVisibility(View.INVISIBLE);
        account_status=(TextView)findViewById(R.id.setting_txv_account_status);



        final SharedPreferences courseSettings = getSharedPreferences(
                "course_setting", Activity.MODE_PRIVATE);
		
		//�����˺ŵ�½

        String currentCount=courseSettings.getString("acountStatus","false");


		// ��ȡ��ǰѧ��
		String currentTerms = courseSettings.getString("currentTerm",null);
		// ��ȡ����
		String currentWeek=courseSettings.getString("currentWeek", null);

		// ��ȡ������
		//String maxCourseNum = courseSettings.getString("maxCourseNum",null);

        //��ȡ�û���
		String username=courseSettings.getString("name","���¼");

        //��ȡ�û����ڵ�λ
        String organization=courseSettings.getString("organization",null);
        user_organization.setText(organization);

		if(currentTerms!=null){
			curTerm.setText(currentTerms);
		}
		
		if(currentWeek!=null){
			curWeek.setText(currentWeek);
		}
		/*if(maxCourseNum!=null){
			maxNum.setText(maxCourseNum);
		}*/


        if(courseSettings.getString("acountStatus", "false").equals("true")){
            account_status.setText(username);
            logoutacount.setVisibility(View.VISIBLE);
        }else if(courseSettings.getString("acountStatus", "false").equals("false")){
            account_status.setText("���½");
            logoutacount.setVisibility(View.INVISIBLE);
        }




        //�����ҵ��˺�
        settingmycount.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {


                if(courseSettings.getString("acountStatus", "false").equals("true")){
                    final ConfirmDialog dlg=new ConfirmDialog(SettingActivity.this,R.style.MyDialog,"�����˺ŵ�½��ȷ��Ҫ�л��˺���");
                    dlg.show();
                    dlg.setNegativeButton("ȡ��", new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                            dlg.cancel();
                        }
                    });
                    dlg.setPositiveButton("ȷ��", new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub

                            Intent intent = new Intent();
                            intent.setClass(SettingActivity.this,User_login.class);
                            startActivity(intent);
                            dlg.dismiss();
                        }
                    });
                }else{
                    Intent intent = new Intent();
                    intent.setClass(SettingActivity.this,User_login.class);
                    startActivity(intent);
                }


            }
        });
		
		// ���õ�ǰѧ��
		currentTerm.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String terms[] = null;
				int year = Calendar.getInstance().get(Calendar.YEAR);
				// ��ǰѧ�ڵ�����
				int currentIndex = 0;
				if (terms == null) {
					terms = new String[16];
					for (int i = 0; i < 8; i++) {
						terms[i * 2] = String.valueOf(year + i - 4) + "-"
								+ String.valueOf(year + i - 3) + "-1";
						terms[i * 2 + 1] = String.valueOf(year + i - 4) + "-"
								+ String.valueOf(year + i - 3) + "-2";
					}
				}
				final OneWheel wheel = new OneWheel(SettingActivity.this,
						R.style.MyDialog, terms, currentIndex);

				wheel.show();
				wheel.setTitle("��ѡ��ǰѧ��");
				final String array[]=terms;
				// ��Ƽ�����
				wheel.setPositiveButton("ȷ��", new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Editor editor=courseSettings.edit();
						editor.putString("currentTerm",array[wheel.getItemID(0)]);
						editor.commit();
						curTerm.setText(array[wheel.getItemID(0)]);
						wheel.dismiss();
					}
				});
			}
		});

		// ���õ�ǰ����

		settingWeek.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int currentIndex = 0;
				String[] terms = new String[25];
				for (int i = 0; i < 25; i++) {
					terms[i] = i + 1 + "";
				}
				final OneWheel wheel = new OneWheel(SettingActivity.this,
						R.style.MyDialog, terms, currentIndex);
				wheel.show();
				wheel.setTitle("��ѡ��ǰ����");
				final String array[]=terms;
				wheel.setPositiveButton("ȷ��", new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Editor editor=courseSettings.edit();
						editor.putString("currentWeek",array[wheel.getItemID(0)]);
						editor.commit();
						curWeek.setText(array[wheel.getItemID(0)]);
						wheel.dismiss();
					}
				});

			}
		});

		// ����������
		settingmaxcount.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int currentIndex = 0;
				String[] terms = new String[10];
				for (int i = 0; i < 10; i++) {
					terms[i] = i + 5 + "";
				}
				final OneWheel wheel = new OneWheel(SettingActivity.this,
						R.style.MyDialog, terms, currentIndex);
				wheel.show();
				wheel.setTitle("������������");
				final String array[]=terms;
				wheel.setPositiveButton("ȷ��", new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Editor editor=courseSettings.edit();
						editor.putString("maxCourseNum",array[wheel.getItemID(0)]);
						editor.commit();
						maxNum.setText(array[wheel.getItemID(0)]);
						wheel.dismiss();
					}
				});
			}
		});

        //ע���˺�
        logoutacount.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                final ConfirmDialog dlg=new ConfirmDialog(SettingActivity.this,R.style.MyDialog,"ȷ��Ҫע���˺���");
                dlg.show();
                dlg.setNegativeButton("ȡ��", new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        dlg.cancel();
                    }
                });
                dlg.setPositiveButton("ȷ��", new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub

                        SharedPreferences.Editor editor=courseSettings.edit();
                        editor.putString("acountStatus","false");
                        editor.putString("organization","");
                        editor.commit();
                        refresh();

                        CourseInfoDB courseDB=new CourseInfoDB(SettingActivity.this);
                        courseDB.deleteAll();
                        courseDB.close();
                        dlg.dismiss();
                    }
                });





            }
        });



		// �������ذ�ť
		imageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// Intent intent = new Intent();
				// intent.setClass(SearchCourse.this, MainActivity.class);
				// startActivity(intent);
				SettingActivity.this.finish();

			}
		});
	}
    //ˢ��
    public void refresh(){
        onCreate(null);
    }
}
