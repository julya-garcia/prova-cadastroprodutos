package com.example.cadastroprodutos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert
    void inserir(Product product);

    @Query("SELECT * FROM products ORDER BY nome ASC")
    List<Product> listarTodos();
}