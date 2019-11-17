package com.younsle.project7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Menu2Activity extends AppCompatActivity implements View.OnClickListener {
    public static final int REQUEST_CODE_MENU = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        Button btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        Button btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(this);


//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.putExtra("name", "이전");
//                setResult(RESULT_OK, intent);
//                finish();
//            }
//        });
//
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                intent.putExtra("name", "로그인으로 이동 됨");
//                startActivityForResult(intent, REQUEST_CODE_MENU);
//
//            }
//        });
//    }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.button3:
                Intent intentHome = new Intent(getApplicationContext(), MainActivity.class);
                intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intentHome.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intentHome);
                finish();
                break;

            case R.id.button2:
//                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
//                startActivity(intent);
                Intent intent = new Intent();
                intent.putExtra("name", "이전");
                setResult(RESULT_OK, intent);
                finish();
                break;
            default:
                break;
        }
    }
}
