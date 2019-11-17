package com.younsle.project7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY_SIMPLE_DATA = "data";
    public static final int REQUEST_CODE_MENU = 101;
    public static final int REQUEST_CODE_MENU2 = 102;
    public static final int REQUEST_CODE_MENU3 = 103;
    public static final int REQUEST_CODE_MENU4 = 104;
    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        Button btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(this);
        Button btn4 = findViewById(R.id.button4);
        btn4.setOnClickListener(this);
        textView = findViewById(R.id.textView2);

        Intent intent = getIntent();
        setResult(RESULT_OK, intent);
        processIntent(intent);

//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent1 = new Intent(getApplicationContext(),Menu2Activity.class);
//                startActivityForResult(intent1, REQUEST_CODE_MENU);
//            }
//        });
//
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent2 = new Intent(getApplicationContext(),Menu2Activity.class);
//                startActivityForResult(intent2, REQUEST_CODE_MENU3);
//            }
//        });
//
//        btn4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent3 = new Intent(getApplicationContext(),Menu2Activity.class);
//                startActivityForResult(intent3, REQUEST_CODE_MENU4);
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.button2:
                Intent intent1 = new Intent(getApplicationContext(),Menu2Activity.class);
//                intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivityForResult(intent1, REQUEST_CODE_MENU2);
//                finish();
                break;
            case R.id.button3:
                Intent intent2 = new Intent(getApplicationContext(), Menu3Activity.class);
//                intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                intent2.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivityForResult(intent2, REQUEST_CODE_MENU3);
//                finish();
                break;
            case R.id.button4:
                Intent intent3 = new Intent(getApplicationContext(), Menu4Activity.class);
//                intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                intent3.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivityForResult(intent3, REQUEST_CODE_MENU4);
//                finish();
                break;
            default:
                break;
        }
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_MENU2) {
            Toast.makeText(getApplicationContext(), "요청코드:"+requestCode+", 결과코드: " +resultCode, Toast.LENGTH_LONG).show();
            if (resultCode == RESULT_OK) {
                assert data != null;
                String name = data.getStringExtra("name");
                Toast.makeText(getApplicationContext(), "Data name :" + name,
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    private void processIntent(Intent intent) {
        if(intent == null) {
        } else {
            Bundle bundle = intent.getExtras();
            assert bundle != null;
            simpleData data = bundle.getParcelable(KEY_SIMPLE_DATA);
            textView.setText(String.format("이름: %s", data.identification));
        }
    }
}

