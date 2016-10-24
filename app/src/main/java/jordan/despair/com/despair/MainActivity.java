package jordan.despair.com.despair;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import jordan.despair.com.despair.tool.Activitytool;

public class MainActivity extends Activitytool {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView bar = (TextView) findViewById(R.id.title_text);
        bar.setText(R.string.hot);
        bar.setBackgroundColor(Color.parseColor("#10000000"));//......
    }
}
