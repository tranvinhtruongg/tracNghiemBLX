package vn.edu.tdmu.tranvinhtruong.tracnghiemblx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.tdmu.tranvinhtruong.tracnghiemblx.Question.QuestionDTO;

public class CheckAdapter extends BaseAdapter {
    ArrayList lsData;
    LayoutInflater inflater;

    public CheckAdapter(ArrayList lsData, Context context){
        this.lsData=lsData;
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return lsData.size();
    }

    @Override
    public Object getItem(int position) {
        return lsData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        QuestionDTO data=(QuestionDTO) getItem(position);
        ViewHolder holder;
        if(convertView==null){
            holder=new ViewHolder();
            convertView=inflater.inflate(R.layout.item_gridview_ans,null);
            holder.txtCau=(TextView) convertView.findViewById(R.id.txtCau);
            holder.txtAns=(TextView) convertView.findViewById(R.id.txtAns);
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder) convertView.getTag();

        }
        int i=position+1;
        holder.txtCau.setText("Câu"+i+":   ");
        holder.txtAns.setText(data.getTraloi());
        return convertView;

    }
    private static class ViewHolder{
        TextView txtCau,txtAns;
    }
}
