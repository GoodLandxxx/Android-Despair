package jordan.despair.com.despair;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
public class MyselfActivity extends Fragment {
    private View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_myself, container, false);
        ImageView c = (ImageView) view.findViewById(R.id.hhh);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              view.getContext().startActivity(new Intent(MyselfActivity.this.getActivity(),user_info.class));
            }
        });
        return view;

    }

}