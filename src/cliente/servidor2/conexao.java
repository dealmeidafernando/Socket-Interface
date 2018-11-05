/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.servidor2;
 
import java.sql.*;
import javax.swing.*;


/**
 *
 * @author fernando
 */
public class conexao {
   String driver = "com.mysql.jdbc.Driver";
   String url = "jdbc:mysql://localhost:3306/aluno";
   String usuario = "root";
   String senha = "1234";
   
   public Connection connection;
   public  Statement statement;
   public ResultSet resultSet;
   
   public boolean conecta(){
       boolean result = true;
       try {
           Class.forName(driver);
           connection = DriverManager.getConnection(url, usuario, senha);
       } 
       catch (ClassNotFoundException Driver) {
            JOptionPane.showMessageDialog(null, "Driver não localizado");
            result = false;
       }
       catch (SQLException Fonte)
       {
           JOptionPane.showMessageDialog(null, "Deu erro na conexão, fonte de dados: " + Fonte +"\n");
           result = false;
       }
           return result;
   }

   public void desconecta() {
       boolean result = true;
       try {
           connection.close();
           JOptionPane.showMessageDialog(null, "banco fechado");
       } catch (SQLException fecha) {
           JOptionPane.showMessageDialog(null, "Não foi possivel fechar o banco" +fecha);
           result = false;
       }
   }

   public ResultSet executeSQL(String sql) {
       try {
           
           statement = (Statement) connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
           resultSet = statement.executeQuery(sql);
       } catch (SQLException sqlex) {
           JOptionPane.showMessageDialog(null, "Não foi possivel executar o comando sql " + sqlex);
       }
        return resultSet;
   }
}
