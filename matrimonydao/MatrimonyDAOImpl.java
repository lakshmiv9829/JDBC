package com.xworkz.matrimonydao;

import java.sql.Connection;



import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.xworkz.matrimonydto.BrideDTO;
import static com.xworkz.matrimonyApplication.Constants.Constants.*;

public class MatrimonyDAOImpl implements MatrimonyDAO {
	@Override
	public BrideDTO getById(int id) {
		BrideDTO bride = new BrideDTO();
		try (Connection con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)) {
			System.out.println("connected to db");
			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from matrimony.bride where id=1;");
			resultSet.next();
			bride.setId(resultSet.getInt(1));
			bride.setName(resultSet.getNString(2));
			bride.setAge(resultSet.getInt(3));
			bride.setHeight(resultSet.getDouble(4));
			bride.setWeight(resultSet.getDouble(5));
			bride.setQualification(resultSet.getString(6));
			bride.setExpectation(resultSet.getString(7));
			bride.setPhone_number(resultSet.getString(8));
			bride.setSalary(resultSet.getDouble(9));
			bride.setOccupatation(resultSet.getString(10));
		} catch (SQLException e) {
			System.out.println("failed to connect");
			e.printStackTrace();
		}
		return bride;
	}

	@Override
	public BrideDTO getAll() {
		BrideDTO bride = new BrideDTO();
		try (Connection con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)) {
			System.out.println("Connected to Data Base");
			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("Select * from matrimony.bride");
			while (resultSet.next()) {
				bride.setId(resultSet.getInt(1));
				bride.setName(resultSet.getNString(2));
				bride.setAge(resultSet.getInt(3));
				bride.setHeight(resultSet.getDouble(4));
				bride.setWeight(resultSet.getDouble(5));
				bride.setQualification(resultSet.getString(6));
				bride.setExpectation(resultSet.getString(7));
				bride.setPhone_number(resultSet.getString(8));
				bride.setSalary(resultSet.getDouble(9));
				bride.setOccupatation(resultSet.getString(10));
				System.out.println(bride);
			}
		} catch (SQLException e) {
			System.out.println("not connected to DB");
			e.printStackTrace();
		}
		return bride;
	}

	@Override
	public int create(BrideDTO bride) {
		int result = 0;
		try (Connection con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)) {
			System.out.println("connected with db");
			PreparedStatement stmt = con.prepareStatement("insert into matrimony.bride values(?,?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1, bride.getId());
			stmt.setString(2, bride.getName());
			stmt.setInt(3, bride.getAge());
			stmt.setDouble(4, bride.getHeight());
			stmt.setDouble(5, bride.getWeight());
			stmt.setString(6, bride.getQualification());
			stmt.setString(7, bride.getExpectation());
			stmt.setString(8, bride.getPhone_number());
			stmt.setDouble(9, bride.getSalary());
			stmt.setString(10, bride.getOccupatation());

			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("connection falied");
		}
		return result;

	}

	@Override
	public int updatePhone(String phone_Number, int id) {
		int result = 0;
		try (Connection con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)) {
			System.out.println("connected with db");
			PreparedStatement stmt = con.prepareStatement("update matrimony.bride set Phone_Number=? where id=?;");
			stmt.setString(1, phone_Number);
			stmt.setInt(2, id);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(int id) {

		int result = 0;
		try (Connection con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)) {
			System.out.println("connected with db");
			PreparedStatement stmt = con.prepareStatement("delete from matrimony.bride where id=?;");
			stmt.setInt(1, id);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("connection failed");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int[] insertBride(List<BrideDTO> brides) {
		int[] result = new int[brides.size()];
		try (Connection con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)) {
			
			Statement stmt = con.createStatement();
			for (BrideDTO dto : brides) {
				String query = String.format(INSERT_QUERY, dto.getId(), dto.getName(), dto.getAge(), dto.getHeight(),
						dto.getWeight(), dto.getQualification(),dto.getExpectation(), dto.getSalary(), dto.getPhone_number(),
						dto.getOccupatation());
				stmt.addBatch(query);

			}
			result = stmt.executeBatch();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int[] updateBride(List<BrideDTO> brides) {
		int[] results = new int[brides.size()];
		try (Connection con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)){
			PreparedStatement pstmt= con.prepareStatement(UPDATE_QUERY);
			 for (BrideDTO dto : brides) {
				pstmt.setString(1, dto.getQualification());
				pstmt.setDouble(2, dto.getSalary());
				pstmt.setInt(3, dto.getId());
				
				//adding into batch
				pstmt.addBatch();
			}
			 results=pstmt.executeBatch();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}


	@Override
	public int[] deleteBridesUsingPreparedStmt(List<Integer> ids) {
		int[] results =new int[ids.size()];
		try (Connection con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)){
			PreparedStatement pstmt= con.prepareStatement(DELETE_QUERY);
			for (Integer id: ids) {
				pstmt.setInt(1, id);
				
				pstmt.addBatch();
			}
			results = pstmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
	}
		return results;
}
	}
