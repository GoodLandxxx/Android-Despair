package jordan.despair.com.despair;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import jordan.despair.com.despair.tool.SqlProcess;
import jordan.despair.com.despair.tool.SqlProcess.*;
import jordan.despair.com.despair.tool.Activitytool;
import jordan.despair.com.despair.tool.my_Toast;

public class Login extends Activitytool implements View.OnClickListener {
    private static SQLiteDatabase dbb;
    private boolean isEx = true;
    public static boolean ISLOGIN = false;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView textView = (TextView) findViewById(R.id.title_text);
        textView.setText("登录");
        TextView lookaroud = (TextView) findViewById(R.id.lookaround);
        TextView service = (TextView) findViewById(R.id.service_button);
        Button sign = (Button) findViewById(R.id.sign_in);
        Button login = (Button) findViewById(R.id.login_);
        lookaroud.setOnClickListener(this);
        service.setOnClickListener(this);
        sign.setOnClickListener(this);
        login.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in:
                StartAct(sign_in.class);
                break;
            case R.id.lookaround:
                StartAct(MainActivity.class);
                break;
            case R.id.service_button:
                StartAct(service.class);
                break;
            case R.id.login_: {
                login();
            } default:
                break;

        }
    }

    public void login() {
        db = SqlProcess.openDB(this);

        db.execSQL("insert into login(islogin) values(0)");
        String user_name = ((EditText) findViewById(R.id.user_name)).getText().toString();
        String password = ((EditText) findViewById(R.id._password)).getText().toString();
        CheckBox checkBox = (CheckBox) findViewById(R.id.servier_text);
        if (user_name.isEmpty())
            Toast.makeText(this, "请输入帐号", Toast.LENGTH_SHORT).show();
        else if (password.isEmpty())
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
        else {
            if (!isFieldExist(db, "user", "user_name", user_name))
                Toast.makeText(this, "帐号不存在", Toast.LENGTH_SHORT).show();
            else if (isFieldExist(db, "user", "user_name", user_name)
                    && !isFieldExist(db, "user", "password", password))
                Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
            else if (!checkBox.isChecked())
                Toast.makeText(this, "请同意服务条款", Toast.LENGTH_SHORT).show();
            else if (isFieldExist(db, "user", "user_name", user_name) && isFieldExist(db, "user", "password", password) && checkBox.isChecked()) {
                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                db.execSQL("update  login set islogin = '1' ");
                StartAct(MainActivity.class);
                finish();
            }
        }
    }

    private boolean isFieldExist(SQLiteDatabase db, String tableName, String columnName, String dataName) {
        String queryStr = "select %s from %s where %s = '%s'";
        queryStr = String.format(queryStr, columnName, tableName, columnName, dataName);
        Cursor c = null;
        try {
            c = db.rawQuery(queryStr, null);
        }catch (SQLiteException e)
        {
            Toast.makeText(this, "帐号不存在", Toast.LENGTH_SHORT).show();
        }
        String tableCreateSql = null;
        try {
            if (c != null && c.moveToFirst()) {
                tableCreateSql = c.getString(c.getColumnIndex(columnName));
            }
        } finally {
            if (c != null)
                c.close();
        }
        if (tableCreateSql != null && tableCreateSql.contains(dataName))
            return true;
        return false;
    }

}
