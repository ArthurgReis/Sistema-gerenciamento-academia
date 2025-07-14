package dao;

import model.Registro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class RegistroDAO {

    public String inserirRegistroCompleto(Registro registro) {
        String sql = "INSERT INTO registro_acesso (id_cliente, data_entrada, data_saida) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, registro.getIdCliente());
            stmt.setTimestamp(2, Timestamp.valueOf(registro.getDataEntrada()));
            stmt.setTimestamp(3, Timestamp.valueOf(registro.getDataSaida()));

            stmt.executeUpdate();
            return "Registro de acesso do cliente ID " + registro.getIdCliente() + " inserido com sucesso!";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao inserir registro de acesso: " + e.getMessage();
        }
    }

    public ArrayList<Registro> listarRegistros() {
        ArrayList<Registro> registros = new ArrayList<>();
        String sql = "SELECT id_cliente, data_entrada, data_saida FROM registro_acesso ORDER BY data_entrada DESC";

        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idCliente = rs.getInt("id_cliente");
                LocalDateTime dataEntrada = rs.getTimestamp("data_entrada").toLocalDateTime();
                LocalDateTime dataSaida = rs.getTimestamp("data_saida").toLocalDateTime();

                registros.add(new Registro(idCliente, dataEntrada, dataSaida));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao listar registros: " + e.getMessage());
        }
        return registros;
    }

    public ArrayList<Registro> buscarPorCliente(int idCliente) {
        ArrayList<Registro> registros = new ArrayList<>();
        String sql = "SELECT id_cliente, data_entrada, data_saida FROM registro_acesso WHERE id_cliente = ? ORDER BY data_entrada DESC";

        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCliente);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    LocalDateTime dataEntrada = rs.getTimestamp("data_entrada").toLocalDateTime();
                    LocalDateTime dataSaida = rs.getTimestamp("data_saida").toLocalDateTime();

                    registros.add(new Registro(idCliente, dataEntrada, dataSaida));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar registros por cliente: " + e.getMessage());
        }
        return registros;
    }
}