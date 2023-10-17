package com.rizka.f55122003;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtWidht, edtHeight, edtLenght;
    private Button btnCalculate;
    private TextView tvResult;
    private static final String STATE_RESULT = "State_Result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtHeight = findViewById(R.id.edt_height);
        edtLenght = findViewById(R.id.edt_length);
        edtWidht = findViewById(R.id.edt_width);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);
        btnCalculate.setOnClickListener(this);
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvResult.getText().toString());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() ==  R.id.btn_calculate){
            String inputLenght = edtLenght.getText(). toString(). trim();
            String inputHeight = edtHeight.getText(). toString(). trim();
            String inputWidht = edtWidht.getText(). toString(). trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(inputLenght)) {
                isEmptyFields = true;
                edtLenght.setError("FIeld ini tidak boleh kosng");
            }
            if (TextUtils.isEmpty(inputWidht)) {
                isEmptyFields = true;
                edtWidht.setError("FIeld ini tidak boleh kosng");
            }
            if (TextUtils.isEmpty(inputHeight)) {
                isEmptyFields = true;
                edtHeight.setError("FIeld ini tidak boleh kosng");
            }
            if (!isEmptyFields) {
                double volume = Double.parseDouble(inputLenght) * Double.parseDouble(inputWidht) * Double.parseDouble(inputHeight);
                tvResult.setText(String.valueOf(volume));
            }
        }
    }
}