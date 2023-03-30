package vn.edu.tdmu.tranvinhtruong.tracnghiemblx.Question;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import vn.edu.tdmu.tranvinhtruong.tracnghiemblx.MainActivity;
import vn.edu.tdmu.tranvinhtruong.tracnghiemblx.R;


public class SearchQuesFragment extends Fragment {
    ListView lvQuestion;
    QuestionDAO questionDAO;
    QuestionAdapter adapter;
    EditText edtSearch;

    public SearchQuesFragment(){
        // Required empty public constructor
    }
    public void begin(){
        lvQuestion=(ListView) getActivity().findViewById(R.id.lvQuestion);
        edtSearch=(EditText)getActivity().findViewById(R.id.edtSearch);
        /////////

        //DBHelper dbHelper =new DBHelper(getActivity());
        questionDAO =new QuestionDAO(new DBHelper(getActivity()));
        //questionDAO =new QuestionDAO((getActivity());
        /////////
        listCursor(questionDAO.getSearchQuestion(edtSearch.getText().toString()));
    }
    public void listCursor(Cursor cursor){
        adapter=new QuestionAdapter(getActivity(),cursor,true);
        lvQuestion.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Tìm kiếm");
        return inflater.inflate(R.layout.fragment_search_ques, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        begin();

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                listCursor(questionDAO.getSearchQuestion(edtSearch.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}