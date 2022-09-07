package kr.co.greenart.model.car;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CarRepositoryMySql implements CarRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private CarMapper mapper = new CarMapper();

	public class CarMapper implements RowMapper<Car> {

		@Override
		public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id = rs.getInt("id");
			String model = rs.getNString("model");
			int price = rs.getInt("price");

			return new Car(id, model, price);
		}
	}

	@Override
	public List<Car> getAll() {
		return jdbcTemplate.query("SELECT * FROM cars", mapper);
	}

	@Override
	public Car getById(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM cars WHERE id=?", mapper);
	}

	@Override
	public int add(Car car) {
		return jdbcTemplate.update("INSERT INTO cars (model, price) VALUES (?, ?)", car.getModel(), car.getPrice());
	}

	@Override
	public int update(Car car) {
		return jdbcTemplate.update("UPDATE cars SET model=?, price=? WHERE id=?", car.getModel(), car.getPrice(),
				car.getId());
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("DELETE FROM cars WHERE id=?", id);
	}

	@Override
	public int[] batchInsert(List<Car> list) {
		return jdbcTemplate.batchUpdate("INSERT INTO cars (model, price) VALUES (?, ?)",
				new BatchPreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						Car car = list.get(i);
						ps.setString(1,  car.getModel());
						ps.setInt(2,  car.getPrice());
					}
					
					@Override
					public int getBatchSize() {
						return list.size();
					}
				});
	}

	
	
	
	
	
	
	
}
