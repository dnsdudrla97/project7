package com.younsle.project7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 101;
    public static final String KEY_SIMPLE_DATA = "data";
    private boolean saveLoginData;
    private SharedPreferences pref;
    private String id;
    private String pwd;
    EditText idText;
    EditText pwText;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //설정 값 불러오기
        pref = getSharedPreferences("pref", MODE_PRIVATE);
        restoreState();

        Button button = findViewById(R.id.button);
        idText = findViewById(R.id.iD);
        pwText = findViewById(R.id.passWord);
        checkBox = findViewById(R.id.checkBox);
        // 로그인 기록 있을시 가져오기 ㅇㅇ
        if (saveLoginData) {
            idText.setText(id);
            pwText.setText(pwd);
            checkBox.setChecked(saveLoginData);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //로그인 검증
                if(pwText.getText().toString().length() == 0 || idText.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(),"PW를 입력하세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                //로그인 성공시 저장 처리
                saveState();

                //로그인 성공 아이디 데이터 전송
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                simpleData data = new simpleData(idText.getText().toString());
                intent.putExtra(KEY_SIMPLE_DATA, data);
//                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivityForResult(intent, REQUEST_CODE_MENU);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_MENU) {
            Toast.makeText(getApplicationContext(), "onActivityResult Method Call. 요청코드: " + requestCode + ". 결과 코드: " +
                    resultCode, Toast.LENGTH_LONG).show();
            pref = getSharedPreferences("pref", MODE_PRIVATE);
            restoreState();

            if(resultCode == RESULT_OK) {
                Toast.makeText(getApplicationContext(), "onActivityResult Method Call. 요청코드: " + requestCode + ". 결과 코드: " +
                        resultCode, Toast.LENGTH_LONG).show();

            }
            if(resultCode == 700) {
                Toast.makeText(getApplicationContext(), "onActivityResult Method Call. 요청코드: " + requestCode + ". 결과 코드: " +
                        resultCode, Toast.LENGTH_LONG).show();
            }
        }
    }

    //데이터 저장
    private void saveState() {
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("SAVE_LOGIN_DATA", checkBox.isChecked());
        editor.putString("ID", idText.getText().toString().trim());
        editor.putString("PW", pwText.getText().toString().trim());
        editor.apply();
    }
    //데이터 복구
    private void restoreState() {
        saveLoginData = pref.getBoolean("SAVE_LOGIN_DATA", false);
        id = pref.getString("ID", "");
        pwd = pref.getString("PWD", "");
    }
}
