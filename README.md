# 📜 Anagram Reader (Java)

Un utilitar simplu în Java care citește cuvinte dintr-un fișier text (`sample.txt`), le grupează în **anagrame** (ignorând majusculele) și le afișează pe linii separate.  
Fiecare grup este sortat alfabetic (fără diferență între litere mari și mici), iar ordinea grupurilor reflectă **prima apariție** în fișier.

---

## 📂 Structura proiectului

Structura proiectului
anagram-grouper/
├─ Main.java # codul principal Java
└─ sample.txt # fișier de intrare (un cuvânt pe linie, UTF-8)

---

## ⚙️ Cerințe

- **Java JDK 8+** (programul a fost creat pe versiunea **JDK 24**)
- Orice IDE Java (ex: _IntelliJ IDEA Community_)
- Sistem de operare: **Windows / macOS / Linux**

---

## 🚀 Cum rulezi

### 🔹 Metoda 1 – din IDE

1. Deschide proiectul în **IntelliJ IDEA** sau alt IDE Java.
2. Asigură-te că `sample.txt` este în directorul proiectului.
3. Rulează programul din **clasa `Main`**.

### 🔹 Metoda 2 – din terminal

1. Compilează programul:
   ```bash
   javac Main.java
   ```

Fișierul sample.txt trebuie să fie în UTF-8, cu câte un cuvânt pe linie.

Exemplu:

act

cat

tree

race

care

acre

bee
