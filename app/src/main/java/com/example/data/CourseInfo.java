/*
package com.example.data;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CourseInfo implements Serializable{
	private String courseName;  //�γ�����
	private int courseId;   	//�γ�ID 
	private String courseNum;		//�γ����
	private String teacherName;	//��ʦ����
	private String courseTime; 		//�ļ����Ͽ�
	private int week;		//�ܼ��Ͽ�
	private String  weekNum;  	//�ļ����пΣ��ϵ�������
	private String  coursePlace;	//�Ͽεص�
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseNum() {
		return courseNum;
	}
	public void setCourseNum(String courseNum) {
		this.courseNum = courseNum;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}
	public int getWeek() {	
		return week;
	}
	public String getWeekString(){
		//String temp=null;
		switch(week){
		case 1:
			return "��һ";
		case 2:
			return "�ܶ�";
		case 3:
			return "����";
		case 4:
			return "����";
		case 5:
			return "����";
		case 6:
			return "����";
		case 7:
			return "����";
			default:
				return null;
		}
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public String getWeekNum() {
		return weekNum;
	}
	public void setWeekNum(String weekNum) {
		this.weekNum = weekNum;
	}
	public String getCoursePlace() {
		return coursePlace;
	}
	public void setCoursePlace(String coursePlace) {
		this.coursePlace = coursePlace;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		super.toString();
		return "�γ�����:"+courseName+",��ʦ����"+teacherName+",�Ͽεص�"+coursePlace;
	}
	
}
*/

package com.example.data;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.ArrayList;


import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;

/**
 * Created by jasine on 14/12/17.
 */
@Root
@SuppressWarnings("serial")
public class CourseInfo implements Serializable{




    @Element(name = "Name")
    private String courseName;  //�γ�����

    @Element(name = "Id")
    private int courseId;   	//�γ�ID

    @Element(name = "Num")
    private String courseNum;		//�γ����

    @Element(name = "Teacher",required = false)
    private String teacherName;	//��ʦ����

    @Element(name = "Time")
    private String courseTime; 		//�ļ����Ͽ�

    @Element(name = "Week")
    private int week;		//�ܼ��Ͽ�

    @Element(name = "WeekNum")
    private   String weekNum;  	//�ļ����пΣ��ϵ�������

    @Element(name = "Place")
    private String  coursePlace;	//�Ͽεص�

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public String getCourseNum() {
        return courseNum;
    }


    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }
    public int getWeek() {
        return week;
    }
    public  String getWeekString(){
        switch(week){
            case 1:
                return "��һ";
            case 2:
                return "�ܶ�";
            case 3:
                return "����";
            case 4:
                return "����";
            case 5:
                return "����";
            case 6:
                return "����";
            case 7:
                return "����";
            default:
                return null;
        }
    }

    public static  int getWeekIndex(String week){
        if(week.equals("����һ"))
            return 1;
        else if(week.equals("���ڶ�"))
            return 2;
        else if(week.equals("������"))
            return 3;
        else if(week.equals("������"))
            return 4;
        else if(week.equals("������"))
            return 5;
        else if(week.equals("������"))
            return 6;
        else if(week.equals("������")||week.equals("������"))
            return 7;
        else
            return 0;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public ArrayList<Integer> getWeekNumArray() {
        ArrayList<Integer> weekNum1=new ArrayList<Integer>();
        String[] tem=weekNum.split("��");
        for(int i=0;i<tem.length;i++){
            weekNum1.add(Integer.parseInt(tem[i]));
        }


        return weekNum1;
    }
    public String getWeekNumString(){

        return weekNum;
    }

    //����ֱ�Ӹ�ֵ
    public void setWeekNumString(String weekNum){


        this.weekNum=weekNum;
    }
    public void setWeekNum(String weekNum) {
        this.weekNum=weekNum;
    }

    public String getWeekNum(){
        return weekNum;
    }
    public String getCoursePlace() {
        return coursePlace;
    }

    public void setCoursePlace(String coursePlace) {
        this.coursePlace = coursePlace;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        super.toString();
        return "�γ�����:"+courseName+",��ʦ����:"+teacherName+",�Ͽεص�:"+coursePlace;
    }

    public CourseInfo(){
        super();
    }

}
