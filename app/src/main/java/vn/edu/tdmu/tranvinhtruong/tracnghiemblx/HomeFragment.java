package vn.edu.tdmu.tranvinhtruong.tracnghiemblx;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment {
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private PhotoAdapter photoAdapter;
    Button btnThi, btnHoc, btnBienBao;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        viewPager=view.findViewById(R.id.viewpager);
        circleIndicator=view.findViewById(R.id.circle_indicator);

        photoAdapter = new PhotoAdapter(getContext(),getListPhoto());
        viewPager.setAdapter(photoAdapter);

        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());

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
