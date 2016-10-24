package jordan.despair.com.despair;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class background extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.BG);
        setContentView(R.layout.activity_background);
//        ImageView imageView = (ImageView) findViewById(R.id.imageView);
//        imageView.setBackground(getResources().getDrawable(R.drawable.java));

    }
}
