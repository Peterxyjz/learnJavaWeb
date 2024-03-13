package pe.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.utils.DBUtils;

public class AccountDAO {
    //your code here
    public AccountDTO checkLogin(String email, String password) throws SQLException, ClassNotFoundException{
        //Tạo liên kết:
        Connection con = DBUtils.getConnection();
        //Tạo PreparedStatment
        PreparedStatement stm = con.prepareStatement("Select * From Account WHERE email = ? and password = ?");
        //Truyền đối số
        stm.setString(1, email);
        stm.setString(2, password);
        //thực hiện câu lệnh SELECT
        ResultSet rs = stm.executeQuery();
        
        AccountDTO account = null;
        if(rs.next()){
            account = new AccountDTO();
            account.setId(rs.getInt("id"));
            account.setEmail(rs.getString("email"));
            account.setFullName(rs.getString("fullName"));
            account.setRoleId(rs.getString("roleId"));
            account.setPassword(rs.getString("password"));
        }
        con.close();
        return account;
    }
    
}
