package ru.agegolden.trafficlighter.comsignal.unmarshaling;

import java.util.HashSet;

/**
 * Интерфейс для работы с наборами объектов десериализованных из сообщений Комсигналовского шлюза
 * @param <T> - тип десериализованных объектов
 */
public interface ISet<T>{

    void setSet(HashSet<T> set);

    HashSet<T> getSet();

    void add(T item);

    T getItem(int id);
}
