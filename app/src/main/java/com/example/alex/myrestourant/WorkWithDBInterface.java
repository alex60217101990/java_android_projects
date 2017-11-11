package com.example.alex.myrestourant;

import java.util.ArrayList;

/**
 * Created by Alex on 25.10.2017.
 */

public interface WorkWithDBInterface {
    // Метод добавления строки в БД
    long Insert(TableWorkersDataClass model1);
    long Insert(TableMenuDataClass model1);
    // Метод редактирования строки в БД
    int Update(TableWorkersDataClass model1, long id);
    int Update(TableMenuDataClass model1, long id);
    // Метод удаления всех записей из БД
    int DeleteAll(int identificator);
    // Метод удаления записи
  //  public void DeleteById(long id, int identificator);
    public void DeleteById(String name, int identificator);
    // Метод выборки одной записи
    public TableMenuDataClass SelectTable1(long id);
    public TableWorkersDataClass SelectTable2(long id);
    // Метод выборки всех записей
    public ArrayList<TableMenuDataClass> selectAllTable1();
    public ArrayList<TableWorkersDataClass> selectAllTable2();
}
