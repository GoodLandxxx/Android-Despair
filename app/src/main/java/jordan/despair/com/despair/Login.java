package jordan.despair.com.despair;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import jordan.despair.com.despair.tool.SqlProcess;
import jordan.despair.com.despair.tool.SqlProcess.*;
import jordan.despair.com.despair.tool.Activitytool;
import jordan.despair.com.despair.tool.my_Toast;

public class Login extends Activitytool implements View.OnClickListener {
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
            case R.id.login_:
                login();
            default:
                break;

        }
    }

    public void login() {
        SQLiteDatabase db = SqlProcess.openDB(this);
        String user_name = ((EditText) findViewById(R.id.user_name)).getText().toString();
        String password = ((EditText) findViewById(R.id._password)).getText().toString();

        if (user_name.isEmpty())
            Toast.makeText(this, "请输入帐号", Toast.LENGTH_SHORT).show();
        else if (password.isEmpty())
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
        else
            selectData(db, user_name, password);
    }

    private void selectData(SQLiteDatabase db
            , String user_name, String password)  // ②
    {
        String in = "select user_name,password  from user where user_name = %s and password = %s";
        String str = String.format(in, user_name,password);
        Cursor cursor = null;
        try {
            cursor = db.rawQuery(str,null);

        }catch (SQLiteException E)
        {
            Toast.makeText(this, "登录失败1111111", Toast.LENGTH_SHORT).show();
        }
        Log.d("aa",str);
        String is  = null;
        try {
            if (cursor!=null && cursor.moveToFirst()) {
                is = cursor.getString(cursor.getColumnIndex("user_name"));
                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            }
            cursor.close();
        } finally {
           if (cursor ==null)
                Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
        }

    }

}
