# 📌 MB-APP

MB-APP é um aplicativo Android desenvolvido com **Jetpack Compose**, seguindo a arquitetura **MVVM (Model-View-ViewModel)** e utilizando **Hilt** para injeção de dependência. O aplicativo consome a **CoinAPI.io** para listar exchanges de criptomoedas e exibir detalhes ao selecionar um item da lista.

---

## 🚀 Tecnologias Utilizadas

### 🔹 **Linguagem & Plataforma**
- **Kotlin** – Linguagem oficial para desenvolvimento Android
- **Android Jetpack** – Conjunto de bibliotecas modernas para desenvolvimento Android

### 🔹 **UI e Navegação**
- **Jetpack Compose** – Framework moderno para UI declarativa
- **Navigation Compose** – Gerenciamento de navegação entre telas

### 🔹 **Arquitetura & Estado**
- **MVVM (Model-View-ViewModel)** – Padrão arquitetural para separação de responsabilidades
- **ViewModel** – Gerenciamento de ciclo de vida
- **LiveData / StateFlow** – Gerenciamento de estados reativos

### 🔹 **Injeção de Dependência**
- **Hilt (Dagger-Hilt)** – Framework para injeção de dependências

### 🔹 **Consumo de API**
- **Retrofit** – Cliente HTTP para comunicação com a CoinAPI.io
- **Moshi** – Biblioteca para serialização/deserialização de JSON

### 🔹 **Gerenciamento de Configurações**
- **Gradle Secrets (local.properties)** – Para armazenar a chave da API de forma segura

### 🔹 **Testes**
- **JUnit** – Testes unitários
- **Compose UI Testing** – Testes de interface com Compose

---

## 📦 Instalação e Configuração

1. Clone este repositório:
   ```sh
   git clone https://github.com/seu-usuario/ExchangeApp.git
   ```
2. Abra o projeto no **Android Studio**
3. Adicione a chave da API da **CoinAPI.io** no arquivo `local.properties`:
   ```properties
   COIN_API_KEY=your_api_key_here
   ```
4. Sincronize o projeto e execute o aplicativo!

---

## 📱 Funcionalidades
✅ Listagem de exchanges de criptomoedas
✅ Detalhes da exchange ao clicar no item da lista
✅ Navegação entre telas com Compose
✅ Estado previsível e centralizado com MVVM
✅ Suporte a diferentes fusos horários na exibição de datas

---

## 🛠 Melhorias Futuras


---

## 🤝 Contribuição
1. Fork este repositório
2. Crie uma nova branch (`git checkout -b feature/nova-feature`)
3. Faça suas alterações e commit (`git commit -m 'Adiciona nova feature'`)
4. Envie seu código (`git push origin feature/nova-feature`)
5. Abra um **Pull Request**

---

## 📜 Licença
Este projeto está sob a licença **Apache-2.0 license**.

---

**Desenvolvido por [Raul Cardoso](https://github.com/Rcca01)** 🚀