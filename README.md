# Tugas Kecil III IF2211
## Penyelesaian Permainan Word Ladder Menggunakan Algoritma UCS, Greedy Best First Search, dan A*

| NIM | Nama |
| ------ | ------ |
| 10023608 | Tazkirah Amaliah |


## Algortima UCS, GBFS, A*

Pemilihan algoritma pencarian seperti UCS, Greedy Best First Search (GBFS), dan A* sangat tergantung pada kebutuhan spesifik dari suatu masalah. Algoritma UCS menawarkan solusi optimal namun memerlukan penggunaan memori yang besar dan waktu eksekusi yang cenderung lebih lambat. Algoritma GBFS dapat memberikan solusi dengan cepat namun tidak menjamin solusi optimal, dan biasanya membutuhkan memori yang lebih sedikit. Sedangkan, algoritma A* menggabungkan keunggulan keduanya dengan memberikan solusi optimal dengan mempertimbangkan biaya aktual dan nilai heuristik, meskipun memerlukan memori yang cukup dan waktu eksekusi yang bervariasi tergantung pada struktur masalah.

## Cara Kompilasi

1. Klik Run Code kemudian ke terminal
2. Ketik "cd (tempat file disimpan)"
3. Ketik "javac Main.java WordLadderSolver.java WordValidator.java Node.java InputHandler.java OutputHandler.java"
4. Ketik "java Main"
5. Input start word dan end word


## Susunan file
```
├───README.md
│                     
├───src                                             
    ├── WordLadderSolver.java   
    ├── WordValidator.java  
    ├── InputHandler.java
    ├── OutputHandler.java
    ├── Node.java
    ├── Main.java
    ├── words.txt
        
```