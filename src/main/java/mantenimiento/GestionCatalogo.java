package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.CatalogoInterface;
import model.Producto;
import utils.MySQLConexion8;

public class GestionCatalogo implements CatalogoInterface {

	@Override
	public ArrayList<Producto> listarVino() {
		
		ArrayList<Producto> lista = null;
		//Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

	    try {
	        con = MySQLConexion8.getConexion();
	        String sql = "SELECT p.id_producto, c.nom_categoria, p.marca_prod, p.descripcion, p.precio, p.stock\r\n"
	        		+ "FROM tb_productos p\r\n"
	        		+ "JOIN tb_categorias c ON p.id_categoria = c.id_categoria\r\n"
	        		+ "WHERE p.estado = 1 AND p.id_categoria = 1";
	        pst = con.prepareStatement(sql);

	        // Ejecutar la consulta
	        rs = pst.executeQuery();
	        lista = new ArrayList<Producto>();
	        while (rs.next()) {
	            Producto p = new Producto(
	            			rs.getInt("id_producto"),
	            			rs.getString("nom_categoria"),
							rs.getString("marca_prod"),
							rs.getString("descripcion"), 
							rs.getDouble("precio"), 
							rs.getInt("stock"));
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
	public ArrayList<Producto> listarWhisky() {

		ArrayList<Producto> lista = null;
		//Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

	    try {
	        con = MySQLConexion8.getConexion();
	        String sql = "SELECT p.id_producto, c.nom_categoria, p.marca_prod, p.descripcion, p.precio, p.stock\r\n"
	        		+ "FROM tb_productos p\r\n"
	        		+ "JOIN tb_categorias c ON p.id_categoria = c.id_categoria\r\n"
	        		+ "WHERE p.estado = 1 AND p.id_categoria = 2";
	        pst = con.prepareStatement(sql);

	        // Ejecutar la consulta
	        rs = pst.executeQuery();
	        lista = new ArrayList<Producto>();
	        while (rs.next()) {
	            Producto p = new Producto(
	            			rs.getInt("id_producto"),
	            			rs.getString("nom_categoria"),
							rs.getString("marca_prod"),
							rs.getString("descripcion"), 
							rs.getDouble("precio"), 
							rs.getInt("stock"));
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
	public ArrayList<Producto> listarTequila() {

		ArrayList<Producto> lista = null;
		//Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

	    try {
	        con = MySQLConexion8.getConexion();
	        String sql = "SELECT p.id_producto, c.nom_categoria, p.marca_prod, p.descripcion, p.precio, p.stock\r\n"
	        		+ "FROM tb_productos p\r\n"
	        		+ "JOIN tb_categorias c ON p.id_categoria = c.id_categoria\r\n"
	        		+ "WHERE p.estado = 1 AND p.id_categoria = 3";
	        pst = con.prepareStatement(sql);

	        // Ejecutar la consulta
	        rs = pst.executeQuery();
	        lista = new ArrayList<Producto>();
	        while (rs.next()) {
	            Producto p = new Producto(
	            			rs.getInt("id_producto"),
	            			rs.getString("nom_categoria"),
							rs.getString("marca_prod"),
							rs.getString("descripcion"), 
							rs.getDouble("precio"), 
							rs.getInt("stock"));
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
	public ArrayList<Producto> listarRon() {

		ArrayList<Producto> lista = null;
		//Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

	    try {
	        con = MySQLConexion8.getConexion();
	        String sql = "SELECT p.id_producto, c.nom_categoria, p.marca_prod, p.descripcion, p.precio, p.stock\r\n"
	        		+ "FROM tb_productos p\r\n"
	        		+ "JOIN tb_categorias c ON p.id_categoria = c.id_categoria\r\n"
	        		+ "WHERE p.estado = 1 AND p.id_categoria = 4";
	        pst = con.prepareStatement(sql);

	        // Ejecutar la consulta
	        rs = pst.executeQuery();
	        lista = new ArrayList<Producto>();
	        while (rs.next()) {
	            Producto p = new Producto(
	            			rs.getInt("id_producto"),
	            			rs.getString("nom_categoria"),
							rs.getString("marca_prod"),
							rs.getString("descripcion"), 
							rs.getDouble("precio"), 
							rs.getInt("stock"));
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
	public ArrayList<Producto> listarChampange() {

		ArrayList<Producto> lista = null;
		//Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

	    try {
	        con = MySQLConexion8.getConexion();
	        String sql = "SELECT p.id_producto, c.nom_categoria, p.marca_prod, p.descripcion, p.precio, p.stock\r\n"
	        		+ "FROM tb_productos p\r\n"
	        		+ "JOIN tb_categorias c ON p.id_categoria = c.id_categoria\r\n"
	        		+ "WHERE p.estado = 1 AND p.id_categoria = 5";
	        pst = con.prepareStatement(sql);

	        // Ejecutar la consulta
	        rs = pst.executeQuery();
	        lista = new ArrayList<Producto>();
	        while (rs.next()) {
	            Producto p = new Producto(
	            			rs.getInt("id_producto"),
	            			rs.getString("nom_categoria"),
							rs.getString("marca_prod"),
							rs.getString("descripcion"), 
							rs.getDouble("precio"), 
							rs.getInt("stock"));
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
	public ArrayList<Producto> listarVodka() {

		ArrayList<Producto> lista = null;
		//Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

	    try {
	        con = MySQLConexion8.getConexion();
	        String sql = "SELECT p.id_producto, c.nom_categoria, p.marca_prod, p.descripcion, p.precio, p.stock\r\n"
	        		+ "FROM tb_productos p\r\n"
	        		+ "JOIN tb_categorias c ON p.id_categoria = c.id_categoria\r\n"
	        		+ "WHERE p.estado = 1 AND p.id_categoria = 6";
	        pst = con.prepareStatement(sql);

	        // Ejecutar la consulta
	        rs = pst.executeQuery();
	        lista = new ArrayList<Producto>();
	        while (rs.next()) {
	            Producto p = new Producto(
	            			rs.getInt("id_producto"),
	            			rs.getString("nom_categoria"),
							rs.getString("marca_prod"),
							rs.getString("descripcion"), 
							rs.getDouble("precio"), 
							rs.getInt("stock"));
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
	public ArrayList<Producto> listarGin() {

		ArrayList<Producto> lista = null;
		//Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

	    try {
	        con = MySQLConexion8.getConexion();
	        String sql = "SELECT p.id_producto, c.nom_categoria, p.marca_prod, p.descripcion, p.precio, p.stock\r\n"
	        		+ "FROM tb_productos p\r\n"
	        		+ "JOIN tb_categorias c ON p.id_categoria = c.id_categoria\r\n"
	        		+ "WHERE p.estado = 1 AND p.id_categoria = 7";
	        pst = con.prepareStatement(sql);

	        // Ejecutar la consulta
	        rs = pst.executeQuery();
	        lista = new ArrayList<Producto>();
	        while (rs.next()) {
	            Producto p = new Producto(
	            			rs.getInt("id_producto"),
	            			rs.getString("nom_categoria"),
							rs.getString("marca_prod"),
							rs.getString("descripcion"), 
							rs.getDouble("precio"), 
							rs.getInt("stock"));
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
	public ArrayList<Producto> listarPisco() {

		ArrayList<Producto> lista = null;
		//Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

	    try {
	        con = MySQLConexion8.getConexion();
	        String sql = "SELECT p.id_producto, c.nom_categoria, p.marca_prod, p.descripcion, p.precio, p.stock\r\n"
	        		+ "FROM tb_productos p\r\n"
	        		+ "JOIN tb_categorias c ON p.id_categoria = c.id_categoria\r\n"
	        		+ "WHERE p.estado = 1 AND p.id_categoria = 8";
	        pst = con.prepareStatement(sql);

	        // Ejecutar la consulta
	        rs = pst.executeQuery();
	        lista = new ArrayList<Producto>();
	        while (rs.next()) {
	            Producto p = new Producto(
	            			rs.getInt("id_producto"),
	            			rs.getString("nom_categoria"),
							rs.getString("marca_prod"),
							rs.getString("descripcion"), 
							rs.getDouble("precio"), 
							rs.getInt("stock"));
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
	public ArrayList<Producto> listarOtros() {

		ArrayList<Producto> lista = null;
		//Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

	    try {
	        con = MySQLConexion8.getConexion();
	        String sql = "SELECT p.id_producto, c.nom_categoria, p.marca_prod, p.descripcion, p.precio, p.stock\r\n"
	        		+ "FROM tb_productos p\r\n"
	        		+ "JOIN tb_categorias c ON p.id_categoria = c.id_categoria\r\n"
	        		+ "WHERE p.estado = 1 AND p.id_categoria = 9";
	        pst = con.prepareStatement(sql);

	        // Ejecutar la consulta
	        rs = pst.executeQuery();
	        lista = new ArrayList<Producto>();
	        while (rs.next()) {
	            Producto p = new Producto(
	            			rs.getInt("id_producto"),
	            			rs.getString("nom_categoria"),
							rs.getString("marca_prod"),
							rs.getString("descripcion"), 
							rs.getDouble("precio"), 
							rs.getInt("stock"));
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
	public Producto buscarIDS(int id_producto) {
		Producto p = null;
		
		//Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM tb_productos WHERE id_producto = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id_producto);
			//pst.setInt(2, 1);
			
			rs = pst.executeQuery();
			
			
			if (rs.next()) {
			 p = new Producto(
					 	rs.getInt("id_producto"),
         				rs.getString("nom_categoria"),
						rs.getString("marca_prod"),
						rs.getString("descripcion"), 
						rs.getDouble("precio"), 
						rs.getInt("stock"));
			}
			
		} catch (Exception e) {
			System.out.println("Error en buscar : " + e.getMessage());
			
		} finally {
			MySQLConexion8.closeConexion(con);
		}
				
		return p;

	}

}
