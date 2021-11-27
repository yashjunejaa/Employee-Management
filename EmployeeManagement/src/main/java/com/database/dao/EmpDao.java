package com.database.dao;

import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
import com.database.beans.Emp;  

public class EmpDao {  
	JdbcTemplate temp;  

	public void setTemp(JdbcTemplate o) {  
		this.temp = o; 
	}

	public int save(Emp p){  
		String sql="insert into Employee(firstName,lastName,salary,department) values('"+p.getFirstName()+"','" +p.getLastName() +"'," +p.getSalary()+",'"+p.getDepartment()+"')";  
		return temp.update(sql);  
	}

	public int update(Emp p){  
		String sql="update Employee set firstName='"+p.getFirstName()+"', lastName='" + p.getLastName() +"', salary="+p.getSalary()+",department='"+p.getDepartment()+"' where id="+p.getId()+"";  
		return temp.update(sql);  
	}

	public int delete(int id){  
		String sql="delete from Employee where id="+id+"";  
		return temp.update(sql);  
	}

	public Emp getEmpById(int id){  
		String sql="select * from Employee where id=?";  
		return temp.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Emp>(Emp.class));  
	}  

	public List<Emp> getEmployees(){  
		return temp.query("select * from Employee",new RowMapper<Emp>(){  
			public Emp mapRow(ResultSet rs, int row) throws SQLException {  
				Emp e = new Emp();  
				e.setId(rs.getInt(1));  
				e.setFirstName(rs.getString(2));
				e.setLastName(rs.getString(3));
				e.setSalary(rs.getFloat(4));  
				e.setDepartment(rs.getString(5));  
				return e;  
			}  
		});  
	}
}  