package vn.edu.tdmu.tranvinhtruong.tracnghiemblx;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.tdmu.tranvinhtruong.tracnghiemblx.Question.QuestionDTO;
import vn.edu.tdmu.tranvinhtruong.tracnghiemblx.slide.ScreenSlidePagerActivity;

public class DoneActivity extends AppCompatActivity {
ArrayList<QuestionDTO>arrBegin=new ArrayList<>();
int numTrue=0;
int numFalse=0;
TextView tvScore,tv_Finish,tv_Clock;

    private ViewPager2 viewPager;
TextView tvTrue,tvFalse,tvDiem;
private FragmentTransaction transaction;
ArrayList<QuestionDTO>listQuestion;
    private int checkAns=0;
    ScreenSlidePagerActivity.CounterClass timer;
Button btnXemlai,btnLamtiep,btnThoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);

        Intent intent= getIntent();
        arrBegin= (ArrayList<QuestionDTO>) intent.getExtras().getSerializable("listQues");
        begin();
        checkResult();
        if(numTrue<=21){
            tvDiem.setText("Bạn đã thi trượt");
        }else {
            tvDiem.setText("Bạn đã thi Đậu");
        }

        tvTrue.setText("Số câu trả lời đúng "+numTrue);
        tvFalse.setText("Số câu trả lời sai "+numFalse);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notify.exit(DoneActivity.this);
            }
        });
        btnLamtiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ScreenSlidePagerActivity.class);
                intent.putExtra("listQues",listQuestion);
                startActivity(intent);
            }
        });
        btnXemlai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


              finish();


            }
        });
    }
    public void begin(){
        tvTrue=(TextView) findViewById(R.id.tvTrue);
        tvFalse=(TextView) findViewById(R.id.tvFalse);
        tvDiem=(TextView) findViewById(R.id.tvDiem);
        btnXemlai=(Button) findViewById(R.id.btnXemlai);
        btnLamtiep=(Button) findViewById(R.id.btnLamtiep);
        btnThoat=(Button) findViewById(R.id.btnThoat);
    }
    public void checkResult(){
        for(int i=0;i< arrBegin.size();i++){
            if(arrBegin.get(i).getDA().equals(arrBegin.get(i).getTraloi())==true){
                numTrue++;
            }
            else numFalse++;
        }
    }
    public ArrayList<QuestionDTO> listQuestion() {
        return listQuestion;
    }
    public void result(){
        checkAns=1;
        if(viewPager.getCurrentItem()>=5){
            viewPager.setCurrentItem(viewPager.getCurrentItem()-4);
        }else if(viewPager.getCurrentItem()<=5){
            viewPager.setCurrentItem(viewPager.getCurrentItem()+4);
        }
        tvScore.setVisibility(View.VISIBLE);
        tv_Finish.setVisibility(View.GONE);

    }
}