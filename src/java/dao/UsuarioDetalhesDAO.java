package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import model.UsuarioDetalhes;
import util.Conecta;

public class UsuarioDetalhesDAO {

    Conecta c = new Conecta();

    public String createUsuarioDetalhes(UsuarioDetalhes user) {
        String message = "Erro ao incluir os detalhes do usuário!";
        String sql = "INSERT "
                + "INTO usuariodetalhes ("
                + "idUsuario, "
                + "dataNascimento, "
                + "email, "
                + "sexo, "
                + "nome, "
                + "curriculoResumido "  
                + ") VALUES (?,?,?,?,?,?)";

        try {
            c.connect();
            c.prepare(sql);
            c.getPrepare().setInt(1, user.getIdUsuario());
            Timestamp timestamp = new Timestamp(user.getDataNascimento().getTime());
            c.getPrepare().setTimestamp(2, timestamp);
            c.getPrepare().setString(3, user.getEmail());
            c.getPrepare().setString(4, user.getSexo());
            c.getPrepare().setString(5, user.getNome());
            c.getPrepare().setString(6, user.getCurriculoResumido());
            c.getPrepare().execute();
            message = "Sucesso";
        } catch (SQLException ex) {
            message = "SQLException: " + ex.getMessage();
        } finally {
            try {
                c.disconnect();
            } catch (SQLException ex) {
                message = "Error: " + ex.getMessage();
            }
        }
        System.out.println("Erro:" + message);
        return message;
    }
    
    public UsuarioDetalhes readUsuarioDetalhes(int idUsuario) {
        UsuarioDetalhes user = new UsuarioDetalhes();
        String sql = "SELECT "
                + "* FROM UsuarioDetalhes u"
                + " WHERE u.idUsuario = ?";

        try {
            c.connect();
            c.prepare(sql);
            c.getPrepare().setInt(1, idUsuario);
            c.getPrepare().execute();
            ResultSet rs = c.getPrepare().getResultSet();
            rs.next();
            user = new UsuarioDetalhes(
                    rs.getInt("idUsuarioDetalhes"),
                    rs.getInt("idUsuario"),
                    rs.getString("email"),
                    rs.getString("nome"),
                    rs.getString("sexo"),
                    rs.getDate("dataNascimento"),
                    rs.getString("curriculoResumido"),
                    (byte[]) rs.getBytes("foto"),
                    rs.getString("formatoFoto")
            );
        } catch (SQLException ex) {
            user = null;
        } finally {
            try {
                c.disconnect();
            } catch (SQLException ex) {
                user = null;
            }
        }
        return user;
    }

    public String updateUsuarioDetalhes(UsuarioDetalhes user) {
        String message = null;
        String sql = "UPDATE usuarioDetalhes "
                + " SET "
                + " email = ?, "
                + " dataNascimento = ?, "
                + " sexo = ?, "
                + " nome = ?, "
                + " curriculoResumido = ? "    
                + " WHERE idUsuarioDetalhes = ?";
        try {
            c.connect();
            c.prepare(sql);
            c.getPrepare().setString(1, user.getEmail());
            Timestamp timestamp = new Timestamp(user.getDataNascimento().getTime());
            c.getPrepare().setTimestamp(2, timestamp);
            c.getPrepare().setString(3, user.getSexo());
            c.getPrepare().setString(4, user.getNome());
            c.getPrepare().setString(5, user.getCurriculoResumido());
            c.getPrepare().setInt(6, user.getIdUsuarioDetalhes());
            c.getPrepare().execute();
            message = "Sucesso";
        } catch (SQLException ex) {
            message = "SQLException: " + ex.getMessage();
        } finally {
            try {
                c.disconnect();
            } catch (SQLException ex) {
                message = "Error: " + ex.getMessage();
            }
        }
        System.out.println("erro: " + message);
        return message;
    }
    
    public String updateImagem(UsuarioDetalhes user) {
        String message = null;
        String sql = "UPDATE usuarioDetalhes "
                + " SET "
                + " foto = ?, "
                + " formatofoto = ?"    
                + " WHERE idUsuario = ?";
        try {
            c.connect();
            c.prepare(sql);
            c.getPrepare().setBytes(1, user.getFoto());       
            c.getPrepare().setString(2, user.getFormatoFoto());
            c.getPrepare().setInt(3, user.getIdUsuario());
            c.getPrepare().execute();
            message = "Sucesso";
        } catch (SQLException ex) {
            message = "SQLException: " + ex.getMessage();
        } finally {
            try {
                c.disconnect();
            } catch (SQLException ex) {
                message = "Error: " + ex.getMessage();
            }
        }
        System.out.println("erro: " + message);
        return message;
    }
}
