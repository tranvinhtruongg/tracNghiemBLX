package vn.edu.tdmu.tranvinhtruong.tracnghiemblx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.tdmu.tranvinhtruong.tracnghiemblx.Question.QuestionDTO;

public class DoneActivity extends AppCompatActivity {
ArrayList<QuestionDTO>arrBegin=new ArrayList<>();
int numTrue=0;
int numFalse=0;
int numDiem=0;
TextView tvTrue,tvFalse,tvDiem;
Button btnXemlai,btnLamlai,btnDeTT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);

        Intent intent= getIntent();
        arrBegin= (ArrayList<QuestionDTO>) intent.getExtras().getSerializable("listQues");
        begin();
        checkResult();
        if(numTrue<=23){
            tvDiem.setText("Bạn đã thi trượt");
        }else {
            tvDiem.setText("Bạn đã thi Đậu");
        }

        tvTrue.setText("Số câu trả lời đúng "+numTrue);
        tvFalse.setText("Số câu trả lời sai "+numFalse);


    }
    public void begin(){
        tvTrue=(TextView) findViewById(R.id.tvTrue);
        tvFalse=(TextView) findViewById(R.id.tvFalse);
        tvDiem=(TextView) findViewById(R.id.tvDiem);
        btnXemlai=(Button) findViewById(R.id.btnXemlai);
        btnLamlai=(Button) findViewById(R.id.btnLamlai);
        btnDeTT=(Button) findViewById(R.id.btnDeTT);
    }
    public void checkResult(){
        for(int i=0;i< arrBegin.size();i++){
            if(arrBegin.get(i).getDA().equals(arrBegin.get(i).getTraloi())==true){
                numTrue++;
//            }else if(arrBegin.get(i).getDL().equals()){
//                numTrue++;
            }
            else numFalse++;
        }
    }
}