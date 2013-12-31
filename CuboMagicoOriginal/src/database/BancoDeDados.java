package database;
import java.util.List;

import model.Resolucao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class BancoDeDados {

	private final static String DATABASE_URL = "jdbc:sqlite:cubo.sqlite";

	private Dao<Resolucao, Integer> resolucaoDao;

	public BancoDeDados(){
		super();
		
		try {
			criaBanco();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void criaBanco() throws Exception {
		
		ConnectionSource connectionSource = null;
		
		try {
			// create our data-source for the database
			connectionSource = new JdbcConnectionSource(DATABASE_URL);
			// setup our database and DAOs
			configuraBancoDeDados(connectionSource);
			// read and write some data
			//readWriteData();
			
		} finally {
			// destroy the data source which should close underlying connections
			if (connectionSource != null) {
				connectionSource.close();
			}
		}
	}

	/**
	 * Configura o Banco de Dados e os DAOs
	 */
	private void configuraBancoDeDados(ConnectionSource connectionSource) throws Exception {

		resolucaoDao = DaoManager.createDao(connectionSource, Resolucao.class);

		//Cria tabela de Resolucao
		TableUtils.createTableIfNotExists(connectionSource, Resolucao.class);
	}

	/**
	 * Read and write some example data.
	 */
	private void readWriteData() throws Exception {
		// create an instance of Resolucao
		Resolucao resolucao = new Resolucao();
		resolucao.setPassos("");

		// persist the account object to the database
				
		List<Resolucao> resolucoes = resolucaoDao.queryForAll();
						
		for(Resolucao res: resolucoes){
			System.out.println("Resolucao "+res.getId()+": "+res.getPassos());	
		}
		
	}

	public Dao<Resolucao, Integer> getResolucaoDao() {
		return resolucaoDao;
	}

}
