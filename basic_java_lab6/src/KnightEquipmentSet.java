import java.util.*;


/**
 * Клас KnightEquipmentSet - спеціалізована колекція для зберігання унікальних об'єктів KnightEquipment
 * з використанням однозв'язного списку та реалізацією інтерфейсу Set.
 * Забезпечує зберігання та маніпуляцію з об'єктами амуніції лицаря.
 *
 * @param <E> тип елементів, що наслідується від KnightEquipment
 */
public class KnightEquipmentSet<E extends KnightEquipment> implements Set<E> {
    // Внутрішній клас вузла однозв'язного списку
    private class Node {
        E data;
        Node next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    // Головний вузол списку
    private Node head;
    // Поточний розмір колекції
    private int size;

    /**
     * Порожній конструктор. Створює порожню колекцію.
     */
    public KnightEquipmentSet() {
        head = null;
        size = 0;
    }

    /**
     * Конструктор, що створює колекцію з одного елемента.
     *
     * @param initialElement перший елемент колекції
     */
    public KnightEquipmentSet(E initialElement) {
        this();
        add(initialElement);
    }

    /**
     * Конструктор, що створює колекцію на основі наявної колекції.
     *
     * @param collection колекція, елементи якої будуть додані до нової колекції
     */
    public KnightEquipmentSet(Collection<? extends E> collection) {
        this();
        addAll(collection);
    }

    /**
     * Додає елемент до колекції, якщо він ще не існує.
     *
     * @param e елемент для додавання
     * @return true, якщо елемент було додано, інакше false
     */
    @Override
    public boolean add(E e) {
        // Перевірка на null
        if (e == null) {
            return false;
        }

        // Перевірка на наявність елемента
        if (contains(e)) {
            return false;
        }

        // Створення нового вузла
        Node newNode = new Node(e);

        // Якщо список порожній
        if (head == null) {
            head = newNode;
        } else {
            // Додавання на початок списку
            newNode.next = head;
            head = newNode;
        }

        size++;
        return true;
    }

    /**
     * Додає всі елементи з наданої колекції.
     *
     * @param c колекція елементів для додавання
     * @return true, якщо колекція змінилася
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c == null) {
            return false;
        }

        boolean modified = false;
        for (E element : c) {
            if (add(element)) {
                modified = true;
            }
        }

        return modified;
    }

    /**
     * Очищає колекцію
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Перевіряє наявність елемента в колекції.
     *
     * @param o об'єкт для перевірки
     * @return true, якщо об'єкт є в колекції
     */
    @Override
    public boolean contains(Object o) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Перевіряє, чи містить колекція всі елементи з наданої колекції.
     *
     * @param c колекція елементів для перевірки
     * @return true, якщо всі елементи є в колекції
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Перевіряє, чи є колекція порожньою.
     *
     * @return true, якщо колекція не містить елементів
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Створює ітератор для колекції.
     *
     * @return ітератор
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    /**
     * Видаляє елемент з колекції.
     *
     * @param o об'єкт для видалення
     * @return true, якщо об'єкт було видалено
     */
    @Override
    public boolean remove(Object o) {
        // Якщо колекція порожня
        if (head == null) {
            return false;
        }

        // Якщо видаляємо головний елемент
        if (head.data.equals(o)) {
            head = head.next;
            size--;
            return true;
        }

        // Пошук елемента для видалення
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (current.data.equals(o)) {
                assert previous != null;
                previous.next = current.next;
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }

        return false;
    }

    /**
     * Видаляє всі елементи, що містяться в наданій колекції.
     *
     * @param c колекція елементів для видалення
     * @return true, якщо колекція змінилася
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null) {
            return false;
        }

        boolean modified = false;
        for (Object element : c) {
            if (remove(element)) {
                modified = true;
            }
        }

        return modified;
    }

    /**
     * Залишає в колекції лише ті елементи, що є в наданій колекції.
     *
     * @param c колекція елементів для збереження
     * @return true, якщо колекція змінилася
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        if (c == null) {
            return false;
        }

        boolean modified = false;
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (!c.contains(current.data)) {
                // Видалення елемента
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                modified = true;
            } else {
                previous = current;
            }
            current = current.next;
        }

        return modified;
    }

    /**
     * Повертає розмір колекції.
     *
     * @return кількість елементів у колекції
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Перетворює колекцію в масив.
     *
     * @return масив елементів колекції
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node current = head;
        int index = 0;

        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }

        return array;
    }

    /**
     * Перетворює колекцію в масив заданого типу.
     *
     * @param a масив-контейнер для збереження елементів
     * @return масив елементів колекції
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            // Якщо масив замалий, створюємо новий
            a = (T[]) java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);
        }

        Node current = head;
        int index = 0;

        while (current != null) {
            a[index++] = (T) current.data;
            current = current.next;
        }

        // Якщо масив більший за розмір колекції,
        // встановлюємо наступний елемент як null
        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }

    /**
     * Метод для виведення елементів колекції.
     *
     * @return рядок з інформацією про елементи колекції
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = head;

        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }
}
