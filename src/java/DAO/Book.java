/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author k_kur
 */
public class Book {
    public int id;
    public String Name;
    public String Auth;
    public String Cat;
    public String Info;

    public Book(int i,String n, String a, String c, String in){
        id = i;
        Name = n;
        Auth = a;
        Cat = c;
        Info = in;
    }
}
