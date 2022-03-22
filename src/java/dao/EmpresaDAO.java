package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Empresa;
import util.Conecta;

public class EmpresaDAO {

    Conecta c = new Conecta();

    public List<Empresa> readEmpresas() {
        List<Empresa> empresas = new ArrayList<>();
        String sql = "SELECT * "
                + " FROM empresa ";
        try {
            c.connect();
            c.prepare(sql);
            c.getPrepare().execute();
            ResultSet rs = c.getPrepare().getResultSet();
            while (rs.next()) {
                empresas.add(new Empresa(
                        rs.getInt("idEmpresa"),
                        rs.getString("nome"),
                        rs.getString("razao"),
                        rs.getString("cnpj"),
                        rs.getString("email"),
                        rs.getString("cidade"),
                        rs.getString("uf")
                )
                );
            }
        } catch (SQLException ex) {
            empresas = null;
        } finally {
            try {
                c.disconnect();
            } catch (SQLException ex) {
                empresas = null;
            }
        }
        return empresas;
    }
}
