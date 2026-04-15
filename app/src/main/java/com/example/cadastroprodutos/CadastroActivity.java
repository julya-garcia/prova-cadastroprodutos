package com.example.cadastroprodutos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    private EditText etNome, etCodigo, etPreco, etQuantidade;
    private Button btnSalvar, btnVerLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etNome = findViewById(R.id.etNome);
        etCodigo = findViewById(R.id.etCodigo);
        etPreco = findViewById(R.id.etPreco);
        etQuantidade = findViewById(R.id.etQuantidade);

        btnSalvar = findViewById(R.id.btnSalvar);
        btnVerLista = findViewById(R.id.btnVerLista);

        btnSalvar.setOnClickListener(v -> salvarProduto());

        btnVerLista.setOnClickListener(v -> {
            Intent intent = new Intent(CadastroActivity.this, ListaProdutosActivity.class);
            startActivity(intent);
        });
    }

    private void salvarProduto() {
        String nome = etNome.getText().toString().trim();
        String codigo = etCodigo.getText().toString().trim();
        String precoTexto = etPreco.getText().toString().trim();
        String quantidadeTexto = etQuantidade.getText().toString().trim();

        if (nome.isEmpty() || codigo.isEmpty() || precoTexto.isEmpty() || quantidadeTexto.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!precoTexto.matches("^\\d+(\\.\\d{1,2})?$")) {
            Toast.makeText(this, "Preço inválido. Use número positivo com até 2 casas decimais", Toast.LENGTH_LONG).show();
            return;
        }

        double preco;
        try {
            preco = Double.parseDouble(precoTexto);
        } catch (Exception e) {
            Toast.makeText(this, "Preço inválido", Toast.LENGTH_SHORT).show();
            return;
        }

        if (preco <= 0) {
            Toast.makeText(this, "O preço deve ser maior que zero", Toast.LENGTH_SHORT).show();
            return;
        }

        int quantidade;
        try {
            quantidade = Integer.parseInt(quantidadeTexto);
        } catch (Exception e) {
            Toast.makeText(this, "Quantidade inválida", Toast.LENGTH_SHORT).show();
            return;
        }

        if (quantidade <= 0) {
            Toast.makeText(this, "A quantidade deve ser um número inteiro positivo", Toast.LENGTH_LONG).show();
            return;
        }

        Product product = new Product(nome, codigo, preco, quantidade);

        new Thread(() -> {
            ProductDatabase.getDatabase(getApplicationContext())
                    .productDao()
                    .inserir(product);

            runOnUiThread(() -> {
                Toast.makeText(CadastroActivity.this, "Produto cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                limparCampos();
            });
        }).start();
    }

    private void limparCampos() {
        etNome.setText("");
        etCodigo.setText("");
        etPreco.setText("");
        etQuantidade.setText("");
        etNome.requestFocus();
    }
}