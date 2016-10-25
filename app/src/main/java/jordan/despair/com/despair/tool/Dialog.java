package jordan.despair.com.despair.tool;

import android.app.AlertDialog;
import android.content.Context;

/**
 * Created by jordan on 2016/10/25.
 */

public class Dialog extends AlertDialog.Builder {
    public Dialog(Context context, int themeResId) {
        super(context, themeResId);
    }
    public Dialog(Context context) {
        super(context);
    }
}
