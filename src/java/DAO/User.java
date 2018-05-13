package DAO;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k_kur
 */
public class User {
    public int ID;
    public String name;
    public String email;
    public String pass;
    public String birthday;
    public List readBooks = new ArrayList();
    public List willBooks = new ArrayList();
    public User(int id,String n, String e, String p,String d){
        ID = id;
        name = n;
        email = e;
        pass = p;
        birthday=d;
    }
    
    public void SetReadList(int i,String b){
        readBooks.add(new Book(i,b,"","",""));
    }
    public void SetWillList(int i,String b){
        willBooks.add(new Book(i,b,"","",""));
    }

}
/*class UserBooks{
    public int id;
    public String bookName;
    public UserBooks(int i, String b){
        id=i;
        bookName=b;
    }
}*/
