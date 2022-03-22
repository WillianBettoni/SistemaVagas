package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Vagas;
import util.Conecta;

public class VagaDAO {

    Conecta c = new Conecta();

    public String createVaga(Vagas vaga) {
        String message = "Erro ao incluir a vaga!";
        String sql = "INSERT "
                + "INTO vaga ("
                + "cargo, "
                + "dataIni, "
                + "dataFim, "
                + "funcao, "
                + "observacao, "
                + "requisitos, "
                + "requisitos_desejaveis, "
                + "idEmpresa "
                + ") VALUES (?,?,?,?,?,?,?,?)";

        try {
            c.connect();
            c.prepare(sql);
            c.getPrepare().setString(1, vaga.getCargo());
            Timestamp timestamp = new Timestamp(vaga.getDataIni().getTime());
            c.getPrepare().setTimestamp(2, timestamp);
            Timestamp timestampFim = new Timestamp(vaga.getDataFim().getTime());
            c.getPrepare().setTimestamp(3, timestampFim);
            c.getPrepare().setString(4, vaga.getFuncao());
            c.getPrepare().setString(5, vaga.getObservacao());
            c.getPrepare().setString(6, vaga.getRequisitos());
            c.getPrepare().setString(7, vaga.getRequisitos_desejaveis());
            c.getPrepare().setInt(8, vaga.getIdEmpresa());
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

    public List<Vagas> readVagas() {
        List<Vagas> vagas = new ArrayList<>();
        String sql = "SELECT * "
                + " FROM vaga v "
                + " inner join empresa e on (e.idEmpresa=v.idEmpresa)"
                + " where current_date() between v.dataIni and v.dataFim";

        try {
            c.connect();
            c.prepare(sql);
            c.getPrepare().execute();
            ResultSet rs = c.getPrepare().getResultSet();
            while (rs.next()) {
                vagas.add(new Vagas(
                        rs.getInt("idVaga"),
                        rs.getString("cargo"),
                        rs.getString("funcao"),
                        rs.getString("requisitos"),
                        rs.getString("requisitos_desejaveis"),
                        rs.getString("observacao"),
                        rs.getDate("dataIni"),
                        rs.getDate("dataFim"),
                        rs.getInt("idEmpresa"),
                        rs.getString("nome")
                )
                );
            }
        } catch (SQLException ex) {
            vagas = null;
        } finally {
            try {
                c.disconnect();
            } catch (SQLException ex) {
                vagas = null;
            }
        }
        return vagas;
    }

    public Vagas readVaga(int idVaga) {
        Vagas vaga = new Vagas();
        String sql = "SELECT "
                + "* FROM vaga v"
                + " inner join empresa e on (e.idEmpresa=v.idEmpresa) "
                + " WHERE v.idVaga = ? and current_date() between v.dataIni and v.dataFim";

        try {
            c.connect();
            c.prepare(sql);
            c.getPrepare().setInt(1, idVaga);
            c.getPrepare().execute();
            ResultSet rs = c.getPrepare().getResultSet();
            rs.next();
            vaga = new Vagas(
                    rs.getInt("idVaga"),
                    rs.getString("cargo"),
                    rs.getString("funcao"),
                    rs.getString("requisitos"),
                    rs.getString("requisitos_desejaveis"),
                    rs.getString("observacao"),
                    rs.getDate("dataIni"),
                    rs.getDate("dataFim"),
                    rs.getInt("idEmpresa"),
                    rs.getString("nome")
            );
        } catch (SQLException ex) {
            vaga = null;
        } finally {
            try {
                c.disconnect();
            } catch (SQLException ex) {
                vaga = null;
            }
        }
        return vaga;
    }
    
    public int readVagaPorEmp(int idEmpresa) {

        int quantidade; 
        String sql = "SELECT "
                + "count(*) as quantidade FROM vaga v"
                + " inner join empresa e on (e.idEmpresa=v.idEmpresa) "
                + " WHERE v.idEmpresa = ? and current_date() between v.dataIni and v.dataFim";

        try {
            c.connect();
            c.prepare(sql);
            c.getPrepare().setInt(1, idEmpresa);
            c.getPrepare().execute();
            ResultSet rs = c.getPrepare().getResultSet();
            rs.next();
            quantidade = rs.getInt("quantidade");
        } catch (SQLException ex) {
            return 0;
        } finally {
            try {
                c.disconnect();
            } catch (SQLException ex) {
                return 0;
            }
        }
        return quantidade;
    }

    public String updateVaga(Vagas vaga) {
        String message = null;
        String sql = "UPDATE vaga "
                + " SET "
                + " cargo = ?, "
                + " dataIni = ?, "
                + " dataFim = ?, "
                + " funcao = ?, "
                + " requisitos = ?, "
                + " requisitos_desejaveis = ?, "
                + " observacao = ?, "
                + " idEmpresa = ? "
                + " WHERE idVaga = ?";
        try {
            c.connect();
            c.prepare(sql);
            c.getPrepare().setString(1, vaga.getCargo());
            Timestamp timestamp = new Timestamp(vaga.getDataIni().getTime());
            c.getPrepare().setTimestamp(2, timestamp);
            Timestamp timestampFim = new Timestamp(vaga.getDataFim().getTime());
            c.getPrepare().setTimestamp(3, timestampFim);
            c.getPrepare().setString(4, vaga.getFuncao());
            c.getPrepare().setString(5, vaga.getRequisitos());
            c.getPrepare().setString(6, vaga.getRequisitos_desejaveis());
            c.getPrepare().setString(7, vaga.getObservacao());
            c.getPrepare().setInt(8, vaga.getIdEmpresa());
            c.getPrepare().setInt(9, vaga.getIdVaga());

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

    public String deleteVaga(int idVaga) {
        String message = null;
        String sql = "DELETE FROM vaga WHERE idVaga = ?;";

        try {
            c.connect();
            c.prepare(sql);
            c.getPrepare().setInt(1, idVaga);
            c.getPrepare().execute();
            message = "Sucesso!";
        } catch (SQLException ex) {
            message = "SQLException: " + ex.getMessage();
        } finally {
            try {
                c.disconnect();
            } catch (SQLException ex) {
                message = "Error: " + ex.getMessage();
            }
        }
        return message;
    }
}
