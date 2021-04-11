package com.h.hodu;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import android.os.Bundle;

public class RegisterActivity extends AppCompatActivity {

    private EditText hodu_id;
    private EditText hodu_pass;
    private EditText hodu_repass ;
    private EditText hodu_name;
    private EditText hodu_date ;
    private EditText hodu_phone;
    private Button btn_male;
    private Button btn_female;
    private Button btn_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        hodu_id = (EditText) findViewById(R.id.hodu_id);
        hodu_pass = (EditText) findViewById(R.id.hodu_pass);
        hodu_repass = (EditText) findViewById(R.id.hodu_repass);
        hodu_name = (EditText) findViewById(R.id.hodu_name);
        hodu_date = (EditText) findViewById(R.id.hodu_date);
        hodu_phone = (EditText) findViewById(R.id.hodu_phone);
        btn_male = (Button) findViewById(R.id.btn_male);
        btn_female = (Button) findViewById(R.id.btn_female);
        btn_register = (Button) findViewById(R.id.btn_register);

        // 비밀번호 일치 검사
        hodu_repass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = hodu_pass.getText().toString();
                String confirm = hodu_repass.getText().toString();

                if (password.equals(confirm)) {
                    hodu_pass.setBackgroundColor(Color.GREEN);
                    hodu_repass.setBackgroundColor(Color.GREEN);
                } else {
                    hodu_pass.setBackgroundColor(Color.RED);
                    hodu_repass.setBackgroundColor(Color.RED);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 아이디 입력 확인
                if (hodu_id.getText().toString().length() == 0) {
                    Toast.makeText(RegisterActivity.this, "아이디를 입력하세요.", Toast.LENGTH_SHORT).show();
                    hodu_id.requestFocus();
                    return;
                }

                // 비밀번호 입력 확인
                if (hodu_pass.getText().toString().length() == 0) {
                    Toast.makeText(RegisterActivity.this, "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    hodu_pass.requestFocus();
                    return;
                }

                // 비밀번호 확인 입력 확인
                if (hodu_repass.getText().toString().length() == 0) {
                    Toast.makeText(RegisterActivity.this, "비밀번호를 다시 한번 입력하세요.", Toast.LENGTH_SHORT).show();
                    hodu_repass.requestFocus();
                    return;
                }

                // 비밀번호 일치 확인
                if (!hodu_pass.getText().toString().equals(hodu_repass.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    hodu_pass.setText("");
                    hodu_repass.setText("");
                    hodu_pass.requestFocus();
                    return;
                }

                // 이름 일치 확인
                if (hodu_name.toString().length() == 0) {
                    Toast.makeText(RegisterActivity.this, "이름을 입력하세요.", Toast.LENGTH_SHORT).show();
                    hodu_name.requestFocus();
                    return;
                }

                // 생년월일 일치 확인
                if (hodu_date.toString().length() == 0) {
                    Toast.makeText(RegisterActivity.this, "생년월일을 입력하세요.", Toast.LENGTH_SHORT).show();
                    hodu_date.requestFocus();
                    return;
                }

                // 휴대폰 일치 확인
                if (hodu_phone.toString().length() == 0) {
                    Toast.makeText(RegisterActivity.this, "휴대폰 번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    hodu_phone.requestFocus();
                    return;
                }

                Intent result = new Intent();
                result.putExtra("id", hodu_id.getText().toString());

                // 자신을 호출한 Activity로 데이터를 보낸다.
                setResult(RESULT_OK, result);
                finish();
            }
        });



    }
}
