package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.UsuarioInterface;
import model.Usuario;
import utils.MySQLConexion8;

public class GestionUsuario implements UsuarioInterface{

	@Override
	public Usuario validar(String usuario, String clave) {
		Usuario u = null;
		// Plantilla de BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null; 
		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call usp_validaAcceso(?,?)}";
			pst = con.prepareStatement(sql);
			pst.setString(1, usuario);
			pst.setString(2, clave);
			
			rs = pst.executeQuery();
			
			
			if (rs.next()) {
				u = new Usuario();
				u.setIdUsuario(rs.getInt(1));
				u.setNombre(rs.getString(2));
				u.setApellidoPat(rs.getString(3));
				u.setApellidoMat(rs.getString(4));
				u.setUsuario(usuario);
				u.setClave(clave);
				u.setTipo(rs.getInt(7));
				u.setEstado(rs.getInt(8));
			}
			
		} catch (Exception e) {
			System.out.println("Error en validar : " + e.getMessage());
			
		} finally {
			MySQLConexion8.closeConexion(con);
		}
		
		return u;
	}

	@Override
	public int registrar(Usuario u) {
		
		int rs = 0; //0 --> Error
		
		//Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "insert into tb_usuarios values (?,?,?,?,?,?,?,default)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, u.getIdUsuario());
			pst.setString(2, u.getNombre());
			pst.setString(3, u.getApellidoPat());
			pst.setString(4, u.getApellidoMat());
			pst.setString(5, u.getUsuario());
			pst.setString(6, u.getClave());
			pst.setInt(7, u.getTipo());
			//pst.setInt(8, u.getEstado());
			
			//ejecutar 
			
			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al registrar : " + e.getMessage());
			
		} finally {
			MySQLConexion8.closeConexion(con);
		}
		
		return rs ;
	}

	@Override
	public int actualizar(Usuario u) {
		int rs = 0;

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "update tb_usuarios set nombre = ?, ape_paterno = ?, ape_materno = ?, usuario = ?, clave = ?, tipoid = ?, estado = default where id_usuario = ?";
			pst = con.prepareStatement(sql);
						
			pst.setString(1, u.getNombre());
			pst.setString(2, u.getApellidoPat());
			pst.setString(3, u.getApellidoMat());
			pst.setString(4, u.getUsuario());
			pst.setString(5, u.getClave());
			pst.setInt(6, u.getTipo());
			pst.setInt(7, u.getIdUsuario());
				
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
	public int eliminar(int idUsuario) {
		int rs = 0; //0 --> Error
		
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "update tb_usuarios set estado = 2 where id_usuario = ?"; 
			pst = con.prepareStatement(sql);
			pst.setInt(1, idUsuario);

			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en eliminar : " + e.getMessage());
			
		} finally {
			MySQLConexion8.closeConexion(con);
		}
		
		return rs ;
	}

	@Override
	public ArrayList<Usuario> listado() {
		ArrayList<Usuario> lista = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_usuarios where estado = 1";
			pst = con.prepareStatement(sql);
						
			rs = pst.executeQuery();
			
			lista = new ArrayList<Usuario>();
			while (rs.next()) {
				Usuario u = new Usuario(
										rs.getInt("id_usuario"), 
										rs.getString("nombre"),
										rs.getString("ape_paterno"),
										rs.getString("ape_materno"),
										rs.getString("usuario"),
										rs.getString("clave"),
										rs.getInt("tipoid")
										);
				
								
				lista.add(u);
			}
			
		} catch (Exception e) {
			System.out.println("Error en listar : " + e.getMessage());
			
		} finally {
			MySQLConexion8.closeConexion(con);
		}
				
		return lista ;
	}

	@Override
	public Usuario buscar(int idUsuario) {
		Usuario u = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_usuarios where id_usuario = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, idUsuario);
			
			rs = pst.executeQuery();
						
			if (rs.next()) {
			 u = new Usuario(rs.getInt("id_usuario"),
		             		 rs.getString("nombre"),
		             		 rs.getString("apellido_pat"),
		             		 rs.getString("apellido_mat"),
		             		 rs.getString("usuario"),
		             		 rs.getString("clave"),
		             		 rs.getInt("tipoid")
					 		 );
				
			}
			
		} catch (Exception e) {
			System.out.println("Error en buscar : " + e.getMessage());
			
		} finally {
			MySQLConexion8.closeConexion(con);
		}
		
		return u;
	}

	@Override
	public Usuario obtenerUsuarioPorId(int idUsuario) {
		Usuario u = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_usuarios where id_usuario = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, idUsuario);
			
			rs = pst.executeQuery();
						
			if (rs.next()) {
			 u = new Usuario(
			 rs.getInt("id_usuario"),
             rs.getString("nombre"),
             rs.getString("apellido_pat"),
             rs.getString("apellido_mat"),
             rs.getString("usuario"),
             rs.getString("clave"),
             rs.getInt("tipoid")
             );
			}
			
		} catch (Exception e) {
			System.out.println("Error en buscar : " + e.getMessage());
			
		} finally {
			MySQLConexion8.closeConexion(con);
		}
		
		return u;
	}
	

}
