package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	
	
	@Test
	public void TestConnection() {
		
		
		try(Connection con = 
				DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:XE",
						"book_ex",
						"book_ex")) {
			
			log.info(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			fail(e.getMessage());
		}
		
	}
	

}
