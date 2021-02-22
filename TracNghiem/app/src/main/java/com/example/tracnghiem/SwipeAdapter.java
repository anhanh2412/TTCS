package com.example.tracnghiem;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class SwipeAdapter extends FragmentPagerAdapter {
    ArrayList<ContactCH> arrayList;

    public SwipeAdapter(@NonNull FragmentManager fm, int behavior, ArrayList<ContactCH> arrayList) {
        super(fm, behavior);
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        ContactCH a = arrayList.get(position);
        Fragment pageFragment = new FragmentPage();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position+1);
        bundle.putString("question", a.getQuestion());
        bundle.putString("A", a.getA());
        bundle.putString("B", a.getB());
        bundle.putString("C", a.getC());
        bundle.putString("D", a.getD());
        bundle.putString("answer", a.getAnswer());
        pageFragment.setArguments(bundle);
        return pageFragment;
    }

    @Override
    public int getCount() {
        return 60;
    }
}
