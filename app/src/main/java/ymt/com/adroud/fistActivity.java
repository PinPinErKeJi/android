package ymt.com.adroud;


import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class fistActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fist_activity);
        Bundle bundle= getIntent().getExtras();
        String commonKey= getResources().getString(R.string.Common_key);
        String info=bundle.getString(commonKey);
        TextView textView=findViewById(R.id.textView);
        textView.setText(info);


    }

}
