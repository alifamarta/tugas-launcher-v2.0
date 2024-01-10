package com.helloworld.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.helloworld.R;
import com.helloworld.activity.PlayerActivity;

public class SecondFragment extends Fragment {
    ImageView rpg1img;
    ImageView rpg2img;
    ImageView rpg3img;
    ImageView rpg4img;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    
    private String mParam1;
    private String mParam2;

    public SecondFragment() {
        // Required empty public constructor
    }
    
    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        rpg1img = view.findViewById(R.id.rpg1img);
        rpg2img = view.findViewById(R.id.rpg2img);
        rpg3img = view.findViewById(R.id.rpg3img);
        rpg4img = view.findViewById(R.id.rpg4img);

        rpg1img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo("ff7remake");
            }
        });

        rpg2img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo("persona4");
            }
        });

        rpg3img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo("fallout3");
            }
        });

        rpg4img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo("baldursgate3");
            }
        });

        return view;
    }

    private void playVideo(String videoName) {
        String videoPath = "android.resource://" + requireActivity().getPackageName() + "/raw/" + videoName;
        Uri videoUri = Uri.parse(videoPath);

        Intent intent = new Intent(requireContext(), PlayerActivity.class);
        intent.putExtra("VIDEO_URI", videoUri.toString());
        startActivity(intent);
    }
}