package jordan.despair.com.despair;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import jordan.despair.com.despair.tool.Activitytool;

public class Login extends Activitytool implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView textView = (TextView) findViewById(R.id.title_text);
        textView.setText("登录");
        TextView lookaroud = (TextView) findViewById(R.id.lookaround);
        TextView service = (TextView) findViewById(R.id.service_button);
        lookaroud.setOnClickListener(this);
        service.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lookaround:
                StartAct(MainActivity.class);
                break;
            case R.id.service_button:
                StartAct(service.class);
        }
    }
}
