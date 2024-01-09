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

public class FirstFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    ImageView fps1img;
    ImageView fps2img;
    ImageView fps3img;
    ImageView fps4img;

    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        fps1img = view.findViewById(R.id.fps1img);
        fps2img = view.findViewById(R.id.fps2img);
        fps3img = view.findViewById(R.id.fps3img);
        fps4img = view.findViewById(R.id.fps4img);

        fps1img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo("doom_eternal");
            }
        });

        fps2img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo("halo_ce");
            }
        });

        fps3img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo("half_life");
            }
        });

        fps4img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo("wolfenstein");
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