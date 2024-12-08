### Виконав роботу:
**ПІБ:** Матвієнко Дарʼя Олексіʼївна  
**Група:** ІП-23

## Опис
Лабораторна №1 - basic_java_lab1
Лабораторна №2 - basic_java_lab2
Лабораторна №3 - basic_java_lab3
Лабораторна №4 - basic_java_lab4
Лабораторна №5 - basic_java_lab5
Лабораторна №6 - basic_java_lab6

## Налаштування середовища

### Передумови
Перед тим, як почати, переконайтеся, що у вас встановлені:
- Java (версія 11 або вище)
- Maven (версія 3.x або вище)

### Кроки для налаштування середовища

1. Склонуйте репозиторій:
   ```bash
    git clone https://github.com/matviie/SP_Java_2024.git
   ```
   
2. Перейдіть до директорії проекту (наприклад, лр №1):
    ```bash
      cd SP_Java_2024/basic_java_lab1
    ```
   
3. Встановіть залежності:
    ```bash
      mvn clean install
   ```
4. Запуск тестів

   Для запуску тестів виконайте наступну команду:

   ```bash
      mvn test
   ```

5. Запуск програми

    Щоб запустити програму, використайте:

    ```bash
        mvn exec:java -Dexec.mainClass="org.example.Main"
    ```
