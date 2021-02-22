package com.example.tracnghiem;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class FragmentPage extends Fragment {
    static int diem = 0;
    static int temp = 0;
    int position;
    String cauhoi, a, b, c, d, answer;
    TextView text_ch;
    EditText text_A;
    EditText text_B;
    EditText text_C;
    EditText text_D;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        getData();
        view = inflater.inflate(R.layout.page_fragment, container, false);
        anhXa(view);
        eventDiem();
        return view;
       // return super.onCreateView(inflater, container, savedInstanceState);
    }
    void getData(){
        Bundle bundle = getArguments();
        position = bundle.getInt("position");
        cauhoi = bundle.getString("question");
        a = bundle.getString("A");
        b = bundle.getString("B");
        c = bundle.getString("C");
        d = bundle.getString("D");
        answer = bundle.getString("answer");
    }
    void anhXa(View view){
        text_ch = view.findViewById(R.id.text_ch);
        text_A = view.findViewById(R.id.text_A);
        text_B = view.findViewById(R.id.text_B);
        text_C = view.findViewById(R.id.text_C);
        text_D = view.findViewById(R.id.text_D);
        text_ch.setText("Câu hỏi "+position+": "+cauhoi);
        text_A.setText("A. "+a);
        text_B.setText("B. "+b);
        text_C.setText("C. "+c);
        text_D.setText("D. "+d);

    }

    void eventDiem(){
        text_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = 0;
                if(answer.equals(a)){
                   temp++;
                }
                text_A.setBackgroundResource(R.drawable.chon_edittext);
                text_B.setBackgroundResource(R.drawable.botron_edittext);
                text_C.setBackgroundResource(R.drawable.botron_edittext);
                text_D.setBackgroundResource(R.drawable.botron_edittext);
            }
        });

        text_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = 0;
                if(answer.equals(b)){
                   temp++;
                }
                text_B.setBackgroundResource(R.drawable.chon_edittext);
                text_A.setBackgroundResource(R.drawable.botron_edittext);
                text_C.setBackgroundResource(R.drawable.botron_edittext);
                text_D.setBackgroundResource(R.drawable.botron_edittext);
            }
        });

        text_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = 0;
                if(answer.equals(c)){
                    temp++;
                }
                text_C.setBackgroundResource(R.drawable.chon_edittext);
                text_B.setBackgroundResource(R.drawable.botron_edittext);
                text_A.setBackgroundResource(R.drawable.botron_edittext);
                text_D.setBackgroundResource(R.drawable.botron_edittext);
            }
        });

        text_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = 0;
                if(answer.equals(d)){
                   temp++;
                }
                text_D.setBackgroundResource(R.drawable.chon_edittext);
                text_B.setBackgroundResource(R.drawable.botron_edittext);
                text_C.setBackgroundResource(R.drawable.botron_edittext);
                text_A.setBackgroundResource(R.drawable.botron_edittext);
            }
        });
        diem += temp;
        temp = 0;
    }
}
