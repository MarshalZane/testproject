package shangendong.bawei.com.testproject;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private int a=5;
       private  Handler handler = new  Handler() {
               @Override
               public void handleMessage(Message msg) {
                  textView.setText(a+"");
               }
           };
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= (TextView) findViewById(R.id.tv);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                a--;
                handler.sendEmptyMessage(a);
            }
        },0,1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}
