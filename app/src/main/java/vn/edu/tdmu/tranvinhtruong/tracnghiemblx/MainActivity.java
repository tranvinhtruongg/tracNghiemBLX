package vn.edu.tdmu.tranvinhtruong.tracnghiemblx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import vn.edu.tdmu.tranvinhtruong.tracnghiemblx.Question.DBHelper;
import vn.edu.tdmu.tranvinhtruong.tracnghiemblx.slide.ScreenSlidePagerActivity;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private PhotoAdapter photoAdapter;
    Button btnThi, btnHoc, btnBienBao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager=findViewById(R.id.viewpager);
        circleIndicator=findViewById(R.id.circle_indicator);

        photoAdapter = new PhotoAdapter(this,getListPhoto());
        viewPager.setAdapter(photoAdapter);

        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());

        btnThi = (Button) findViewById(R.id.btnThi);
        btnThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScreenSlidePagerActivity.class);
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