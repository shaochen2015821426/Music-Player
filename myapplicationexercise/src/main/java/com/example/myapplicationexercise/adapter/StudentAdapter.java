package com.example.myapplicationexercise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplicationexercise.R;
import com.example.myapplicationexercise.entity.Student;

import java.util.List;

/**
 * Created by shaoyangyang on 2017/12/27.
 */

public class StudentAdapter extends BaseAdapter{

    private Context context;
    private List<Student> studentList = null;

    public StudentAdapter(Context context,List<Student> studentList){
        this.context = context;
        this.studentList = studentList;

    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;
        ViewHolder viewHolder = null;
        if(convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.stud_layout,null);
            viewHolder = new ViewHolder();
            viewHolder.nameTv = view.findViewById(R.id.stud_name_tv);
            viewHolder.ageTv = view.findViewById(R.id.stud_age_tv);
            viewHolder.homeTv = view.findViewById(R.id.stud_home_tv);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.nameTv.setText(studentList.get(position).getName());
        viewHolder.ageTv.setText(studentList.get(position).getAge()+"");
        viewHolder.homeTv.setText(studentList.get(position).getHome());

        return view;
    }

    class ViewHolder{
        TextView nameTv;
        TextView ageTv;
        TextView homeTv;
    }
}
