package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Funcionario;

public class FuncionarioDAO {
    public String cadastrarContaFuncionario(Funcionario Funcionario) {
        String sqlConta = "INSERT INTO conta (nome_completo, cpf, telefone, email) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoDAO.getConnection();
             PreparedStatement stmtConta = conn.prepareStatement(sqlConta, java.sql.Statement.RETURN_GENERATED_KEYS)) {

            stmtConta.setString(1, Funcionario.getNomeConta());
            stmtConta.setString(2, Funcionario.getCpfConta());
            stmtConta.setString(3, Funcionario.getTelefoneConta());
            stmtConta.setString(4, Funcionario.getEmailConta());
            stmtConta.executeUpdate();

            try (ResultSet idGerado = stmtConta.getGeneratedKeys()) {
                if (idGerado.next()) {
                    int idConta = idGerado.getInt(1);

                    String sqlFuncionario = "INSERT INTO Funcionario (id_conta, funcao, salario) VALUES (?, CURDATE(), ?)";
                    try (PreparedStatement stmtFuncionario = conn.prepareStatement(sqlFuncionario)) {
                        stmtFuncionario.setInt(1, idConta);
                        stmtFuncionario.setString(2, Funcionario.getFuncao());
                        stmtFuncionario.executeUpdate();
                    }
                    return "Funcionario cadastrado com sucesso!";
                } else {
                    return "Erro: Não foi possível obter o ID da conta para criar o Funcionario.";
                }
            }
        } catch (SQLException e) {
            if(e.getErrorCode() == 1062){
                return "CPF já cadastrado!";
            }
            return "Erro ao cadastrar Funcionario: " + e.getMessage();
        }
    }

    public String cadastrarFuncionario(String cpf, String funcao, float salario){
        String sql = "SELECT * FROM conta WHERE cpf = ?";
        try(
            Connection conn = ConexaoDAO.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ){
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                
                sql = "INSERT INTO Funcionario (id_conta, funcao, salario) VALUES (?,CURDATE(),?)";
                try(
                    PreparedStatement stmt2 = conn.prepareStatement(sql)
                ){
                stmt2.setInt(1, rs.getInt("id_conta"));
                stmt2.setString(2, funcao);
                stmt2.executeUpdate();
                return "Funcionario cadastrado com sucesso!";

                }catch(SQLException e){
                    return "Erro ao cadastrar Funcionario: "+ e.getMessage();

                }
            }
            else{
                return "CPF não encontrado!";
            }
        }catch(SQLException e){
            return "Erro ao cadastrar Funcionario:" + e.getMessage();
        }
        
    }
    public ArrayList<Funcionario> listartFuncionarios(){
        ArrayList<Funcionario> Funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM conta co, Funcionario cl WHERE co.id_conta = cl.id_conta";
        try(
            Connection conn = ConexaoDAO.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()

        ){
            while (rs.next()) {
                Funcionarios.add(new Funcionario(rs.getInt("id_funcionario"),rs.getString("nome_completo"),rs.getString("cpf"),rs.getString("email"),rs.getString("telefone"),rs.getString("funcao"),rs.getFloat("salario")));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return Funcionarios;
    }
    public Funcionario buscarFuncionario(String cpf){
        String sql = "SELECT * FROM conta co, Funcionario cl WHERE cl.id_conta = co.id_conta and cpf = ?";
        try(
            Connection conn = ConexaoDAO.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ){
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return new Funcionario(rs.getInt("id_Funcionario"),rs.getString("nome_completo"),rs.getString("cpf"),rs.getString("email"),rs.getString("telefone"),rs.getString("funcao"),rs.getDouble("salario"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public String atualizarConta(String cpf, String nome, String telefone, String email){
        String sql = "UPDATE conta SET nome_completo = ?, telefone = ?, email = ? WHERE cpf = ?";
        try(
            Connection conn = ConexaoDAO.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql,java.sql.Statement.RETURN_GENERATED_KEYS)
        ){
            stmt.setString(1, nome);
            stmt.setString(2, telefone);
            stmt.setString(3, email);
            stmt.setString(4, cpf);
            stmt.executeUpdate();
            return "Conta atualizado com sucesso!";
        } catch(SQLException e){
            return "Erro ao atualizar conta " + e.getMessage();
        }
    }

    public String deletarFuncionario(String cpf){
        String sql = "Select id_conta FROM conta where cpf = ?";
        try(
            Connection conn = ConexaoDAO.getConnection();
            PreparedStatement stmtBusca = conn.prepareStatement(sql);
        ){
            stmtBusca.setString(1, cpf);
            ResultSet rs = stmtBusca.executeQuery();
            if(rs.next()){
                sql = "DELETE FROM Funcionario WHERE id_conta = ?";
                try (
                    PreparedStatement stmtDelete = conn.prepareStatement(sql)
                ){
                    stmtDelete.setInt(1, rs.getInt("id_conta"));
                    stmtDelete.executeUpdate();
                    return "Funcionario removido com Sucesso!";

                } catch (SQLException e) {
                    return "Erro ao deletar Funcionario "+ e.getMessage();
                }
            }
            return "Funcionario não enocntrado";

           
        }catch(SQLException e){
            return "Erro ao deletar Funcionario" + e.getMessage();
        }
    } 


}
