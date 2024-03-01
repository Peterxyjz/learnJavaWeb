package db;
//CRUD: CREATE READ UPADTE DELETE

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ToyFacede {
    public List<Toy> select() throws SQLException{
        List<Toy> list = null;
        //Tạo connection để kết nối DBMS:
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement:
        Statement stm = con.createStatement();
        //Thực hiện câu lệnh SELECT:
        ResultSet rs = stm.executeQuery("SELECT * FROM toy");
        list = new ArrayList<>();
        while(rs.next()){
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
    
}
