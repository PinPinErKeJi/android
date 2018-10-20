package ymt.com.adroud;


import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class fistActivity extends AppCompatActivity {
    private EditText editText;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取得跳转过来的页面携带de值
        setContentView(R.layout.fist_activity);
        Bundle bundle= getIntent().getExtras();
        String commonKey= getResources().getString(R.string.Common_key);
        String info=bundle.getString(commonKey);//这里还可以直接用getStringExtra()
        TextView textView=findViewById(R.id.textView);
        textView.setText(info);


    }
    //要返回给调用的Activity的值
    public void ClickFan(View view){
        editText=findViewById(R.id.editText_return);
        String content=editText.getText().toString();
        Intent intent=new Intent();
        String name_result= getResources().getString(R.string.result_key);
        intent.putExtra(name_result,content);
        setResult(100,intent);
        finish();//销毁

    }


}
