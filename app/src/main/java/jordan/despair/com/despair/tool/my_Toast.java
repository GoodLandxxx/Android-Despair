package jordan.despair.com.despair.tool;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by jordan on 2016/10/26.
 */

public class my_Toast extends Toast {
    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     *
     * @param context The context to use.  Usually your {@link Application}
     *                or {@link Activity} object.
     */
    public my_Toast(Context context) {
        super(context);
    }
    public my_Toast(Context context,String string)
    {
        super(context);
        Toast.makeText(context,string,Toast.LENGTH_SHORT).show();
    }
}
