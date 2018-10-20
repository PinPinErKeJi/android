package ymt.com.adroud;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG="MyBroadcase";
    public MyReceiver(){

        Log.i(TAG, "MyReceiver");
    }

    @Override//此处已经接收到广播，只不过还需要判断是不是我需要的广播
    public void onReceive(Context context, Intent intent) {

         //throw new UnsupportedOperationException("Not yet implemented");
        String action=intent.getAction();

        String broadcast=context.getString(R.string.brodcast);//拿到广播标记的字符串，这个brodcast和broadcastActivity的brodcast是一样的
        if(action.equals(broadcast)){
            //从intent中取出数据
            String name = context.getResources().getString(R.string.intent_name);
            String msg=intent.getStringExtra(name);//通过name取出数据，这里相当key value中的可以=name
            Log.i(TAG,msg);
            Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();


        }
    }
}
