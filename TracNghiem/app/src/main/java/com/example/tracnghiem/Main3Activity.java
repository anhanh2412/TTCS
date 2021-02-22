package com.example.tracnghiem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    ArrayList<ContactCH> arrayList = new ArrayList<>();
    TextView time, diem,text_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        try {
            readData();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ViewPager view_pager = findViewById(R.id.view_pager);
        //view_pager.setOffscreenPageLimit(1);
        SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager(),0,arrayList);
        view_pager.setAdapter(swipeAdapter);
        view_pager.setCurrentItem(0);
        setactionBar();
    }
    void anhXa(){
        time = findViewById(R.id.time);
        diem = findViewById(R.id.diem);
        text_back = findViewById(R.id.text_back);
    }

    void readData() throws JSONException {
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        JSONArray response = new JSONArray(data);
        for(int i = 0; i<response.length(); i++){
            Log.d("tag: ", ""+i);
            try {
                JSONObject object = response.getJSONObject(i);
                ContactCH ch = new ContactCH(object.getString("CauHoi"), object.getString("DA"), object.getString("DB"), object.getString("DC"), object.getString("DD"), object.getString("CauTL"));
                arrayList.add(ch);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    void setactionBar(){
        anhXa();
        countDown();
        eventNopBai();
        eventBack();
    }

    void countDown(){
        long a = 30000000;
        new CountDownTimer(a,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                time.setText(""+(millisUntilFinished/60000)+ ":"+(millisUntilFinished % 60000)/1000);
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(Main3Activity.this, Main4Activity.class);
                startActivity(intent);
            }
        }.start();
    }

    void eventNopBai(){
        diem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogNopBai();
            }
        });
    }

    void eventBack(){
        text_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBack();
            }
        });
    }

    private void dialogNopBai(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Bạn có muốn nộp bài không?");
        builder.setCancelable(true);
        builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Main3Activity.this, Main4Activity.class);
                startActivity(intent);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void dialogBack(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Bạn có muốn về trang chính không?");
        builder.setCancelable(true);
        builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(intent);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
