package pe.tblCapstones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.utils.DBUtils;

public class CapstoneDAO {

    public List<CapstoneDTO> searchByName(String search_input) throws SQLException, ClassNotFoundException {
        List<CapstoneDTO> list = null;
        //Tạo liên kết:
        Connection con = DBUtils.getConnection();
        //Tạo PreparedStatment
        PreparedStatement stm = con.prepareStatement("SELECT * FROM tblCapstones WHERE name like ?");

        stm.setString(1, search_input);
        //thực hiện câu lệnh SELECT
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            CapstoneDTO capstone = new CapstoneDTO();
            capstone.setId(rs.getString("id"));
            capstone.setName(rs.getString("name"));
            capstone.setDescription(rs.getString("description"));
            capstone.setUserId(rs.getString("userId"));

            list.add(capstone);
        }
        con.close();
        return list;
    }
    
    public void delete(String id) throws SQLException, ClassNotFoundException{
        Connection con = DBUtils.getConnection();
        //Tạo PreparedStatment
        PreparedStatement stm = con.prepareStatement("DELETE tblCapstones WHERE id = ?");
        stm.setString(1, id);
        //thực hiện câu lệnh SELECT
        int count = stm.executeUpdate();
        con.close();
    }
}
