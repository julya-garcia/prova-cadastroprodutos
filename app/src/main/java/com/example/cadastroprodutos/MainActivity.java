package com.example.cadastroprodutos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnIrCadastro;
    private Button btnIrLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIrCadastro = findViewById(R.id.btnIrCadastro);
        btnIrLista = findViewById(R.id.btnIrLista);

        btnIrCadastro.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
            startActivity(intent);
        });

        btnIrLista.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListaProdutosActivity.class);
            startActivity(intent);
        });
    }
}