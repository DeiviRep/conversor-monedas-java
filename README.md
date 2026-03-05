# 💱 Currency Converter - Java

A simple **currency converter** built with **Java** that uses a real exchange rate API to convert values between different currencies.

This project was developed as part of the **Oracle Next Education (ONE)** program challenge, focusing on API consumption, JSON parsing, and clean code structure in Java.

---

# 🚀 Features

* Convert currencies in real time
* Consume exchange rate data from an external API
* Parse JSON responses using **Gson**
* Interactive console menu
* Modular and organized project structure

---

# 🛠️ Technologies

* Java 17
* Maven
* Gson
* HTTP Client (Java)

---

# 📂 Project Structure

```
src
 └── main
      └── java
           ├── client
           │    └── ApiClient.java
           ├── model
           │    └── ExchangeResponse.java
           ├── service
           │    └── ConversorService.java
           └── Main.java
```

---

# 🔧 How to Run

### 1 Clone the repository

```
git clone https://github.com/your-username/conversor-monedas.git
```

### 2 Enter the project

```
cd conversor-monedas
```

### 3 Run the application

```
mvn compile
mvn exec:java
```

---

# 💻 Example

```
***************************************
Welcome to the Currency Converter
***************************************

1) USD → ARS
2) ARS → USD
3) USD → BRL
4) BRL → USD
5) Exit

Choose an option:
```

The program will request the amount and display the converted value.

---

# 📚 What I Learned

* Consuming REST APIs in Java
* Parsing JSON responses using Gson
* Structuring Java projects with Maven
* Writing clean and modular code

---

# 👨‍💻 Author

**David Bernardo Patzi Vargas**

Backend Developer focused on:

* Java
* Spring
* Node.js
* APIs
* Backend Architecture

---

# ⭐ Challenge

Project developed for the **Oracle Next Education (ONE) + Alura Latam** challenge.

---

## Ahora el commit final

```bash
git add README.md
git commit -m "docs: add project README"
git push origin develop
```
