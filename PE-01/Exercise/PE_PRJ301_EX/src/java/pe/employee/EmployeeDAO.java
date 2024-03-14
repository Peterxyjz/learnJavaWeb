package pe.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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
    
    public void create(EmployeeDTO employee) throws SQLException, ClassNotFoundException{
        //Tạo liên kết:
        Connection con = DBUtils.getConnection();
        //Tạo PreparedStatment
        PreparedStatement stm = con.prepareStatement("INSERT INTO Employee values(?,?,?)"); 
        //truyền đối số:
        stm.setString(1, employee.getFullName());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(2, sdf.format(employee.getDob()));
        stm.setDouble(3, employee.getSalary());
        //thực hiện câu lệnh insert
        int count = stm.executeUpdate();
        con.close();
    }
}
