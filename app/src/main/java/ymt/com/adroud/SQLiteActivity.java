package ymt.com.adroud;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class SQLiteActivity extends AppCompatActivity {
    private MySqLiteHepler myHepler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sql_activity);

          //   myHepler=new MySqLiteHepler(this,mySqlite3_Itlead.db,null,1);

    }
    public void insertAndUdataData(){
      //  SQLiteDatabase db=myHelper.getWritableDatabase();
    }

}
