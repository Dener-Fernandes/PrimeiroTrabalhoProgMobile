package com.example.primeirotrabalho;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private AnimalsFragment animalsFragment;
    private NumbersFragment numbersFragment;
    private HomeFragment homeFragment;
    private Spinner menuSpinner;

    String[] menuOptions = {"Home", "Animais", "Números"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Pegando o componente

        menuSpinner = findViewById(R.id.spinnerMenu);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, menuOptions);
        menuSpinner.setAdapter(adapter);

        // Pegando o item selecionado

        menuSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    homeFragment = new HomeFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameContent, homeFragment);
                    transaction.commit();
                }
                if (i == 1) {
                    animalsFragment = new AnimalsFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameContent, animalsFragment);
                    transaction.commit();
                }
                else if (i == 2) {
                    numbersFragment = new NumbersFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameContent, numbersFragment);
                    transaction.commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }
}