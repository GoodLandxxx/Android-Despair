package jordan.despair.com.despair;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class service extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        TextView service = (TextView) findViewById(R.id.title_text);
        service.setText("服务条款");
    }
}
