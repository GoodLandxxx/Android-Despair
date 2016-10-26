package jordan.despair.com.despair.tool;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by jordan on 2016/10/26.
 */

public class SqlProcess {

    private static SQLiteDatabase db;

    public static SQLiteDatabase openDB(Context context) {
        db = SQLiteDatabase.openOrCreateDatabase(
                context.getFilesDir().getPath()
                        + "/user.db3", null);
        return db;
    }

}
