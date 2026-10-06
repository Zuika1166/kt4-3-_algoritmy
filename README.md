# КТ алгоритмы

Проект содержит решения шести алгоритмических задач на Java 21.

## Требования

- JDK 21
- Maven 3.9+

## Тесты

Запуск всех тестов:

```bash
mvn test
```

## Сборка

```bash
mvn package
```

После сборки классы находятся в `target/classes`.

## Задача 1. Следующая строго большая цена

Класс:

```text
com.example.kt4.Task1NextGreaterPrice
```

В первой строке вводится `n`. Во второй строке вводятся `n` цен.

Запуск:

```bash
java -cp target/classes com.example.kt4.Task1NextGreaterPrice
```

Пример:

```text
Ввод:
3
5 5 6

Вывод:
2 1 0
```

Используется монотонный стек индексов.

Сложность:

```text
Время: O(n)
Память: O(n)
```

## Задача 2. Кратчайший путь по карте

Класс:

```text
com.example.kt4.Task2GridShortestPath
```

В первой строке вводятся `n` и `m`. Далее вводятся `n` строк карты.

Запуск:

```bash
java -cp target/classes com.example.kt4.Task2GridShortestPath
```

Пример:

```text
Ввод:
3 4
S..#
.#..
...T

Вывод:
5
```

Используется BFS. Каждая клетка обрабатывается не более одного раза.

Сложность:

```text
Время: O(n * m)
Память: O(n * m)
```

## Задача 3. Повторное посещение узла

Класс:

```text
com.example.kt4.Task3FunctionalGraphCycle
```

В первой строке вводятся `n` и `start`. Во второй строке вводится массив `next`.

Запуск:

```bash
java -cp target/classes com.example.kt4.Task3FunctionalGraphCycle
```

Пример:

```text
Ввод:
4 1
2 3 4 2

Вывод:
YES
```

Используется алгоритм Флойда с медленным и быстрым указателями.

Сложность:

```text
Время: O(n)
Дополнительная память: O(1)
```

## Задача 4. Максимальный прямоугольник из единиц

Класс:

```text
com.example.kt4.Task4MaximalRectangle
```

В первой строке вводятся `n` и `m`. Далее вводятся строки бинарной матрицы без пробелов.

Запуск:

```bash
java -cp target/classes com.example.kt4.Task4MaximalRectangle
```

Пример:

```text
Ввод:
4 5
10100
10111
11111
10010

Вывод:
6
```

Каждая строка преобразуется в высоты гистограммы. Максимальный прямоугольник гистограммы находится монотонным стеком.

Сложность:

```text
Время: O(n * m)
Дополнительная память: O(m)
```

## Задача 5. Кратчайший путь с ключами и дверями

Класс:

```text
com.example.kt4.Task5KeysAndDoors
```

В первой строке вводятся `n` и `m`. Далее вводится карта.

Запуск:

```bash
java -cp target/classes com.example.kt4.Task5KeysAndDoors
```

Пример:

```text
Ввод:
3 3
S.a
##A
..T

Вывод:
4
```

Состояние BFS состоит из позиции и битовой маски собранных ключей. Для ключей `a-j` используется 10 бит.

Сложность:

```text
Время: O(n * m * 2^k)
Память: O(n * m * 2^k)
k <= 10
```

## Задача 6. Поиск повторяющегося значения

Класс:

```text
com.example.kt4.Task6FindDuplicate
```

В первой строке вводится `n`. Во второй строке вводятся `n + 1` чисел.

Запуск:

```bash
java -cp target/classes com.example.kt4.Task6FindDuplicate
```

Пример:

```text
Ввод:
4
1 3 4 2 2

Вывод:
2
```

Массив рассматривается как функциональный граф. Повторяющееся значение находится алгоритмом Флойда без изменения массива.

Сложность:

```text
Время: O(n)
Дополнительная память: O(1)
```

## Структура

```text
src/main/java/com/example/kt4
├── FastScanner.java
├── Task1NextGreaterPrice.java
├── Task2GridShortestPath.java
├── Task3FunctionalGraphCycle.java
├── Task4MaximalRectangle.java
├── Task5KeysAndDoors.java
└── Task6FindDuplicate.java

src/test/java/com/example/kt4
└── AlgorithmsTest.java
```
