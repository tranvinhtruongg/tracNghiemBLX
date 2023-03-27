package vn.edu.tdmu.tranvinhtruong.tracnghiemblx;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import vn.edu.tdmu.tranvinhtruong.tracnghiemblx.Question.DBHelper;
import vn.edu.tdmu.tranvinhtruong.tracnghiemblx.slide.ScreenSlidePagerActivity;

//public class HomeFragment extends Fragment {
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false);
//    }
//}

public class HomeFragment extends AppCompatActivity{
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private PhotoAdapter photoAdapter;
    Button btnThi, btnHoc, btnBienBao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        viewPager=findViewById(R.id.viewpager);
        circleIndicator=findViewById(R.id.circle_indicator);

        photoAdapter=new PhotoAdapter(this,getListPhoto());
        viewPager.setAdapter(photoAdapter);

        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());

        btnThi = (Button) findViewById(R.id.btnThi);
        btnThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeFragment.this, ScreenSlidePagerActivity.class);
                startActivity(intent);
            }
        });
        DBHelper db =new DBHelper(getApplicationContext());
        try {
            db.createDataBase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private List<Photo> getListPhoto(){
        List<Photo> list= new ArrayList<>();
        list.add(new Photo(R.drawable.banner1));
        list.add(new Photo(R.drawable.banner2));
        list.add(new Photo(R.drawable.banner3));
        list.add(new Photo(R.drawable.banner4));
        list.add(new Photo(R.drawable.banner5));
        return list;
    }
}
