package com.example.main;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.data.CourseInfo;
import com.example.db.CourseInfoDB;
import com.example.schedule.R;
import com.example.util.CourseInfoList;
import com.example.util.GetStream;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dong on 2014/12/17.
 */


public class User_login extends Activity {

    private TextView title;
    private ImageView back;
    private Button login;
    EditText username, userpwd;
    String name = "";
    String organization = "";
    int currentWeek;


    List<CourseInfo> courseInfos = new ArrayList<CourseInfo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_user_login);

        login = (Button) findViewById(R.id.user_login_btn_login);
        back = (ImageView) findViewById(R.id.title_imgv_left_icon);
        title = (TextView) findViewById(R.id.title_txv_title);
        title.setText("��½");
        username = (EditText) findViewById(R.id.user_login_edt_account);
        userpwd = (EditText) findViewById(R.id.user_login_edt_password);


        final SharedPreferences courseSettings = getSharedPreferences(
                "course_setting", Activity.MODE_PRIVATE);


        //������½
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (username.getText().length() == 0 || userpwd.getText().length() == 0) {
                    Toast.makeText(User_login.this,"�˺ź����벻��Ϊ��", Toast.LENGTH_SHORT).show();

                } else {
                    //Toast.makeText(User_login.this, "���ڵ�½�����Ժ�....", Toast.LENGTH_SHORT).show();
                    //login.setText("���ڵ�½");
                    //new GetStream().getStream(username.getText().toString(),userpwd.getText().toString());
                    InputStream getstream = new GetStream().getStream(username.getText().toString(), userpwd.getText().toString());
                    //getstream.getStream(username.getText().toString(), userpwd.getText().toString());
                    //��½�ɹ�ʱ�Ĳ���
                    try {

                        //title.setText("���ڵ�½...");
                        //courseInfos = new CourseInfoList().GetCourseInfoList(getResources().getAssets().open("course.xml")).getCourseInfos();
                        CourseInfoList courseinfolist = new CourseInfoList().GetCourseInfoList(getstream);
                        courseInfos = courseinfolist.getCourseInfos();
                        if (courseInfos.isEmpty()) {
                            Toast.makeText(User_login.this,"�û������������", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        name = courseinfolist.getName();
                        organization = courseinfolist.getOrganization();
                        currentWeek = courseinfolist.getThisWeek();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(User_login.this,
                                "�û������������", Toast.LENGTH_SHORT).show();
                        //title.setText("��½");
                        return;
                    }
                    CourseInfoDB courseDB = new CourseInfoDB(User_login.this);
                    courseDB.deleteAll();
                    for (CourseInfo courseInfo : courseInfos) {
                        courseDB.insertCourse(courseInfo);
                    }
                    courseDB.close();
                    SharedPreferences.Editor editor = courseSettings.edit();
                    editor.putString("acountStatus", "true");
                    editor.putString("currentWeek", currentWeek + "");
                    editor.putString("name", name);
                    editor.putString("organization", organization);
                    editor.commit();
                    Toast.makeText(User_login.this, name + "ͬѧ�ѵ�½!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });


        //�������ذ�ť
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User_login.this.finish();
            }
        });

    }


}

