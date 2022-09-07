package com.example.dpq_thdd_baith1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    float W,H,BMI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextInputLayout HEdit = (TextInputLayout)findViewById(R.id.HeightInputText);
        TextInputLayout WEdit = (TextInputLayout)findViewById(R.id.WeightInputText);
        TextView Resulit = (TextView)findViewById((R.id.ResultTextView));
        TextView BMIText = (TextView)findViewById(R.id.BMTTextView);

        Button button = (Button) findViewById(R.id.btn_Caculate);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(WEdit.getEditText().getText().toString().isEmpty() || HEdit.getEditText().getText().toString().isEmpty()){
                    Resulit.setText("Số Liệu Rỗng");
                }
                else {
                    W = Float.parseFloat(WEdit.getEditText().getText().toString());
                    H = Float.parseFloat(HEdit.getEditText().getText().toString());
                    Log.d("BT","BT");

                    BMI = W/((H * H)/10000);

                    BMIText.setText("BMI của bạn = " + String.valueOf(BMI));
                    if(BMI < 18){
                        Resulit.setText("Người Gầy");
                    }
                    else if(BMI < 24.9){
                        Resulit.setText("Người Bình Thường");
                    }
                    else if(BMI < 29.9){
                        Resulit.setText("Người béo phì độ I");
                    }
                    else if(BMI < 34.9){
                        Resulit.setText("Người béo phì độ II");
                    }
                    else {
                        Resulit.setText("Người béo phì");
                    }
                }

            }
        });
    }
}