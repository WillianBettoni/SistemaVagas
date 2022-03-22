package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conecta {
    private String DRIVER = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://localhost:3306";
    private String DBNAME = "trabalhoweb";
    private String PASSWORD = "admin";
    private String USER = "root";
    private String sql;
    private Connection conexao = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private PreparedStatement pstmt = null;

    public Conecta() {
        this.URL += '/'+DBNAME;
    }

    public Conecta(String URL, String DBNAME, String USER, String PASSWORD) {
        this.URL = URL;
        this.DBNAME = DBNAME;
        this.PASSWORD = PASSWORD;
        this.USER = USER;
        this.URL += '/'+DBNAME;
    }

    public void connect() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        this.conexao = DriverManager.getConnection(URL, USER, PASSWORD);  
        this.stmt = this.getConnection().createStatement();
    }
    
    public void disconnect() throws SQLException {
        if (this.getConnection() != null) {
            this.getConnection().close();
            this.conexao = null;
            if(this.getStatement() != null){
                this.stmt = null;                
            }
        }
    }
    
    public void prepare(String sql) throws SQLException{
        this.pstmt = this.getConnection().prepareStatement(sql);
    }
    
    public PreparedStatement getPrepare() {
        return this.pstmt;
    }
    
    public Connection getConnection(){
      return this.conexao;  
    };
    
    public Statement getStatement() {
        return this.stmt;
    }
    
    
}
