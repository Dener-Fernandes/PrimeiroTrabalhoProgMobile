package com.example.primeirotrabalho;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class NumbersFragment extends Fragment {
    private ImageButton buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix;
    private MediaPlayer mediaplayer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_numbers, container, false);

        buttonOne = view.findViewById(R.id.buttonOne);
        buttonTwo = view.findViewById(R.id.buttonTwo);
        buttonThree = view.findViewById(R.id.buttonThree);
        buttonFour = view.findViewById(R.id.buttonFour);
        buttonFive = view.findViewById(R.id.buttonFive);
        buttonSix = view.findViewById(R.id.buttonSix);

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaplayer = MediaPlayer.create(getContext(), R.raw.one);
                execute();
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaplayer = MediaPlayer.create(getContext(), R.raw.two);
                execute();
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaplayer = MediaPlayer.create(getContext(), R.raw.three);
                execute();
            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaplayer = MediaPlayer.create(getContext(), R.raw.four);
                execute();
            }
        });

        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaplayer = MediaPlayer.create(getContext(), R.raw.five);
                execute();
            }
        });

        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaplayer = MediaPlayer.create(getContext(), R.raw.six);
                execute();
            }
        });


        return view;
    }

    public void execute() {
        if (mediaplayer != null) {
            mediaplayer.start();
            mediaplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release(); // Libera o MediaPlayer quando a reprodução for concluída.
                }
            });
        }
    }
}