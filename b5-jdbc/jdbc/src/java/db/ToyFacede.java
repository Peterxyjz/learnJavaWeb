package db;
//CRUD: CREATE READ UPADTE DELETE

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ToyFacede {

    public List<Toy> select() throws SQLException {//read
        List<Toy> list = null;
        //Tạo connection để kết nối DBMS:
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement:
        Statement stm = con.createStatement();
        //Thực hiện câu lệnh SELECT:
        ResultSet rs = stm.executeQuery("SELECT * FROM toy");
        list = new ArrayList<>();
        while (rs.next()) {
            Toy toy = new Toy();
            toy.setId(rs.getString("id"));
            toy.setName(rs.getString("name"));
            toy.setPrice(rs.getDouble("price"));
            toy.setExpDate(rs.getDate("expDate"));
            toy.setBrand(rs.getString("brand"));
            //thêm toy vào list
            list.add(toy);
        }
        con.close(); //thu hồi
        return list;
    }

    public void create(Toy toy) throws SQLException {
        //Tạo connection để kết nối DBMS:
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement:
        PreparedStatement stm = con.prepareStatement("insert into Toy values(?,?,?,?,?)");
        //Cung cấp giá trị cho các tham số:
        stm.setString(1, toy.getId());
        stm.setString(2, toy.getName());
        stm.setDouble(3, toy.getPrice());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(4, sdf.format(toy.getExpDate()));
        stm.setString(5, toy.getBrand());
        //Thực hiện lện Insert:
        int count = stm.executeUpdate();
        con.close();;
    }
    
    public Toy select(String id) throws SQLException { //search
        //Tạo connection để kết nối DBMS:
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement:
        PreparedStatement stm = con.prepareStatement("Select *  from Toy where id=?");
        //Cung cấp giá trị cho tham số:
        stm.setString(1, id);
        //Thực hiện câu lệnh SELECT:
        ResultSet rs = stm.executeQuery();
        Toy toy = new Toy();
        if (rs.next()) {
            toy.setId(rs.getString("id"));
            toy.setName(rs.getString("name"));
            toy.setPrice(rs.getDouble("price"));
            toy.setExpDate(rs.getDate("expDate"));
            toy.setBrand(rs.getString("brand"));
        }
        con.close(); //thu hồi
        return toy;
    }
    
    public void update(Toy toy) throws SQLException {
        //Tạo connection để kết nối DBMS:
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement:
        PreparedStatement stm = con.prepareStatement("update Toy set name=?, price=?, expdate=?, brand =? where id = ?");
        //Cung cấp giá trị cho các tham số:
        stm.setString(1, toy.getName());
        stm.setDouble(2, toy.getPrice());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(3, sdf.format(toy.getExpDate()));
        stm.setString(4, toy.getBrand());
        stm.setString(5, toy.getId());
        //Thực hiện lện update:
        int count = stm.executeUpdate();
        con.close();;
    }
    
    public void delete(String id) throws SQLException{
        //Tạo liên kết với db
        Connection con = DBContext.getConnection();
        //tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("DELETE Toy WHERE id = ?");
        //Cung cấp đối số
        stm.setString(1, id);
        //thực thi câu lệnh
        int count = stm.executeUpdate();
        con.close();
    }

}
