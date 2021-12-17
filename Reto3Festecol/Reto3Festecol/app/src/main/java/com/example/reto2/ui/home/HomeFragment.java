package com.example.reto2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.reto2.R;
import com.example.reto2.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {


    private FragmentHomeBinding binding;
    private ImageView th1, th2, th3;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        th1 = (ImageView) binding.imgh1;
        th2 = (ImageView) binding.imgh2;
        th3 = (ImageView) binding.imgh3;

        th1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "app 1 en Construcción", Toast.LENGTH_SHORT).show();
            }
        });
        th2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "app 2 en Construcción", Toast.LENGTH_SHORT).show();
            }
        });
        th3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "app 3 en Construcción", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}