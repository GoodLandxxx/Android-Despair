package jordan.despair.com.despair;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import jordan.despair.com.despair.tool.SqlProcess;

public class sign_in extends AppCompatActivity {
    private String user_name;
    private String password;
    private String school;
    private String email;
    private String phone;
    private sign_in thiss;
    private SQLiteDatabase db;

    private AutoCompleteTextView attv;
    private final String create_table = "Create  TABLE user ([user_name] varchar(8), [password] varchar(16) NOT NULL ,[phone] varchar(11) ,[email] varchar(20) ,[classs] int(1), [school] varchar(50),Primary Key(user_name) ) ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        String[] books = new String[]{
                "广东邮电职业技术学院",
                "广州大学",
                "中山大学",
                "麻省理工大学"
        };
        this.attv = (AutoCompleteTextView) super.findViewById(R.id.sign_school);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.textview, books);
        attv.setAdapter(arrayAdapter);
        thiss = jordan.despair.com.despair.sign_in.this;
        db = SqlProcess.openDB(thiss);
//        try {
//            db.execSQL(create_table);
//        } catch (SQLException e) {
//        }
//        final int classs = Integer.parseInt(((EditText) findViewById(R.id.atttv)).getText().toString());
        Button sign_in = (Button) findViewById(R.id.sign_in_in);
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_name = ((EditText) findViewById(R.id.sign_name)).getText().toString();
                password = ((EditText) findViewById(R.id.sign_password)).getText().toString();
                school = ((EditText) findViewById(R.id.sign_school)).getText().toString();
                email = ((EditText) findViewById(R.id.sign_email)).getText().toString();
                phone = ((EditText) findViewById(R.id.sign_phone)).getText().toString();
                Log.d("usernamaaaaaaaaaae", user_name);
                switch (user_name) {
                    case "":
                        Toast.makeText(thiss, "帐号不能为空", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        if (password != "") {
                            insertData(db, user_name, password, email, phone, school, 1);
                        } else
                            Toast.makeText(thiss, "密码不能为空", Toast.LENGTH_SHORT).show();
                        break;

                }

            }
        });

    }

    private void insertData(SQLiteDatabase db, String user, String password, String school, String email, String phone, int classs)  // ②
    {
        // 执行插入语句
//        try {
        db.execSQL("insert into user(user_name,password,school,email,phone,classs) values(\"" + user + "\",\"" + password + "\",\"" + school + "\",\"" + email + "\",\"" + phone + "\"," + classs + ")");
//        } catch (SQLException e) {
        Toast.makeText(this, "你已经注册", Toast.LENGTH_SHORT).show();
//        }
    }

}
