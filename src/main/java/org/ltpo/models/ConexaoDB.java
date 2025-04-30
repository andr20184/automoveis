package org.ltpo.models;
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;
public class ConexaoDB {

    public class ConexaoBD {
        public static Connection conectar() throws SQLException {
            String url = "jdbc:mysql://localhost:3306/exemplo";
            String usuario = "root";
            String senha = "root";

            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                return DriverManager.getConnection(url, usuario, senha);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();

                throw new SQLException("Driver MySQL não encontrado.");

            }

        }

    }

}
