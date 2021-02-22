package com.example.tracnghiem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.android.volley.Request.Method.GET;

public class Main2Activity extends AppCompatActivity {
    String nameCD;
    String url = "http://192.168.90.2:8080/androidwebservice/getquestion.php";
    ArrayList<ContactCH> arrayList;
    Button bt_start;
    String data = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getCategory();
        anhXa();
        parameter();
        //getData(url);
        eventBT_start();
    }
    public void getCategory(){
        Intent intent = getIntent();
        nameCD = intent.getStringExtra(MainActivity.name);
    }

    public void anhXa(){
        bt_start = findViewById(R.id.bt_start);
        arrayList = new ArrayList<>();
    }

    public int category(){
        if(nameCD.equals("Animal")) return 1;
        else if(nameCD.equals("Vegetable")) return 2;
        else if(nameCD.equals("Fruit")) return 3;
        else if(nameCD.equals("National")) return 4;
        else if(nameCD.equals("Math")) return 5;
        else if(nameCD.equals("Test")) return 6;
        return 0;
    }

    void parameter(){
       RequestQueue requestQueue =  Volley.newRequestQueue(Main2Activity.this);
       StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
           @Override
           public void onResponse(String response) {
                data += String.valueOf(response);
           }
       },
               new Response.ErrorListener() {
                   @Override
                   public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Main2Activity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                   }
               }
       ){
           @Override
           protected Map<String, String> getParams() throws AuthFailureError {
               HashMap<String,String> param = new HashMap<>();
               param.put("cate", String.valueOf(category()));
               return param;
           }
       };
       requestQueue.add(stringRequest);
    }

    void eventBT_start(){
        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(data.length() == 2) {
                    Toast.makeText(getApplicationContext(), "Khong co du lieu", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                    intent.putExtra("data", data);
                    FragmentPage.diem = 0;
                    startActivity(intent);
                }
            }
        });
    }
}
