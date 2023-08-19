package mantenimiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import interfaces.VentaInterface;
import model.Venta;
import utils.MySQLConexion8;

public class GestionVenta implements VentaInterface{

	@Override
	public int registrarVenta(Venta venta) {
		int id_venta = -1;
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
        try {
        	con = MySQLConexion8.getConexion();
        	String sql = "insert into tb_venta (id_venta, fecha, nombre, apellido, celular, dni, direccion, observaciones, id_distrito, metodo_pago) values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setDate(1, venta.getFecha());
            pst.setString(2, venta.getNombre());
            pst.setString(3, venta.getApellido());
            pst.setString(4, venta.getCelular());
            pst.setString(5, venta.getDni());
            pst.setString(6, venta.getDireccion());
            pst.setString(7, venta.getObservaciones());
            pst.setInt(8, venta.getIdDistrito());
            pst.setString(9, venta.getMetodo_pago());
                              
                        
            int filasAfectadas = pst.executeUpdate();
            
            if(filasAfectadas > 0) {
            	rs = pst.getGeneratedKeys();
            	if(rs.next()) {
            		id_venta = rs.getInt(1);
            	}
            }
            
        } catch (Exception e) {
        	System.out.println("Error al registrar : " + e.getMessage());
        }finally {
			MySQLConexion8.closeConexion(con);
		}
        return id_venta;
	}

	@Override
	public Venta leerVenta(int id_venta) {
		Venta ventaRpta = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
        try {
        	con = MySQLConexion8.getConexion();
            String sql = "SELECT * FROM tb_venta WHERE id_venta = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, id_venta);
            
            rs = pst.executeQuery();
            
            if (rs.next()) {
            	java.sql.Date fecha = rs.getDate("fecha");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String celular = rs.getString("celular");
                String dni = rs.getString("dni");
                String direccion = rs.getString("direccion");
                String observaciones = rs.getString("observaciones");
                int idDistrito = rs.getInt("id_distrito");
                String metodo_pago = rs.getString("metodo_pago");
                
                ventaRpta = new Venta(id_venta, fecha, nombre, apellido, celular, dni, direccion, observaciones, idDistrito, metodo_pago);
            }
        } catch (Exception e) {
        	System.out.println("Error en leer: " + e.getMessage());
        } finally {
			MySQLConexion8.closeConexion(con);
		}
        return ventaRpta;
	}

	@Override
	public int actualizarVenta(Venta venta) {
		int filasAfectadas  = 0;
		
		Connection con = null;
		PreparedStatement pst = null;
		        
        try {
        	con = MySQLConexion8.getConexion();
        	String sql = "UPDATE tb_venta SET fecha = ?, nombre = ?, apellido = ?, celular = ?, dni = ?, direccion = ?, observaciones = ?, id_distrito = ?, metodo_pago = ? WHERE id_venta = ?";
            pst = con.prepareStatement(sql);
            
            pst.setDate(1, venta.getFecha());
            pst.setString(2, venta.getNombre());
            pst.setString(3, venta.getApellido());
            pst.setString(4, venta.getCelular());
            pst.setString(5, venta.getDni());
            pst.setString(6, venta.getDireccion());
            pst.setString(7, venta.getObservaciones());
            pst.setInt(8, venta.getIdDistrito());
            pst.setString(9, venta.getMetodo_pago());
            pst.setInt(10, venta.getId_venta());
            
            filasAfectadas = pst.executeUpdate();
            
        } catch (Exception e) {
        	System.out.println("Error al actualizar : " + e.getMessage());
        }finally {
			MySQLConexion8.closeConexion(con);
		}
        
        return filasAfectadas ;
	}

	@Override
	public int eliminarVenta(int id_venta) {
		int filasAfectadas = 0;

	    Connection con = null;
	    PreparedStatement pst = null;

	    try {
	        con = MySQLConexion8.getConexion();
	        String sql = "DELETE FROM tb_venta WHERE id_venta = ?";
	        pst = con.prepareStatement(sql);
	        pst.setInt(1, id_venta);

	        filasAfectadas = pst.executeUpdate();

	    } catch (Exception e) {
	        System.out.println("Error al eliminar: " + e.getMessage());
	    } finally {
	        MySQLConexion8.closeConexion(con);
	    }

	    return filasAfectadas;
	}

	@Override
	public ArrayList<Venta> listarVenta() {
		ArrayList<Venta> ventas = new ArrayList<>();

	    Connection con = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;

	    try {
	        con = MySQLConexion8.getConexion();
	        String sql = "SELECT * FROM tb_venta";
	        pst = con.prepareStatement(sql);
	        rs = pst.executeQuery();

	        while (rs.next()) {
	            int id = rs.getInt("id_venta");
	            java.sql.Date fecha = rs.getDate("fecha");
	            String nombre = rs.getString("nombre");
	            String apellido = rs.getString("apellido");
	            String celular = rs.getString("celular");
	            String dni = rs.getString("dni");
	            String direccion = rs.getString("direccion");
	            String observaciones = rs.getString("observaciones");
	            int idDistrito = rs.getInt("id_distrito");
	            String metodo_pago = rs.getString("metodo_pago");

	            Venta venta = new Venta(id, fecha, nombre, apellido, celular, dni, direccion, observaciones, idDistrito, metodo_pago);
	            ventas.add(venta);
	        }

	    } catch (Exception e) {
	        System.out.println("Error al listar: " + e.getMessage());
	    } finally {
	        MySQLConexion8.closeConexion(con);
	    }

	    return ventas;
	}

}
