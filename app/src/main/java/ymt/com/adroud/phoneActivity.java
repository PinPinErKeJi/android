package ymt.com.adroud;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;


public class phoneActivity extends AppCompatActivity {
    private EditText editText;
    private String PhoneNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_activity);
        editText = editText.findViewById(R.id.editText);
    }
    public void daPhone(){
        //获取电话号码
        PhoneNumber = editText.getText().toString().trim();
        //新建意图
        Intent intent=new Intent();
        //动作
        intent.setAction(Intent.ACTION_DIAL);
        //获取打电话的地址
        intent.setData(Uri.parse("tel:"+PhoneNumber));
        //开启动作
        startActivity(intent);

    }
}
