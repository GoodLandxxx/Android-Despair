package jordan.despair.com.despair.tool;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by jordan on 2016/10/24.
 */

public class Activitytool  extends Activity{
    protected void startAct(Class<? extends Activity> tarActivity) {
        Intent intent = new Intent(this, tarActivity);
        startActivity(intent);
    }
}
