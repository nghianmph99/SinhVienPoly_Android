package com.lucifer.QLSV_Poly_AndroidNC.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.lucifer.QLSV_Poly_AndroidNC.R;
import com.lucifer.QLSV_Poly_AndroidNC.model.Student;

import java.util.List;

/**
 * Created by DELL on 12/14/2017.
 */

public class CustomAdapter extends ArrayAdapter {

    private Context context;
    private int resoure;
    private List<Student> listStudent;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resoure = resource;
        this.listStudent = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_student,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.tvId = convertView.findViewById(R.id.tv_id);
            viewHolder.tvName = convertView.findViewById(R.id.tv_name);
            viewHolder.tvPhoneNumber = convertView.findViewById(R.id.tv_phone_number);
            viewHolder.tvEmail = convertView.findViewById(R.id.tv_email);
            viewHolder.tvAddress = convertView.findViewById(R.id.tv_address);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Student student = listStudent.get(position);
        viewHolder.tvId.setText(String.valueOf(student.getmID()));
        viewHolder.tvName.setText(student.getmName());
        viewHolder.tvAddress.setText(student.getmAddress());
        viewHolder.tvEmail.setText(student.getmEmail());
        viewHolder.tvPhoneNumber.setText(student.getmNumber());

        return convertView;
    }

    public class ViewHolder{
        private TextView tvId;
        private TextView tvName;
        private TextView tvAddress;
        private TextView tvEmail;
        private TextView tvPhoneNumber;
    }
}
