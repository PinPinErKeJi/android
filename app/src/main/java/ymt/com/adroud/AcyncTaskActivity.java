package ymt.com.adroud;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AcyncTaskActivity  extends AppCompatActivity {
    Button dowload;
    ProgressBar pb;
    TextView tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asynctack_activity);
        pb=findViewById(R.id.seekBar);
        tv=findViewById(R.id.priTextView);

        dowload=findViewById(R.id.download);

        dowload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadTask aTask=new DownloadTask();
                aTask.execute(100);

            }
        });


    }

    //AsyncTask定义了三种泛型类型 Params ,progress,result
    //Params 启动（子线程）后台任务执行时输入参数，比如http请求的url
    //progress后台任务执行百分比
    //result后台执行最终返回结果，比如String ,Integer

     class DownloadTask extends AsyncTask<Integer,Integer,Boolean>{
    //后面的尖空号内分别是(例子里是线程休息时间，进度publishProgress,返回值类型)

         @Override
         protected void onPreExecute() {
             //第一次执行的方法
             super.onPreExecute();
         }
         @Override
         protected Boolean doInBackground(Integer... params) {//这里的三个点代表数组的意思
             //第二个执行的方法onPreExecute执行后执行，
             for(int i=0;i<=params[0];i++){
                //这里面在一个线程中直接刷新精度条
                 // 看似违背了android的ui刷新原则，其实是这个函数里面自己做了同步操作
                 pb.setProgress(i);
                 //更新进度条
                 publishProgress(i);
                 try {
                     Thread.sleep(params[0]);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
             return true;
         }

         @Override//进度刷新
         protected void onProgressUpdate(Integer... progress) {
             //这个函数是在doInBackground调用publishProgress时触发的，虽然调用时只有一个参数、
             //但是这里取到是一个数组，所以要调用progress[0]来取值
             //第n个参数就是progress[n]来取值
             tv.setText(progress[0]+"%");

             super.onProgressUpdate(progress);
         }
            //做ui界面最后刷星
         @Override
         protected void onPostExecute(Boolean result) {
             //doInBackground返回时触发，也就是doInBackground执行完后触发
             if(result){
                 setTitle(getResources().getString(R.string.downsuccess));
             }
             super.onPostExecute(result);
         }
     }

}
