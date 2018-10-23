package ymt.com.adroud;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {
    private MediaPlayer mp;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate() {
        super.onCreate();
        //创建一个MediaPlayer播放组件
        mp=MediaPlayer.create(this, R.raw.test);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //判断传弟过来的值，如果是真就执行播放反知
        mp.start();
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        //释放资源
        mp.release();
        stopSelf();
    }

}
