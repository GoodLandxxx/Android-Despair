package jordan.despair.com.despair;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ContactActivity extends Fragment {
    private View view;

    private FloatingActionButton fab_contact;
    public static boolean fab_state = true;
    private ImageView img;
    private List<HashMap<String, Object>> mData;
    private ListView listView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_contact, container, false);
        fab_contact = (FloatingActionButton) view.findViewById(R.id.fab_contact);
        final MyAdapter adapter = new MyAdapter(this.getContext());//创建一个适配器
        fab_contact.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {//切换视图
                fab_contact.setImageDrawable(getResources().getDrawable(R.drawable.ic_swap_vert_white_18dp));
                return false;
            }
        });
        fab_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData = getData();//为刚才的变量赋值
                listView = (ListView) view.findViewById(R.id.ListView_contact);//实例化ListView
                listView.setAdapter(adapter);//为ListView控件绑定适配器
            }
        });
        return view;

    }



    public class MyAdapter extends BaseAdapter {
        private LayoutInflater mInflater;// 动态布局映射

        public MyAdapter(Context context) {

            this.mInflater = LayoutInflater.from(context);
        }


        // 决定ListView有几行可见
        @Override
        public int getCount() {
            return mData.size();// ListView的条目数
        }

        @Override
        public Object getItem(int arg0) {
            return null;
        }

        @Override
        public long getItemId(int arg0) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = mInflater.inflate(R.layout.activity_contact_item, null);//根据布局文件实例化view
            TextView title = (TextView) convertView.findViewById(R.id.title);//找某个控件
            title.setText(mData.get(position).get("info").toString());//给该控件设置数据(数据从集合类中来)
            img = (ImageView) convertView.findViewById(R.id.img);
            img.setBackgroundResource((Integer) mData.get(position).get("img"));
            return convertView;
        }
    }
    // 初始化一个List
    private List<HashMap<String, Object>> getData() {
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map = null;
        for (int i = 1; i <= 10; i++) {//取决于数据库的大小
            map = new HashMap<String, Object>();
            map.put("info", "我通过了你的好友验证请求");
            map.put("img", R.drawable.ke_facebook_profile);
            list.add(map);
        }

        return list;
    }
    public void showInfo(int position){
        getData();
    }

    public void sqlprocess(){

    }
}