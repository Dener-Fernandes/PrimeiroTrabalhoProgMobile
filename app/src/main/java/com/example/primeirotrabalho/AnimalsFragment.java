package com.example.primeirotrabalho;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class AnimalsFragment extends Fragment {
    private ListView animalsNamesList;
    private String[] itens ={"Gato", "Cachorro", "Leão", "Macaco", "Vaca", "Ovelha"};

    private MediaPlayer mediaplayer;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_animals, container, false);

        animalsNamesList = (ListView) view.findViewById(R.id.animalsNamesList);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1, itens);

        // Adicionando adaptador para a lista
        animalsNamesList.setAdapter(adapter);

        animalsNamesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    mediaplayer = MediaPlayer.create(getContext(), R.raw.cat);
                    execute();
                }
                else if( i == 1) {
                    mediaplayer = MediaPlayer.create(getContext(), R.raw.dog);
                    execute();
                }
                else if( i == 2) {
                    mediaplayer = MediaPlayer.create(getContext(), R.raw.lion);
                    execute();
                }
                else if( i == 3) {
                    mediaplayer = MediaPlayer.create(getContext(), R.raw.monkey);
                    execute();
                }
                else if( i == 4) {
                    mediaplayer = MediaPlayer.create(getContext(), R.raw.cow);
                    execute();
                }
                else if( i == 5) {
                    mediaplayer = MediaPlayer.create(getContext(), R.raw.sheep);
                    execute();
                }
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