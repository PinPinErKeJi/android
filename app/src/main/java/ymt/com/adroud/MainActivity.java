package ymt.com.adroud;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.KeyEventDispatcher;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
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
        intent.putExtra(conmonKey,info);
        startActivity(intent);
    }
}
