package dao;

import controller.SessionController;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;
import util.Conecta;

public class UsuarioDAO {

    Conecta c = new Conecta();

    public int createUsuario(Usuario usuario) {
        int status = 2; //código de falha ao incluir

        String sql = "SELECT usuario_id FROM usuario WHERE usuario_login = ?";
        try {
            c.connect();
            c.prepare(sql);
            c.getPrepare().setString(1, usuario.getUsuario_login());
            c.getPrepare().execute();
            ResultSet rs = c.getPrepare().getResultSet();
            if (rs.next()) {
                status = 1;
                return status;
            }
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex.getMessage());
        } finally {
            try {
                c.disconnect();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex.getMessage());
            }
        }

        sql = "INSERT INTO usuario ("
                + " usuario_login, "
                + " usuario_senha, "
                + " usuario_email, "
                + " usuario_perfil "
                + ") VALUES (?,?,?,2)";
        try {
            c.connect();
            c.prepare(sql);
            c.getPrepare().setString(1, usuario.getUsuario_login());
            c.getPrepare().setString(2, usuario.getUsuario_senha());
            c.getPrepare().setString(3, usuario.getUsuario_email());
            c.getPrepare().execute();
            status = 0;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex.getMessage());
        } finally {
            try {
                c.disconnect();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);
            }
        }

        return status;
    }

    public int login(Usuario usuario) {
        Usuario user = new Usuario();
        int status = 1;

        String sql = "SELECT * "
                + "FROM usuario "
                + "WHERE usuario_login = ? AND usuario_senha = ?";
        try {
            c.connect();
            c.prepare(sql);
            c.getPrepare().setString(1, usuario.getUsuario_login());
            c.getPrepare().setString(2, usuario.getUsuario_senha());
            c.getPrepare().execute();
            ResultSet rs = c.getPrepare().getResultSet();
            if (rs.next()) {
                user.setUsuario_id(rs.getInt("usuario_id"));
                user.setUsuario_login(rs.getString("usuario_login"));
                user.setUsuario_email(rs.getString("usuario_email"));
                user.setUsuario_senha(rs.getString("usuario_senha"));
                user.setUsuario_perfil(Integer.parseInt(rs.getString("usuario_perfil")));
                SessionController.setCurrent_user(user);
                status = 0;
            } else {
                status = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public int update(Usuario user) {
        Usuario current = SessionController.getCurrent_user();
        int status = 1;
        String sql = "";
        if (current.getUsuario_login().equals(user.getUsuario_login())) {
            sql = "SELECT usuario_id FROM usuario WHERE usuario_login = ? AND usuario_id != ?";
            try {
                c.connect();
                c.prepare(sql);
                c.getPrepare().setString(1, user.getUsuario_login());
                c.getPrepare().setInt(2, user.getUsuario_id());
                c.getPrepare().execute();
                ResultSet rs = c.getPrepare().getResultSet();
                if (rs.next()) {
                    status = 2;
                    return status;
                }
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex.getMessage());
            } finally {
                try {
                    c.disconnect();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        sql = "UPDATE usuario "
                + "SET "
                + " usuario_login = ?, "
                + " usuario_senha = ?, "
                + " usuario_email = ?, "
                + " usuario_perfil = 2 "
                + "WHERE usuario_id = ?";
        try {
            c.connect();
            c.prepare(sql);
            c.getPrepare().setString(1, user.getUsuario_login());
            c.getPrepare().setString(2, user.getUsuario_senha());
            c.getPrepare().setString(3, user.getUsuario_email());
            c.getPrepare().setInt(4, user.getUsuario_id());
            c.getPrepare().execute();

            SessionController.setCurrent_user(user);
            status = 0;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex.getMessage());
        } finally {
            try {
                c.disconnect();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return status;
    }
}
