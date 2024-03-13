package pe.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pe.utils.DBUtils;

public class EmployeeDAO {
    //your code here
    public List<EmployeeDTO> select() throws SQLException, ClassNotFoundException{
        List<EmployeeDTO> list = null;
        //Tạo liên kết:
        Connection con = DBUtils.getConnection();
        //Tạo PreparedStatment
        Statement stm = con.createStatement(); 
        //thực hiện câu lệnh SELECT
        ResultSet rs = stm.executeQuery("Select * From Employee");
        list = new ArrayList<>();
        while (rs.next()) {            
            EmployeeDTO employee = new EmployeeDTO();
            employee.setId(rs.getInt("id"));
            employee.setFullName(rs.getString("fullName"));
            employee.setDob(rs.getDate("dob"));
            employee.setSalary(rs.getDouble("salary"));
            
            list.add(employee);
        }
        con.close();
        return list;
    }
}
