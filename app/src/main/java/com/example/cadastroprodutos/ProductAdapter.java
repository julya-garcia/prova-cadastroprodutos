package com.example.cadastroprodutos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> listaProdutos;

    public ProductAdapter(List<Product> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = listaProdutos.get(position);

        holder.tvNome.setText("Nome: " + product.getNome());
        holder.tvCodigo.setText("Código: " + product.getCodigo());
        holder.tvPreco.setText(String.format(Locale.getDefault(), "Preço: R$ %.2f", product.getPreco()));
    }

    @Override
    public int getItemCount() {
        return listaProdutos.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView tvNome, tvCodigo, tvPreco;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNome = itemView.findViewById(R.id.tvNome);
            tvCodigo = itemView.findViewById(R.id.tvCodigo);
            tvPreco = itemView.findViewById(R.id.tvPreco);
        }
    }
}