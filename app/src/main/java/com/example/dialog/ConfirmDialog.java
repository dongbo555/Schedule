package com.example.dialog;

import com.example.schedule.R;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


//�Զ����ȷ�϶Ի���
public class ConfirmDialog extends Dialog {

	Context context;
	TextView title;
	TextView dlgContent;
	Button OK;
	Button cancel;
    String content=null;

	public ConfirmDialog(Context context, int theme) {
		super(context, theme);
		this.context = context;
	}

    public ConfirmDialog(Context context, int theme,String content) {
        super(context, theme);
        this.context = context;
        this.content=content;
    }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dlg_checkbox);
		title = (TextView) findViewById(R.id.dlg_txv_title);
		title.setGravity(Gravity.CENTER_HORIZONTAL);
		title.setText("��ʾ");
		dlgContent = (TextView) findViewById(R.id.confirm_content);
		dlgContent.setText("ȷ��Ҫɾ���ÿγ̣�");

        if(content.length()!=0){
            dlgContent.setText(content);

        }
		OK = (Button) findViewById(R.id.dlg_btn_sure);
		OK.setText("ɾ��");
		cancel = (Button) findViewById(R.id.dlg_btn_cancel);
		cancel.setText("ȡ��");

	}
	
	

	// �ж���ʾ��ť

	public void setPositiveButton(String text,final View.OnClickListener listener)
	{
		OK.setText(text);
		OK.setOnClickListener(listener);
	}
	public void setNegativeButton(String text,final View.OnClickListener listener)
	{
		cancel.setText(text);
		cancel.setOnClickListener(listener); 
	}

	public void setTitle(TextView title) {
		this.title = title;
	}

	public void setDlgContent(TextView dlgContent) {
		this.dlgContent = dlgContent;
	}
}
