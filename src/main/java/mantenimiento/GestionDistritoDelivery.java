package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.DistritoDeliveryInterface;
import model.DistritoDelivery;
import utils.MySQLConexion8;

public class GestionDistritoDelivery implements DistritoDeliveryInterface{

	@Override
	public int registrar(DistritoDelivery d) {
		int rs = 0; //0 --> Error
		
		//Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "insert into tb_distritos values (?, ?, default)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, d.getIdDistrito());
			pst.setString(2, d.getNombreDistrito());
			//pst.setInt(3, d.getEstado());
					
			
			//ejecutar 
			
			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en registrar : " + e.getMessage());
			
		} finally {
			MySQLConexion8.closeConexion(con);
		}
		
		return rs ;
	}

	@Override
	public int actualizar(DistritoDelivery d) {
		int rs = 0; // 0 --> Error

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "Update tb_distritos set nom_distrito = ? where id_distrito = ?";

			pst = con.prepareStatement(sql);
			pst.setString(1, d.getNombreDistrito());
			pst.setInt(2, d.getIdDistrito());

			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en actualizar : " + e.getMessage());

		} finally {
			if (con != null) {
				MySQLConexion8.closeConexion(con);
			}
		}

		return rs;
	}

	@Override
	public int eliminar(int idDistrito) {
		int rs = 0; //0 --> Error
		
		//Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "update tb_distritos set estado = 2 where id_distrito = ?"; 
			pst = con.prepareStatement(sql);
			pst.setInt(1, idDistrito);
			
			//ejecutar 
			
			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en eliminar : " + e.getMessage());
			
		} finally {
			MySQLConexion8.closeConexion(con);
		}
		
		return rs ;
	}

	@Override
	public ArrayList<DistritoDelivery> listado() {
		
		ArrayList<DistritoDelivery> lista = null;
		
		//Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_distritos where estado = 1";
			pst = con.prepareStatement(sql);
						
			//ejecutar 
			
			rs = pst.executeQuery();
			
			lista = new ArrayList<DistritoDelivery>();
			while (rs.next()) {
				DistritoDelivery d = new DistritoDelivery(
										rs.getInt("id_distrito"), 
										rs.getString("nom_distrito"),
										rs.getInt("estado"));
								
				lista.add(d);
			}
			
		} catch (Exception e) {
			System.out.println("Error en listar : " + e.getMessage());
			
		} finally {
			MySQLConexion8.closeConexion(con);
		}
		
		
		return lista ;
	}

	@Override
	public DistritoDelivery buscar(int idDistrito) {
		
		DistritoDelivery d = null;
		
		//Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_distritos where id_distrito = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, idDistrito);
			
			rs = pst.executeQuery();
			
			
			if (rs.next()) {
			 d = new DistritoDelivery(rs.getInt(1), 
					 					rs.getString(2),
					 					rs.getInt(3));
				
			}
			
		} catch (Exception e) {
			System.out.println("Error en buscar : " + e.getMessage());
			
		} finally {
			MySQLConexion8.closeConexion(con);
		}
		
		return d;
	}

}
