package ymt.com.adroud;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class broadcastActivity extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast_activity);
        editText=findViewById(R.id.editTextBroad);

    }
    public void sendBroadcast(View view){
        Intent intent=new Intent();
        //设置Broadcase的动作
        String broadcast1=getResources().getString(R.string.brodcast);
        intent.setAction(broadcast1);//广播内容设置
        //携带数据这里我们采取intent的putExtra
        String name=getResources().getString(R.string.intent_name);
        intent.putExtra(name,editText.getText().toString());
        //发送广播
        this.sendBroadcast(intent);

    }
}
