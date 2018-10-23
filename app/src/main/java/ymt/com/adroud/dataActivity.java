package ymt.com.adroud;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class dataActivity extends AppCompatActivity {
    private String fileName = "itlead";
    private String userName = "userName";
    private String userAge = "userAge";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_activity);
    }

    public void save(View view){
        //后去sharedpreference对象/ MODE_PRIVATE是私有的保护模式
        SharedPreferences sharedPreferences=this.getSharedPreferences(fileName,Context.MODE_PRIVATE);
        //过去SharedPreferences的编辑器
        SharedPreferences.Editor editor=sharedPreferences.edit();
        //添加数据到fileNamed的文件中
        editor.putString(userName,getResources().getString(R.string.Name));
        editor.putInt(userAge,12);
        //对编辑器允许操作
        editor.commit();
    }
    public void read(View view){
        //后去sharedpreference对象/ MODE_PRIVATE是私有的保护模式
        SharedPreferences sharedPreferences=this.getSharedPreferences(fileName,Context.MODE_PRIVATE);
        String name=sharedPreferences.getString(userName,"");
        int   age=sharedPreferences.getInt(userAge,0);
        Toast.makeText(this,getResources().getString(R.string.name)+name+getResources().getString(R.string.age)+age,Toast.LENGTH_SHORT).show();

    }
}
