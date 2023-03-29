package vn.edu.tdmu.tranvinhtruong.tracnghiemblx.slide;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import vn.edu.tdmu.tranvinhtruong.tracnghiemblx.Question.QuestionDAO;
import vn.edu.tdmu.tranvinhtruong.tracnghiemblx.Question.QuestionDTO;
import vn.edu.tdmu.tranvinhtruong.tracnghiemblx.R;


public class ScreenSlidePageFragment extends Fragment {
    ScreenSlidePagerActivity screenSlidePagerActivity;
    ArrayList<QuestionDTO> questionDTOS=new ArrayList<>();

    private int pageNumber;
    private static String ARG_Page="page";
    TextView tv_NumberQuestion, tv_Question;
    RadioGroup rg_GroupAnswer;
    RadioButton rad_Ans1, rad_Ans2, rad_Ans3, rad_Ans4;
    ImageView img_Question;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup viewGroup=(ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);

        tv_NumberQuestion=viewGroup.findViewById(R.id.tv_NumberQuestion);
        tv_Question=viewGroup.findViewById(R.id.tv_Question);
        img_Question=viewGroup.findViewById(R.id.img_Question);
        rg_GroupAnswer=viewGroup.findViewById(R.id.rg_GroupAnswer);
        rad_Ans1=viewGroup.findViewById(R.id.rad_Ans1);
        rad_Ans2=viewGroup.findViewById(R.id.rad_Ans2);
        rad_Ans3=viewGroup.findViewById(R.id.rad_Ans3);
        rad_Ans4=viewGroup.findViewById(R.id.rad_Ans4);
        return viewGroup;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            screenSlidePagerActivity= (ScreenSlidePagerActivity) getActivity();
            pageNumber=getArguments().getInt(ARG_Page);
            questionDTOS=screenSlidePagerActivity.listQuestion();
        }catch (Exception ex){
          Toast.makeText(getContext(),"Lỗi",Toast.LENGTH_LONG).show();
        }


    }

    public static ScreenSlidePageFragment create(int pageNumber) {
        ScreenSlidePageFragment screenSlidePageFragment = new ScreenSlidePageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_Page,pageNumber);
        screenSlidePageFragment.setArguments(bundle);
        return screenSlidePageFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tv_NumberQuestion.setText("Câu"+" "+String.valueOf(pageNumber+1));
        tv_Question.setText(questionDTOS.get(pageNumber).getQuestion());



        rad_Ans1.setText(getItem(pageNumber).getDA1());
        rad_Ans2.setText(getItem(pageNumber).getDA2());
        rad_Ans3.setText(getItem(pageNumber).getDA3());
        if(rad_Ans3.getText().toString().isEmpty())
        {
            rad_Ans3.setVisibility(View.INVISIBLE);
        }
        rad_Ans4.setText(getItem(pageNumber).getDA4());
        if(rad_Ans4.getText().toString().isEmpty())
        {
            rad_Ans4.setVisibility(View.INVISIBLE);
        }
        rg_GroupAnswer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                getItem(pageNumber).choiceID=checkedId;
                getItem(pageNumber).setTraloi(getChoiceIDFromID(checkedId));
            }
        });
    }
    public QuestionDTO getItem(int position){
        return questionDTOS.get(position);
    }
    private String getChoiceIDFromID(int ID){
        if(ID==R.id.rad_Ans1){
            return "1";
        }else if(ID==R.id.rad_Ans2){
            return "2";
        }else if(ID==R.id.rad_Ans3){
            return "3";
        }else if(ID==R.id.rad_Ans4){
            return "4";
        }else return "";
    }
}
