package vn.edu.tdmu.tranvinhtruong.tracnghiemblx.slide;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import vn.edu.tdmu.tranvinhtruong.tracnghiemblx.Question.QuestionDTO;
import vn.edu.tdmu.tranvinhtruong.tracnghiemblx.R;


public class ScreenSlidePageFragment extends Fragment {
    ScreenSlidePagerActivity screenSlidePagerActivity;
    ArrayList<QuestionDTO> QuestionDTOS=new ArrayList<QuestionDTO>();
    private int pageNumber;
    public static String ARG_Page="page";
    TextView tv_NumberQuestion, tv_Question;
    RadioGroup rg_GroupAnswer;
    RadioButton rad_Ans1, rad_Ans2, rad_Ans3, rad_Ans4;
    ImageView img_Question;
    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup viewGroup=(ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);
        tv_NumberQuestion = viewGroup.findViewById(R.id.tv_NumberQuestion);
        tv_Question = viewGroup.findViewById(R.id.tv_Question);
        img_Question=viewGroup.findViewById(R.id.img_Question);

        rad_Ans1 = viewGroup.findViewById(R.id.rad_Ans1);
        rad_Ans2 = viewGroup.findViewById(R.id.rad_Ans2);
        rad_Ans3 = viewGroup.findViewById(R.id.rad_Ans3);
        rad_Ans4 = viewGroup.findViewById(R.id.rad_Ans4);
        rg_GroupAnswer =viewGroup.findViewById(R.id.rg_GroupAnswer);

    return viewGroup;



    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            QuestionDTOS = screenSlidePagerActivity.getQuestion();
            pageNumber=getArguments().getInt(ARG_Page);
        }catch (NullPointerException ex){
           ex.printStackTrace();
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
        tv_NumberQuestion.setText(String.valueOf(pageNumber + 1));
        tv_Question.setText(QuestionDTOS.get(pageNumber).getQuestion());
        rad_Ans1.setText(QuestionDTOS.get(pageNumber).getDA1());
        rad_Ans2.setText(QuestionDTOS.get(pageNumber).getDA2());
        rad_Ans3.setText(QuestionDTOS.get(pageNumber).getDA3());
        rad_Ans4.setText(QuestionDTOS.get(pageNumber).getDA4());


    }
}
