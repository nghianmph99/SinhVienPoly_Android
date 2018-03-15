package com.lucifer.QLSV_Poly_AndroidNC;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.lucifer.QLSV_Poly_AndroidNC.Database.DBManager;
import com.lucifer.QLSV_Poly_AndroidNC.adapter.CustomAdapter;
import com.lucifer.QLSV_Poly_AndroidNC.model.Student;

import java.util.List;

public class MainStudentActivity extends AppCompatActivity {
    private EditText edtName;
    private EditText edtAddress;
    private EditText edtPhoneNumber;
    private EditText edtEmail;
    private EditText edtId;
    private Button btnSave;
    private Button btnUpdate;
    private ListView lvStudent;
    private DBManager dbManager;
    private CustomAdapter customAdapter;
    private List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        dbManager = new DBManager(this);
        initWidget();
        studentList = dbManager.getAllStudent();
        setAdapter();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student = createStudent();
                if (student != null) {
                    dbManager.addStudent(student);
                }
                updateListStudent();
                setAdapter();
            }
        });

        lvStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Student student = studentList.get(position);
                edtId.setText(String.valueOf(student.getmID()));
                edtName.setText(student.getmName());
                edtAddress.setText(student.getmAddress());
                edtEmail.setText(student.getmEmail());
                edtPhoneNumber.setText(student.getmNumber());
                btnSave.setEnabled(false);
                btnUpdate.setEnabled(true);
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student = new Student();
                student.setmID(Integer.parseInt(String.valueOf(edtId.getText())));
                student.setmName(edtName.getText() + "");
                student.setmAddress(edtAddress.getText() + "");
                student.setmEmail(edtEmail.getText() + "");
                student.setmNumber(edtPhoneNumber.getText() + "");
                int result = dbManager.updateStudent(student);
                if (result > 0) {
                    updateListStudent();
                }
                btnSave.setEnabled(true);
                btnUpdate.setEnabled(false);
            }
        });
        lvStudent.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                Student student = studentList.get(position);
                int result = dbManager.deleteStudent(student.getmID());
                if (result > 0) {
                    Toast.makeText(MainStudentActivity.this, "Delete successfuly", Toast.LENGTH_SHORT).show();
                    updateListStudent();
                } else {
                    Toast.makeText(MainStudentActivity.this, "Delete fail", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }

    private Student createStudent() {
        String name = edtName.getText().toString();
        String address = String.valueOf(edtAddress.getText());
        String phoneNumber = edtPhoneNumber.getText() + "";
        String email = edtEmail.getText().toString();

        Student student = new Student(name, address, phoneNumber, email);
        return student;
    }

    private void initWidget() {
        edtName = findViewById(R.id.edt_name);
        edtAddress = findViewById(R.id.edt_address);
        edtPhoneNumber = findViewById(R.id.edt_number);
        edtEmail = findViewById(R.id.edt_email);
        btnSave = findViewById(R.id.btnSave);
        lvStudent = findViewById(R.id.lvStudent);
        edtId = findViewById(R.id.edt_id);
        btnUpdate = findViewById(R.id.btnUpdate);
    }

    private void setAdapter() {
        if (customAdapter == null) {
            customAdapter = new CustomAdapter(this, R.layout.item_list_student, studentList);
            lvStudent.setAdapter(customAdapter);
        } else {
            customAdapter.notifyDataSetChanged();
            lvStudent.setSelection(customAdapter.getCount() - 1);
        }
    }

    public void updateListStudent() {
        studentList.clear();
        studentList.addAll(dbManager.getAllStudent());
        if (customAdapter != null) {
            customAdapter.notifyDataSetChanged();
        }
    }
}