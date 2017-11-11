package com.example.alex.myrestourant;

import java.io.Serializable;

/**
 * Created by Alex on 21.10.2017.
 */

public class TableWorkersDataClass implements Serializable {
    private String name;
    private long orders;
    private long duration_of_work;
    private String change_worker;
    private String foto;
    public TableWorkersDataClass(String name, long orders, long duration_of_work, String change_worker, String foto){
        this.name=name;
        this.orders=orders;
        this.duration_of_work=duration_of_work;
        this.change_worker=change_worker;
        this.foto=foto;
    }
    public String getName(){return this.name;}
    public long getOrders(){return this.orders;}
    public long getDuration_of_work(){return this.duration_of_work;}
    public String getChange_worker(){return this.change_worker;}
    public String getFoto(){return this.foto;}
}
