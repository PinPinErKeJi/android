package ymt.com.adroud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqLiteHepler extends SQLiteOpenHelper {

        //调用父类构造器
        //创建Cursor的工厂，参数是为了可以自定义Cursor创建
    public MySqLiteHepler( Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //创建数据中的字段
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table PersonInfo("+"id int primary key autoincrement,"+
                "name text,"+"level text)");

    }
    //当打开数据库时传入的版本号不同时调用该方法
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
