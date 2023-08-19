package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import interfaces.ProductoInterface;
import model.Producto;
import utils.MySQLConexion8;

public class GestionProducto implements ProductoInterface{

	@Override
	public int registrar(Producto p) {
		int rs = 0; 
				
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "insert into tb_productos values (?,?,?,?,?,?,default)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, p.getId_producto());
			pst.setInt(2, p.getId_categoria());
			pst.setString(3, p.getMarca_prod());
			pst.setString(4, p.getDescripcion());
			pst.setDouble(5, p.getPrecio());	
			pst.setInt(6, p.getStock());
			//pst.setInt(7, p.getEstado());
								
			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error al registrar : " + e.getMessage());
			
		} finally {
			MySQLConexion8.closeConexion(con);
		}
		
		return rs ;
	}

	@Override
	public int actualizar(Producto p) {
		int rs = 0;
		
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "update tb_productos set id_categoria = ?, marca_prod=?, descripcion = ?,  precio = ?, stock = ?, estado = ? where id_producto = ?";
			pst = con.prepareStatement(sql);
			
			pst.setInt(1, p.getId_categoria());
			pst.setString(2, p.getMarca_prod());
			pst.setString(3, p.getDescripcion());
			pst.setDouble(4, p.getPrecio());	
			pst.setInt(5, p.getStock());
			pst.setInt(6, p.getEstado());
			pst.setInt(7, p.getId_producto());
			
			
			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al actualizar : " + e.getMessage());

		} finally {
			MySQLConexion8.closeConexion(con);
		}

		return rs;
	}

	@Override
	public int eliminar(int id_producto) {
		
		int rs = 0; 
		
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "update tb_productos set estado = 2 where id_producto = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id_producto);
						
			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en eliminar : " + e.getMessage());
			
		} finally {
			MySQLConexion8.closeConexion(con);
		}
		
		return rs ;
		
	}

	@Override
	public ArrayList<Producto> listado() {
		ArrayList<Producto> lista = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_productos where estado = 1";
			pst = con.prepareStatement(sql);
						
			rs = pst.executeQuery();
			
			lista = new ArrayList<Producto>();
			while (rs.next()) {
				Producto p = new Producto(rs.getInt("id_producto"), 
										  rs.getInt("id_categoria"), 
										  rs.getString("marca_prod"),
										  rs.getString("descripcion"),
										  rs.getDouble("precio"),
										  rs.getInt("stock"),  
										  rs.getInt("estado"));
																
				lista.add(p);
			}
			
		} catch (Exception e) {
			System.out.println("Error en listar : " + e.getMessage());
			
		} finally {
			MySQLConexion8.closeConexion(con);
		}
				
		return lista ;
	}

	@Override
	public Producto buscar(int id_producto) {
		Producto p = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_productos where id_producto = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id_producto);
						
			rs = pst.executeQuery();
			
			
			if (rs.next()) {
			 p = new Producto(rs.getInt("id_producto"),
					 		  rs.getInt("id_categoria"), 
					 		  rs.getString("marca_prod"),
					 		  rs.getString("descripcion"),
					 		  rs.getDouble("precio"),
					 		  rs.getInt("stock"),  
					 		  rs.getInt("estado"));
			 			 
			}
			
		} catch (Exception e) {
			System.out.println("Error en buscar : " + e.getMessage());
			
		} finally {
			MySQLConexion8.closeConexion(con);
		}
				
		return p;
	}

	

}
