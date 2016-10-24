package jordan.despair.com.despair.tool;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by jordan on 2016/10/24.
 */

public class Activitytool  extends AppCompatActivity {
    public void StartAct(Class<?> tarActivity) {
        Intent intent = new Intent(this, tarActivity);
        new Intent( );
        startActivity(intent);
    }
}

