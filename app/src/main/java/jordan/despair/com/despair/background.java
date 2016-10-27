package jordan.despair.com.despair;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import jordan.despair.com.despair.tool.Activitytool;
import jordan.despair.com.despair.tool.isLogin;

public class background extends Activitytool {
    private static final int WHAT_INTENT2LOGIN = 1;
    private static final int WHAT_INTENT2MAIN = 2;
    private static final long SPLASH_DUR_TIME = 1500;
    private isLogin isLogin = new isLogin();
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case WHAT_INTENT2LOGIN:
                    StartAct(Login.class);
//                    startActivity(new Intent(background.this,Login.class));
                    finish();
                    break;
                case WHAT_INTENT2MAIN:
                    StartAct(MainActivity.class);
                    finish();
                    break;
                default:
                    break;
            }
        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.BG);
        setContentView(R.layout.activity_background);
    //        ImageView imageView = (ImageView) findViewById(R.id.imageView);
    //        imageView.setBackground(getResources().getDrawable(R.drawable.java));

        if(isLogin.isLogin(this)) //判断他是否登录
        {
            handler.sendEmptyMessageDelayed(WHAT_INTENT2MAIN, SPLASH_DUR_TIME);
        } else {
            handler.sendEmptyMessageDelayed(WHAT_INTENT2LOGIN, SPLASH_DUR_TIME);
        }
        Log.d("ASDASDASD", String.valueOf(isLogin.isLogin(this)));
    }
}
