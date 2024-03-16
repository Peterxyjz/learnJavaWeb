/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.fall23.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pe.fall23.utils.DBUtils;

/**
 *
 * @author QUOC PHONG
 */
public class ProductDAO {

    public List<ProductDTO> searchAll() throws ClassNotFoundException, SQLException {
        List<ProductDTO> proList = null;
        Connection con = DBUtils.getConnection();

        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT  * FROM tblProducts");

        proList = new ArrayList<>();
        while (rs.next()) {

            ProductDTO product = new ProductDTO();
            product.setId(rs.getString("productId"));
            product.setName(rs.getString("productName"));
            product.setDescription(rs.getString("description"));
            product.setPrice(rs.getDouble("price"));
            product.setStatus(rs.getBoolean("status"));

            proList.add(product);
        }

        con.close();

        return proList;
    }

    public ProductDTO select(String id) throws ClassNotFoundException, SQLException {

        Connection con = DBUtils.getConnection();

        PreparedStatement stm = con.prepareStatement("SELECT  * FROM tblProducts WHERE productId =?");
        stm.setString(1, id);
        ResultSet rs = stm.executeQuery();

        ProductDTO product = null;
        if (rs.next()) {
            product = new ProductDTO();
            product.setId(rs.getString("productId"));
            product.setName(rs.getString("productName"));
            product.setDescription(rs.getString("description"));
            product.setPrice(rs.getDouble("price"));
            product.setStatus(rs.getBoolean("status"));

        }

        con.close();

        return product;
    }
}
