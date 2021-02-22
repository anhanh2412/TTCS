package com.example.tracnghiem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CustomGridView customGridView;
    ArrayList<Contact> arrayList;
    GridView gridView;
    public static final String name = "Chủ Đề";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        setGridView();
    }


    void anhXa(){
        arrayList = new ArrayList<>();
        customGridView = new CustomGridView(MainActivity.this, R.layout.activity_main, arrayList);
        gridView = findViewById(R.id.gridView);
        addDL();
        gridView.setAdapter(customGridView);
    }

    void addDL(){
        Contact contact = new Contact("Animal", R.drawable.animal);
        Contact contact1 = new Contact("Vegetable", R.drawable.vegetable);
        Contact contact2 = new Contact("Fruit", R.drawable.fruit);
        Contact contact3 = new Contact("National", R.drawable.national);
        Contact contact4 = new Contact("Math", R.drawable.montoan);
        Contact contact5 = new Contact("Test", R.drawable.test);

        arrayList.add(contact);
        arrayList.add(contact1);
        arrayList.add(contact2);
        arrayList.add(contact3);
        arrayList.add(contact4);
        arrayList.add(contact5);
    }

    public void setGridView(){
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra(name, arrayList.get(position).getName());
                startActivity(intent);
            }
        });
    }
}
