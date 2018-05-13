package Conn;


import DAO.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAO.User;
import java.sql.ResultSet;
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
public class DB {
    
    Connection con;
    public Connection Connect() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root", "root");
        return con;
    }
    
    public int Register(User user){
        try {
            Connect();
            PreparedStatement ps = Connect().prepareStatement("insert into users(fullName,email,pass) values(?,?,?)");
            ps.setString(1, user.name);
            ps.setString(2, user.email);
            ps.setString(3, user.pass);      
            return ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public User GetUser(int id) throws ClassNotFoundException{
        System.out.print("DB user id"+id);
        User user = new User(-1,"no","no","no","no");
        try {
            System.out.print("get user id");
            if(id==-1)
                return user;
            PreparedStatement ps = Connect().prepareStatement("select * from users where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String date="";
                if(rs.getDate("birthday")!=null)
                    date = rs.getDate("birthday").toString();
                System.out.print(id);
                
                user = new User(id,rs.getString("fullName"),rs.getString("email"),rs.getString("pass"),date);
                List list = new ArrayList();
                ps = Connect().prepareStatement("select b.Id, b.Title from u_read as u, books as b where u.userID=? and u.bookID = b.Id");
                ps.setInt(1, id);
                rs = ps.executeQuery();
                while(rs.next()){
                    user.SetReadList(rs.getInt(1), rs.getString(2));
                }
                list.clear();
                ps = Connect().prepareStatement("select b.Id, b.Title from u_willread as u, books as b where u.userID=? and u.bookID = b.Id");
                ps.setInt(1, id);
                rs = ps.executeQuery();
                while(rs.next()){
                    user.SetWillList(rs.getInt(1), rs.getString(2));
                }
                return user;
            }
            else{
                return user;
            }
        } catch (SQLException ex) {
            System.out.print("sql error");
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
        public User GetUser(String email, String pwd) throws ClassNotFoundException{
        //System.out.print("DB user id"+id);
        User user = new User(-1,"no","no","no","no");
        try {
            System.out.print("get user email pass");
            
            PreparedStatement ps = Connect().prepareStatement("select * from users where email=? and pass=?");
            ps.setString(1,email);
            ps.setString(2, pwd);
            ResultSet rs = ps.executeQuery();
            //System.out.print("result:"+rs.next());
            if(rs.next()){
                String date="";
                if(rs.getDate("birthday")!=null)
                    date = rs.getDate("birthday").toString();
                //System.out.print(id);
                int id =rs.getInt("id");
                user = new User(id,rs.getString("fullName"),rs.getString("email"),rs.getString("pass"),date);
                List list = new ArrayList();
                ps = Connect().prepareStatement("select b.Id, b.Title from u_read as u, books as b where u.userID=? and u.bookID = b.Id");
                ps.setInt(1, id);
                
                rs = ps.executeQuery();
                while(rs.next()){
                    user.SetReadList(rs.getInt(1), rs.getString(2));
                }
                list.clear();
                ps = Connect().prepareStatement("select b.Id, b.Title from u_willread as u, books as b where u.userID=? and u.bookID = b.Id");
                ps.setInt(1, id);
                rs = ps.executeQuery();
                while(rs.next()){
                    user.SetWillList(rs.getInt(1), rs.getString(2));
                }
                System.out.print(user.birthday);
                return user;
            }
            else{
                return null;
            }
        } catch (SQLException ex) {
            System.out.print("sql error");
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List GetBookList(){
        try {
            List list = new ArrayList();
            PreparedStatement ps = Connect().prepareStatement("select b.Id, b.Title, b.Author, b.Info, c.catName from books as b, categories as c where b.CatID=c.id");
            //ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new Book(rs.getInt("Id"),rs.getString("Title"),rs.getString("Author"),rs.getString("catName"),rs.getString("Info")));
            }
            return list;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List GetBookList(int category) {
        try {
            List list = new ArrayList();
            PreparedStatement ps = Connect().prepareStatement("select b.Id, b.Title, b.Author, b.Info, c.catName from books as b, categories as c where b.CatID=c.id and c.id=?");
            ps.setInt(1, category);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new Book(rs.getInt("Id"),rs.getString("Title"),rs.getString("Author"),rs.getString("catName"),rs.getString("Info")));
            }
            return list;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
        public List GetBookList(String query) {
        try {
            List list = new ArrayList();
            PreparedStatement ps = Connect().prepareStatement("select b.Id, b.Title, b.Author, b.Info, c.catName from books as b, categories as c where b.CatID=c.id and b.Title like '%"+query+"%'");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                list.add(new Book(rs.getInt("Id"),rs.getString("Title"),rs.getString("Author"),rs.getString("catName"),rs.getString("Info")));
            }
            return list;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void SaveBook(int userID,int bookID,String table){
        try {
            PreparedStatement ps = Connect().prepareStatement("insert into "+table+"(userID,bookID) values(?,?)");
            ps.setInt(1, userID);
            ps.setInt(2, bookID);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String GetBookByID(int id){
        try {
            PreparedStatement ps = Connect().prepareStatement("select Title from books where id=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
