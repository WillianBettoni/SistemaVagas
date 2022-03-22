package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Candidatura;
import util.Conecta;

public class CandidaturaDAO {

    Conecta c = new Conecta();

    public String createCandidatura(Candidatura cand) {
        String message = "Erro ao incluir a Candidatura!";
        String sql = "INSERT "
                + "INTO candidatura ("
                + "idVaga, "
                + "idUsuario, "
                + "dataCandidatura"
                + ") VALUES (?,?,curdate())";

        try {
            c.connect();
            c.prepare(sql);
            c.getPrepare().setInt(1, cand.getIdVaga());
            c.getPrepare().setInt(2, cand.getIdUsuario());
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

    public Candidatura readCandidatura(int idVaga, int idUsuario) {
        Candidatura cand = new Candidatura();
        String sql = "SELECT "
                + "* FROM candidatura c"
                + " WHERE c.idVaga = ? and c.idUsuario = ?";

        try {
            c.connect();
            c.prepare(sql);
            c.getPrepare().setInt(1, idVaga);
            c.getPrepare().setInt(2, idUsuario);
            c.getPrepare().execute();
            ResultSet rs = c.getPrepare().getResultSet();
            rs.next();
            cand = new Candidatura(
                    rs.getInt("idCandidatura"),
                    rs.getInt("idVaga"),
                    rs.getInt("idUsuario"),
                    rs.getDate("dataCandidatura")
            );
        } catch (SQLException ex) {
            cand = null;
        } finally {
            try {
                c.disconnect();
            } catch (SQLException ex) {
                cand = null;
            }
        }
        return cand;
    }
}
