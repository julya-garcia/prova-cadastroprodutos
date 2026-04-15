# 📱 Cadastro de Produtos - Android

Aplicativo desenvolvido em Android Studio para cadastro e gerenciamento de produtos de uma loja virtual.

## 🎯 Objetivo

Permitir o cadastro e a visualização de produtos de forma simples, substituindo o controle manual feito em caderno.

---

## 🛠️ Tecnologias Utilizadas

- Java
- Android Studio
- Room Database
- RecyclerView

---

## 📌 Funcionalidades

### ✅ Cadastro de Produto
- Nome do produto
- Código alfanumérico
- Preço (R$)
- Quantidade em estoque

### ✅ Validações
- Nenhum campo pode estar vazio
- Preço deve ser positivo e com até duas casas decimais
- Quantidade deve ser número inteiro positivo

### ✅ Listagem de Produtos
- Exibe:
  - Nome
  - Código
  - Preço
- Atualização automática após cadastro

---

## 🗄️ Banco de Dados

Utiliza **Room Database** com:

- Entity: `Product`
- DAO: `ProductDao`
- Database: `ProductDatabase`

---

## 📱 Telas do Aplicativo

- Tela de Cadastro de Produto
- Tela de Listagem de Produtos

---

## 🔄 Navegação

- Botão para ir do cadastro → listagem
- Botão para voltar da listagem → cadastro

---

## 👩‍💻 Desenvolvido por

Julya Garcia
