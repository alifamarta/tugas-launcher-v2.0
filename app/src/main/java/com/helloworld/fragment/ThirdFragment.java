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

public class ThirdFragment extends Fragment {
    
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    
    private String mParam1;
    private String mParam2;
    
    ImageView fg1img;
    ImageView fg2img;
    ImageView fg3img;
    ImageView fg4img;

    public ThirdFragment() {
        // Required empty public constructor
    }
    
    public static ThirdFragment newInstance(String param1, String param2) {
        ThirdFragment fragment = new ThirdFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        fg1img = view.findViewById(R.id.fg1img);
        fg2img = view.findViewById(R.id.fg2img);
        fg3img = view.findViewById(R.id.fg3img);
        fg4img = view.findViewById(R.id.fg4img);

        fg1img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo("streetfighter6");
            }
        });

        fg2img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo("ggst");
            }
        });

        fg3img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo("tekken8");
            }
        });

        fg4img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo("mortalkombat1");
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