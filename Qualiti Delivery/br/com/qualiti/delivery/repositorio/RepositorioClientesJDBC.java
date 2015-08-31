package br.com.qualiti.delivery.repositorio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.qualiti.delivery.entidades.Cliente;
import br.com.qualiti.delivery.entidades.Endereco;
import br.com.qualiti.delivery.interfaces.Repositorio;
import br.com.qualiti.delivery.util.Util;

public class RepositorioClientesJDBC implements Repositorio<Cliente> {

	@Override
	public boolean existe(Serializable chave) throws Exception {
		return procurar(chave) != null;
	}

	@Override
	public void inserir(Cliente entidade) throws Exception {

		String sql = "INSERT INTO \"CLIENTE\"(\"NOME\", "
				+ "\"CPF\", \"DATA_NASCIMENTO\", \"TELEFONE\", "
				+ "\"CELULAR\", \"EMAIL\", \"LOGRADOURO\","
				+ " \"NUMERO\", \"BAIRRO\", \"CIDADE\", "
				+ "\"ESTADO\", \"CEP\"," 
				+ "\"COMPLEMENTO\") VALUES (?, ?, ?, ?, ?, ?, "
				+ "?, ?, ?, ?, ?, ?, ?)";

		Connection conn = Util.getConexao();

		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, entidade.getNome());
		ps.setString(2, entidade.getCpf());
		ps.setDate(3, new java.sql.Date(entidade.getDataNascimento().getTime()));
		ps.setString(4, entidade.getTelefone());
		ps.setString(5, entidade.getCelular());
		ps.setString(6, entidade.getEmail());
		ps.setString(7, entidade.getEndereco().getLogradouro());
		ps.setString(8, entidade.getEndereco().getNumero());
		ps.setString(9, entidade.getEndereco().getBairro());
		ps.setString(10, entidade.getEndereco().getCidade());
		ps.setString(11, entidade.getEndereco().getEstado());
		ps.setString(12, entidade.getEndereco().getCep());
		ps.setString(13, entidade.getEndereco().getComplemento());

		int i = ps.executeUpdate();

		if (i != 1){
			throw new SQLException();
		}

		Util.fechaConexao(conn);
	}

	@Override
	public void atualizar(Cliente entidade) throws Exception {
		
		String sql = "UPDATE \"CLIENTE\" SET \"NOME\"=?, "
				+ "\"DATA_NASCIMENTO\"=?, \"TELEFONE\"=?, "
				+ "\"CELULAR\"=?,\"EMAIL\"=?, \"LOGRADOURO\"=?, "
				+ "\"NUMERO\"=?, \"BAIRRO\"=?, \"CIDADE\"=?,"
				+ "\"ESTADO\"=?, \"CEP\"=?, \"COMPLEMENTO\"=? "
				+ "WHERE \"CPF\"=?";
		
		Connection conn = Util.getConexao();
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, entidade.getNome());
		ps.setDate(2, new java.sql.Date(entidade.getDataNascimento().getTime()));
		ps.setString(3, entidade.getTelefone());
		ps.setString(4, entidade.getCelular());
		ps.setString(5, entidade.getEmail());
		ps.setString(6, entidade.getEndereco().getLogradouro());
		ps.setString(7, entidade.getEndereco().getNumero());
		ps.setString(8, entidade.getEndereco().getBairro());
		ps.setString(9, entidade.getEndereco().getCidade());
		ps.setString(10, entidade.getEndereco().getEstado());
		ps.setString(11, entidade.getEndereco().getCep());
		ps.setString(12, entidade.getEndereco().getComplemento());
		ps.setString(13, entidade.getCpf());
		
		int i = ps.executeUpdate();
		
		if (i != 1) {
			throw new SQLException();
		}
		
		Util.fechaConexao(conn);
	}

	@Override
	public void remover(Serializable chave) throws Exception {

		String sql = "DELETE FROM \"CLIENTE\" WHERE \"CPF\" = ?";

		Connection conn = Util.getConexao();

		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, String.valueOf(chave));

		int i = ps.executeUpdate();
		
		if (i != 1) {
			throw new SQLException();
		}
		
		Util.fechaConexao(conn);

	}

	@Override
	public Cliente procurar(Serializable chave) throws Exception {

		String sql = "SELECT * FROM \"CLIENTE\" WHERE \"CPF\" = ?";

		Connection conn = Util.getConexao();

		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, String.valueOf(chave));

		ResultSet result = ps.executeQuery();

		Cliente retorno = null;

		if (result.next()){
			retorno = new Cliente();
			retorno.setNome(result.getString("NOME"));
			retorno.setCpf(result.getString("CPF"));
			retorno.setDataNascimento(new Date(result.getDate("DATA_NASCIMENTO").getTime()));
			retorno.setEmail(result.getString("EMAIL"));
			retorno.setTelefone(result.getString("TELEFONE"));
			retorno.setCelular(result.getString("CELULAR"));
			Endereco endereco = new Endereco();
			endereco.setBairro(result.getString("BAIRRO"));
			endereco.setCep(result.getString("CEP"));
			endereco.setCidade(result.getString("CIDADE"));
			endereco.setComplemento(result.getString("COMPLEMENTO"));
			endereco.setEstado(result.getString("ESTADO"));
			endereco.setLogradouro(result.getString("LOGRADOURO"));
			endereco.setNumero(result.getString("NUMERO"));
			retorno.setEndereco(endereco);
		}

		Util.fechaConexao(conn);

		return retorno;
	}

	@Override
	public Cliente[] buscarTodos() throws Exception {
		
		List<Cliente> listaClientes = new ArrayList<>();
		
		String sql = "SELECT * FROM \"CLIENTE\"";

		Connection conn = Util.getConexao();

		PreparedStatement ps = conn.prepareStatement(sql);

		ResultSet result = ps.executeQuery();

		Cliente clienteAtual = null;

		while (result.next()){
			clienteAtual = new Cliente();
			clienteAtual.setNome(result.getString("NOME"));
			clienteAtual.setCpf(result.getString("CPF"));
			clienteAtual.setDataNascimento(new Date(result.getDate("DATA_NASCIMENTO").getTime()));
			clienteAtual.setEmail(result.getString("EMAIL"));
			clienteAtual.setTelefone(result.getString("TELEFONE"));
			clienteAtual.setCelular(result.getString("CELULAR"));
			Endereco endereco = new Endereco();
			endereco.setBairro(result.getString("BAIRRO"));
			endereco.setCep(result.getString("CEP"));
			endereco.setCidade(result.getString("CIDADE"));
			endereco.setComplemento(result.getString("COMPLEMENTO"));
			endereco.setEstado(result.getString("ESTADO"));
			endereco.setLogradouro(result.getString("LOGRADOURO"));
			endereco.setNumero(result.getString("NUMERO"));
			clienteAtual.setEndereco(endereco);
			listaClientes.add(clienteAtual);			
		}

		Util.fechaConexao(conn);

		return listaClientes.toArray(new Cliente[listaClientes.size()]);
	}

}
