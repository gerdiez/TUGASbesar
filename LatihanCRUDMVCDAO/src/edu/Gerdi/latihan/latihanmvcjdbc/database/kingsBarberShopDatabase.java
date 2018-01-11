/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Gerdi.latihan.latihanmvcjdbc.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import edu.Gerdi.latihan.latihanmvcjdbc.impl.PelangganDaoImpl;
import edu.Gerdi.latihan.latihanmvcjdbc.service.PelangganDao;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Esa
 */
public class kingsBarberShopDatabase {

    private static Connection connection;
    private static PelangganDao PelangganDao;
    public static Connection getConnection() throws SQLException {
        if (connection == null) {

            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost:3306/kingsbarbershop");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = dataSource.getConnection();
        }

        return connection;

    }
    public static PelangganDao getPelangganDao() throws SQLException{
        if(PelangganDao==null){
            PelangganDao = new PelangganDaoImpl(getConnection());
        }
        return PelangganDao;
    }
}
