package com.example.alex.myrestourant;


import java.io.Serializable;

/**
 * Created by Alex on 21.10.2017.
 */

public class TableMenuDataClass implements Serializable {
    private long _id;
    private String name;
    private double price;
    private long date;
    private String time_type;
    private String change;
    private String icon;
    public TableMenuDataClass(String name, double price, long date, String time_type,String change, String icon){
       // this._id=_id;
        this.name=name;
        this.price=price;
        this.date=date;
        this.time_type=time_type;
        this.change=change;
        this.icon=icon;
    }
  //  public long getId(){return this._id;}
    public String getName(){return this.name;}
    public double getPrice(){return this.price;}
    public long getDate(){return this.date;}
    public String getTime_type(){return this.time_type;}
    public String getChange(){return this.change;}
    public String getIcon(){return this.icon;}
}
