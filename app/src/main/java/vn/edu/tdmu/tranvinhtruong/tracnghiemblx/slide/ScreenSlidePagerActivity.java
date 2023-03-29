package vn.edu.tdmu.tranvinhtruong.tracnghiemblx.slide;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import vn.edu.tdmu.tranvinhtruong.tracnghiemblx.CheckAdapter;
import vn.edu.tdmu.tranvinhtruong.tracnghiemblx.Question.DBHelper;
import vn.edu.tdmu.tranvinhtruong.tracnghiemblx.Question.QuestionDTO;
import vn.edu.tdmu.tranvinhtruong.tracnghiemblx.Question.QuestionDAO;
import vn.edu.tdmu.tranvinhtruong.tracnghiemblx.R;

public class ScreenSlidePagerActivity extends FragmentActivity {
ArrayList<QuestionDTO>listQuestion;
QuestionDAO questionDAO;
TextView tv_Clock,tv_Position;
int ID_Exam;
    CounterClass timer;
    private static final int NUM_PAGES = 25;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager2 viewPager;

    private FragmentStateAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide_pager);

        Intent intent=getIntent();
        ID_Exam=intent.getIntExtra("ID_Exam",0);

        // Instantiate a ViewPager2 and a PagerAdapter.
        viewPager = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);
        DBHelper dbHelper=new DBHelper(getApplicationContext());
        questionDAO=new QuestionDAO(dbHelper);
        listQuestion=questionDAO.findquestionByMD(ID_Exam);

        tv_Position=(TextView)findViewById(R.id.tv_Position);
        tv_Position.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAns();
            }
        });
        tv_Clock=(TextView) findViewById(R.id.tv_Clock);
        timer=new CounterClass(1200*1000,1000);
        if(!listQuestion.isEmpty())
        {
            Log.e("question",listQuestion.size()+"");
        }

        tv_Clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        timer.start();
    }



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

    public ArrayList<QuestionDTO> listQuestion() {
        return listQuestion;
    }


    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        public ScreenSlidePagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {
            return  ScreenSlidePageFragment.create(position);
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }

    }
    public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            String countTime = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished), TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
            tv_Clock.setText(countTime); //SetText cho textview hiện thị thời gian.
        }

        @Override
        public void onFinish() {
            tv_Clock.setText("00:00");  //SetText cho textview hiện thị thời gian.
        }

    }
    public void checkAns(){
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.check_ans_dialog);
        CheckAdapter checkAdapter=new CheckAdapter(listQuestion,this);
        GridView gvAns=(GridView) dialog.findViewById(R.id.gv_check_ans);
        gvAns.setAdapter(checkAdapter);
        gvAns.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                viewPager.setCurrentItem(position);
                dialog.dismiss();
            }
        });
        Button btnCancel;
        btnCancel=(Button) dialog.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}