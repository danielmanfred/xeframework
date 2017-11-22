package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

	public Statement statement;
	public ResultSet resultSet;
	protected String driver;
	protected String path;
	protected String user;
	protected String password;
	public Connection connection;
	
	public void conectar() {
		try {
			System.setProperty("jdbc.Drivers", driver); // Seta a propriedade do driver de conexão
			connection = DriverManager.getConnection(path, user, password); // Realiza a conexão com o banco
			System.out.println("Conectado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro na conexão! Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void desconectar() {
		try {
			connection.close();
			System.out.println("O banco foi desconectado!");
		} catch (SQLException e) {
			System.out.println("Erro ao fechar a conexão! Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		
}
