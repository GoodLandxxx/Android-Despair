package jordan.despair.com.despair.tool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by jordan on 2016/10/24.
 */

public class Activitytool  extends AppCompatActivity {
    public void StartAct(Class<?> tarActivity) {
        Intent intent = new Intent(this, tarActivity);
        new Intent( );
        startActivity(intent);
    }
    public void toastShowL(Context context, String string)
    {
        Toast.makeText(context,string,Toast.LENGTH_LONG).show();
    }
    public void ToastshowS(Context context, String string)
    {
        Toast.makeText(context,string,Toast.LENGTH_SHORT).show();
    }


}

