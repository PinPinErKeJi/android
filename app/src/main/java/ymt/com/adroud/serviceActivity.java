package ymt.com.adroud;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class serviceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_activity);
    }

    public void start(View view){
        Intent intent=new Intent(serviceActivity.this,MyService.class);
        startService(intent);
    }
    public void stop(View view){
        Intent intent=new Intent(serviceActivity.this,MyService.class);
        stopService(intent);
    }
}
