package ymt.com.adroud;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;

import android.view.View;

import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         editText=findViewById(R.id.editText);

    }

    //点击页面跳转setClass，不传值
    public void click(View view) {
        Intent intent=new  Intent();
        intent.setClass(this,fistActivity.class);
        startActivity(intent);

    }
    //点击页面按钮跳转componentname,传值到下一个页面
    public void ConClick(View view) {
        Intent intent=new Intent();
        ComponentName cn=new ComponentName("ymt.com.adroud","ymt.com.adroud.fistActivity");
        intent.setComponent(cn);
        String info=editText.getText().toString();
        String conmonKey=getResources().getString(R.string.Common_key);
        intent.putExtra(conmonKey,info);//此处关键位置用来传递值
        startActivity(intent);
    }
    //页面跳转到第二个页面，带返回值
    public void returnClick(View view){
        Intent intent=new Intent();
        intent.setClass(this,fistActivity.class);
        String info=editText.getText().toString();
        String conmonKey=getResources().getString(R.string.Common_key);
        intent.putExtra(conmonKey,info);//此处关键位置用来传递值
        startActivityForResult(intent,200);//请求码，非常关键

    }
    //获取第二个Activity的返回值 requestCode请求码，resultCode结果码，data返回的数据
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 200 && resultCode==100){
            String resultName=getResources().getString(R.string.result_key);
            String resuilt=data.getStringExtra(resultName);
            tv=findViewById(R.id.textView2);
            String comBack_info=getResources().getString(R.string.returname);
            tv.setText(comBack_info+resuilt);

        }
    }
}
