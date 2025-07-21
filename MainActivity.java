package com.example.simplecalculator;

import static android.graphics.Insets.add;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText f_num, s_num;
    TextView Result_show;
    Button Add, Sub, Mul, Div;
    String n1, n2;
    int res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        f_num = findViewById(R.id.f_num);
        s_num = findViewById(R.id.s_num);
        Result_show = findViewById(R.id.Result_show);
        Add = findViewById(R.id.Add);
        Sub = findViewById(R.id.Sub);
        Mul = findViewById(R.id.Mul);
        Div = findViewById(R.id.Div);


        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum();
            }
        });

        Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sub();
            }
        });

        Mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mul();
            }
        });

        Div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                div();
            }
        });


    }

    private void sum(){

        n1 = f_num.getText().toString();
        n2 = s_num.getText().toString();


        if (!n1.isEmpty() && !n2.isEmpty()){

            res = Integer.parseInt(n1) + Integer.parseInt(n2);
            Result_show.setText(" "+res);

        }else {
            Result_show.setText("Value is empty");
        }

    }

    private void sub(){

        n1 = f_num.getText().toString();
        n2 = s_num.getText().toString();


        if (!n1.isEmpty() && !n2.isEmpty()){

            res = Integer.parseInt(n1) - Integer.parseInt(n2);
            Result_show.setText(" "+res);

        }else {
            Result_show.setText("Value is empty");
        }

    }

    private void mul(){

        n1 = f_num.getText().toString();
        n2 = s_num.getText().toString();


        if (!n1.isEmpty() && !n2.isEmpty()){

            res = Integer.parseInt(n1) * Integer.parseInt(n2);
            Result_show.setText(" "+res);

        }else {
            Result_show.setText("Value is empty");
        }

    }

    private void div(){

        if(!n1.isEmpty() && !n2.isEmpty()){

            n1 = f_num.getText().toString();
            n2 = s_num.getText().toString();

            try {
                res = Integer.parseInt(n1) / Integer.parseInt(n2);
                Result_show.setText(" "+res);
            } catch (ArithmeticException e){
                Result_show.setText(""+e);
            }


        }else {
            Result_show.setText("Value is empty");
        }

    }



}