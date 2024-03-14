package pe.tblUsers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.utils.DBUtils;

public class UserDAO {
    public UserDTO checkLogin(String userId, String password) throws ClassNotFoundException, SQLException{
        Connection con = DBUtils.getConnection();
        PreparedStatement stm = con.prepareStatement("Select * From tblUsers WHERE userID = ? and password = ?");
        //Truyền đối số
        stm.setString(1, userId);
        stm.setString(2, password);
        //thực hiện câu lệnh SELECT
        ResultSet rs = stm.executeQuery();
        UserDTO user = null;
        if(rs.next()){
            user = new UserDTO();
            user.setUserID(rs.getString("userId"));
            user.setFullName(rs.getString("fullName"));
            user.setRoleId(rs.getString("roleId"));
            user.setPassword(rs.getString("password"));
        }
        con.close();
        return user;
    }
}
