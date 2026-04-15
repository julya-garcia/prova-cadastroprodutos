package com.example.cadastroprodutos;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListaProdutosActivity extends AppCompatActivity {

    private RecyclerView recyclerProdutos;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);

        recyclerProdutos = findViewById(R.id.recyclerProdutos);
        btnVoltar = findViewById(R.id.btnVoltar);

        recyclerProdutos.setLayoutManager(new LinearLayoutManager(this));

        btnVoltar.setOnClickListener(v -> finish());
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarProdutos();
    }

    private void carregarProdutos() {
        new Thread(() -> {
            List<Product> lista = ProductDatabase.getDatabase(getApplicationContext())
                    .productDao()
                    .listarTodos();

            runOnUiThread(() -> {
                ProductAdapter adapter = new ProductAdapter(lista);
                recyclerProdutos.setAdapter(adapter);
            });
        }).start();
    }
}