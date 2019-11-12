package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;

public class HomeFragment extends Fragment {

    CardView cv2,cv3,cv4,cv5,cv6;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
            cv2=root.findViewById(R.id.cv2);
            cv3=root.findViewById(R.id.cv3);
            cv4=root.findViewById(R.id.cv4);
            cv5=root.findViewById(R.id.cv5);
            cv6=root.findViewById(R.id.cv6);
            cv2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i2= new Intent(getActivity(),home_nav.class);
                    startActivity(i2);
                }
            });
            cv3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i2= new Intent(getActivity(),home_nav.class);
                    startActivity(i2);
                }
            });
            cv4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i2= new Intent(getActivity(),home_nav.class);
                    startActivity(i2);
                }
            });
            cv5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i2= new Intent(getActivity(),home_nav.class);
                    startActivity(i2);

                }
            });
            cv6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = "http://lpueats.blogspot.com";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            });
        return root;
        }
    }
