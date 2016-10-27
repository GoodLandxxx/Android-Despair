package jordan.despair.com.despair.tool;

/**
 * Created by jordan on 2016/10/26.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import jordan.despair.com.despair.background;
import jordan.despair.com.despair.tool.SqlProcess;

public class isLogin {
    private SQLiteDatabase db;

    public boolean isLogin(Context context) {
        db = SqlProcess.openDB(context);
        Cursor c = null;

        try {
            db.execSQL("create table  login([islogin] varchar(1) NOT NULL )");
        }catch ( SQLiteException E)
        {
            db.execSQL("insert into login(islogin) values(0)");

        }
        try{c = db.rawQuery("select islogin from  login", null);}
        catch (SQLiteException E)
        {
                db.execSQL("update login set islogin = '1' ");

        }
        String tableCreateSql = null;
        try {
            if (c != null && c.moveToFirst()) {
                tableCreateSql = c.getString(c.getColumnIndex("islogin"));
            }
        } finally {
            if (c != null)
                c.close();
        }
        if (tableCreateSql != null && tableCreateSql.contains("1"))
            return true;
        return false;
    }
}
