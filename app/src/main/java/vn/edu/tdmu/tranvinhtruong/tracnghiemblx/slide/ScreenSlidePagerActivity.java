package vn.edu.tdmu.tranvinhtruong.tracnghiemblx.slide;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import vn.edu.tdmu.tranvinhtruong.tracnghiemblx.Question.DBHelper;
import vn.edu.tdmu.tranvinhtruong.tracnghiemblx.Question.QuestionDTO;
import vn.edu.tdmu.tranvinhtruong.tracnghiemblx.Question.QuestionDAO;
import vn.edu.tdmu.tranvinhtruong.tracnghiemblx.R;

public class ScreenSlidePagerActivity extends FragmentActivity {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 25;


    private ViewPager2 viewPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private FragmentStateAdapter pagerAdapter;
    QuestionDAO questionDAO;
    ArrayList<QuestionDTO>listQuestion;
    private int MD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide_pager);
        DBHelper dbHelper = new DBHelper(getApplicationContext());
        questionDAO=new QuestionDAO(dbHelper);

        // Instantiate a ViewPager2 and a PagerAdapter.
        viewPager = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);
    }
   /* public ArrayList<QuestionDTO>getData(){
        return  arr_Ques;
    }*/
    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        public ScreenSlidePagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {
            return ScreenSlidePageFragment.create(position);
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }
    ArrayList<QuestionDTO>getQuestion(){
        return listQuestion;
    }
}