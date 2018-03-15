package com.lucifer.QLSV_Poly_AndroidNC;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView ivStudent,ivMap,ivNew,ivSocial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivStudent = findViewById(R.id.ivStudent);
        ivMap = findViewById(R.id.ivMap);
        ivNew = findViewById(R.id.ivNew);
        ivSocial = findViewById(R.id.ivSocial);
        ivStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(MainActivity.this,MainStudentActivity.class);
                startActivity(i2);
            }
        });
        ivNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(MainActivity.this,MainNewActivity.class);
                startActivity(i3);
            }
        });
        ivMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4 = new Intent(MainActivity.this,MainMapActivity.class);
                startActivity(i4);
            }
        });
        ivSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i5 = new Intent(MainActivity.this,MainSocialActivity.class);
                startActivity(i5);
            }
        });
    }
}


