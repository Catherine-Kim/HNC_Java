package team2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import team2.config.DBInfo;
import team2.exception.DuplicateIdException;
import team2.exception.DuplicateModelException;
import team2.exception.RecordNotFoundException;
import team2.vo.CarOrderVO;
import team2.vo.CarVO;
import team2.vo.CustomerVO;

public class CarOrderDAO {
	// 공통적인 부분
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(DBInfo.url, DBInfo.user, DBInfo.pw);
		System.out.println("[SUCCESS] DB Connection");
		return conn;
	}

	private void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}

	private void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}

	// Business Logic
	private boolean idExists(String custId, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select custid from customer where custid = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, custId);
		rs = ps.executeQuery();

		return rs.next();
	}

	private boolean modelExists(String model, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select model from car where model = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, model);
		rs = ps.executeQuery();

		return rs.next();
	}

	public void updateCustomer(CustomerVO cust) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = getConnection();
			if (idExists(cust.getCustId(), conn)) {
				String sql = "UPDATE customer SET name=?, address=? WHERE custId=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, cust.getName());
				ps.setString(2, cust.getAddress());
				ps.setString(3, cust.getCustId());
				System.out.println(ps.executeUpdate() + " row update..");
			} else {
				throw new RecordNotFoundException("수정할 대상이 없습니다..");
			}

		} finally {
			closeAll(ps, conn);
		}
	}

	public void addCust(CustomerVO cust) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		try {
			if (!idExists(cust.getCustId(), conn)) {
				String sql = "INSERT INTO CUSTOMER VALUES(?,?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, cust.getCustId());
				ps.setString(2, cust.getName());
				ps.setString(3, cust.getAddress());
				ps.setString(4, cust.getTel());
				System.out.println(ps.executeUpdate() + " row inserted");
			} else {
				throw new DuplicateIdException("Customer table에 이미 " + cust.getName() + "님이 존재합니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			closeAll(ps, conn);
		}
	}

	public void delCust(String id) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			if (idExists(id, conn)) {
				String sql = "DELETE FROM customer WHERE custID=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				System.out.println(ps.executeUpdate() + " row deleted");
			}else{
				throw new RecordNotFoundException();
			}
		} finally {
			closeAll(ps, conn);
		}
	}

	public ArrayList<CustomerVO> getAllMember() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<CustomerVO> list = new ArrayList<CustomerVO>();
		try {
			conn = getConnection();
			String sql = "select custid, name, address, tel from customer";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new CustomerVO(rs.getString("custid"), rs.getString("name"), rs.getString("address"),
						rs.getString("tel")));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

	public void buyCar(String model, String custId, int count) throws SQLException {
		// local variables
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CarOrderVO order = new CarOrderVO();

		// Customer Exception
		try {
			conn = getConnection();
			String sql = "select count from carorder where custid = ? and model = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, custId);
			ps.setString(2, model);
			rs = ps.executeQuery();
			if(rs.next()){		// 기존에 같은 Car를 샀을 때
				
				String sql2 = "update carorder set count = ? where custid = ? and model = ?";
				int c = rs.getInt(1);
				int newC = c + count;
				
				ps = conn.prepareStatement(sql2);
				ps.setInt(1, newC);
				ps.setString(2, custId);
				ps.setString(3, model);
		
				System.out.println(ps.executeUpdate() + " row updated - buyCar()");
			}else{				// 이 Car를 처음 사는 것일 때
				String sql2 = "insert into carorder values(?, ?, ?)";
				ps = conn.prepareStatement(sql2);
				ps.setString(1, model);
				ps.setString(2, custId);
				ps.setInt(3, count);
				System.out.println(custId+"\t"+model+"\t"+count);
				System.out.println(ps.executeUpdate() + " row inserted - buyCar()");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// Closing
			closeAll(ps, conn);
		}
	}

	public void printAllOrders(String Custid) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;

		conn = getConnection();
		String addQuery = "select * from CarOder where custid =? ";
		ps = conn.prepareStatement(addQuery);
		ps.setString(1, Custid);

		ResultSet rs = ps.executeQuery();

		while (rs.next())
			System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));

		closeAll(rs, ps, conn);
	}

	public void addCar(CarVO vo) throws SQLException, DuplicateModelException {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnection();
		try {
			if (!modelExists(vo.getModel(), conn)) {
				String sql = "INSERT INTO CAR VALUES(?,?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, vo.getModel());
				ps.setString(2, vo.getColor());
				ps.setInt(3, vo.getPrice());
				ps.setString(4, vo.getBrand());
				System.out.println(ps.executeUpdate() + " row inserted");
			} else {
				throw new DuplicateModelException();
			}
		} finally {
			conn.close();
		}
	}

	public void delCar(String model) throws RecordNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			if (modelExists(model, conn)) {

				String sql = "DELETE FROM CAR WHERE MODEL=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, model);
				System.out.println(ps.executeUpdate() + " row deleted");
			} else {
				throw new RecordNotFoundException();
			}
		} finally {
			conn.close();
		}
	}

	public void updatecar(CarVO car) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			if (modelExists(car.getModel(), conn)) {
				String sql = "UPDATE CAR SET color=?, price=?, brand=? WHERE model=?";

				ps = conn.prepareStatement(sql);

				ps.setString(1, car.getColor());

				ps.setInt(2, car.getPrice());

				ps.setString(3, car.getBrand());

				ps.setString(4, car.getModel());

				System.out.println(ps.executeUpdate() + " row update..");
			} else {
				throw new RecordNotFoundException("수정할 대상이 없습니다..^^");
			}
		} finally {
			conn.close();
		}
	}

	public void getAllCar() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;

		conn = getConnection();

		String addQuery = "select model, color, price, brand from Car ";
		ps = conn.prepareStatement(addQuery);
		ResultSet rs = ps.executeQuery();

		while (rs.next())
			System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));

		closeAll(rs, ps, conn);
	}
}
