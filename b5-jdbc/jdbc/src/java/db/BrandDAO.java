package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BrandDAO {
    public List<BrandDTO> select() throws SQLException {//read
        List<BrandDTO> list = null;
        //Tạo connection để kết nối DBMS:
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement:
        Statement stm = con.createStatement();
        //Thực hiện câu lệnh SELECT:
        ResultSet rs = stm.executeQuery("SELECT * FROM Brand");
        list = new ArrayList<>();
        while (rs.next()) {
            BrandDTO brand = new BrandDTO();
            brand.setId(rs.getString("id"));
            brand.setName(rs.getString("name"));
            //thêm toy vào list
            list.add(brand);
        }
        con.close(); //thu hồi
        return list;
    }
}
