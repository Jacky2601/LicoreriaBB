package mantenimiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import interfaces.DetalleVentaInterface;
import model.DetalleVenta;
import utils.MySQLConexion8;

public class GestionDetalleVenta implements DetalleVentaInterface {

	@Override
	public int registrarDetalleVenta(DetalleVenta detalleVenta) {
		int id_detalleVenta = -1;

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion8.getConexion();
			String sql = "INSERT INTO tb_detalle_venta (id_detalleVenta, id_venta, id_producto, cantidad, subtotal) VALUES (null, ?, ?, ?, ?)";
			pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			pst.setInt(1, detalleVenta.getId_venta());
			pst.setInt(2, detalleVenta.getId_producto());
			pst.setInt(3, detalleVenta.getCantidad());
			pst.setDouble(4, detalleVenta.getSubtotal());

			int filasAfectadas = pst.executeUpdate();

			if (filasAfectadas > 0) {
				rs = pst.getGeneratedKeys();
				if (rs.next()) {
					id_detalleVenta = rs.getInt(1);
				}
			}

		} catch (Exception e) {
			System.out.println("Error al registrar detalle de venta: " + e.getMessage());
		} finally {
			MySQLConexion8.closeConexion(con);
		}
		return id_detalleVenta;
	}

	@Override
	public DetalleVenta leerDetalleVenta(int id_detalleVenta) {
		DetalleVenta detalleVenta = null;

	    Connection con = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;

	    try {
	        con = MySQLConexion8.getConexion();
	        String sql = "SELECT * FROM tb_detalle_venta WHERE id_detalleVenta = ?";
	        pst = con.prepareStatement(sql);
	        pst.setInt(1, id_detalleVenta);

	        rs = pst.executeQuery();

	        if (rs.next()) {
	            int id_venta = rs.getInt("id_venta");
	            int id_producto = rs.getInt("id_producto");
	            int cantidad = rs.getInt("cantidad");
	            double subtotal = rs.getDouble("subtotal");

	            detalleVenta = new DetalleVenta(id_detalleVenta, id_venta, id_producto, cantidad, subtotal);
	        }

	    } catch (Exception e) {
	        System.out.println("Error en leer detalle de venta: " + e.getMessage());
	    } finally {
	        MySQLConexion8.closeConexion(con);
	    }

	    return detalleVenta;
	}

	@Override
	public int actualizarDetalleVenta(DetalleVenta detalleVenta) {
		int filasAfectadas = 0;

	    Connection con = null;
	    PreparedStatement pst = null;

	    try {
	        con = MySQLConexion8.getConexion();
	        String sql = "UPDATE tb_detalle_venta SET id_venta = ?, id_producto = ?, cantidad = ?, subtotal = ? WHERE id_detalleVenta = ?";
	        pst = con.prepareStatement(sql);

	        pst.setInt(1, detalleVenta.getId_venta());
	        pst.setInt(2, detalleVenta.getId_producto());
	        pst.setInt(3, detalleVenta.getCantidad());
	        pst.setDouble(4, detalleVenta.getSubtotal());
	        pst.setInt(5, detalleVenta.getId_detalleVenta());

	        filasAfectadas = pst.executeUpdate();

	    } catch (Exception e) {
	        System.out.println("Error al actualizar detalle de venta: " + e.getMessage());
	    } finally {
	        MySQLConexion8.closeConexion(con);
	    }

	    return filasAfectadas;
	}

	@Override
	public int eliminarDetalleVenta(int id) {
		int filasAfectadas = 0;

	    Connection con = null;
	    PreparedStatement pst = null;

	    try {
	        con = MySQLConexion8.getConexion();
	        String sql = "DELETE FROM tb_detalle_venta WHERE id_detalleVenta = ?";
	        pst = con.prepareStatement(sql);
	        pst.setInt(1, id);

	        filasAfectadas = pst.executeUpdate();

	    } catch (Exception e) {
	        System.out.println("Error al eliminar detalle de venta: " + e.getMessage());
	    } finally {
	        MySQLConexion8.closeConexion(con);
	    }

	    return filasAfectadas;
	}

	@Override
	public ArrayList<DetalleVenta> listarDetalleVenta() {
		ArrayList<DetalleVenta> detallesVenta = new ArrayList<>();

	    Connection con = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;

	    try {
	        con = MySQLConexion8.getConexion();
	        String sql = "SELECT * FROM tb_detalle_venta";
	        pst = con.prepareStatement(sql);
	        rs = pst.executeQuery();

	        while (rs.next()) {
	            int id_detalleVenta = rs.getInt("id_detalleVenta");
	            int id_venta = rs.getInt("id_venta");
	            int id_producto = rs.getInt("id_producto");
	            int cantidad = rs.getInt("cantidad");
	            double subtotal = rs.getDouble("subtotal");

	            DetalleVenta detalleVenta = new DetalleVenta(id_detalleVenta, id_venta, id_producto, cantidad, subtotal);
	            
	            detallesVenta.add(detalleVenta);
	        }

	    } catch (Exception e) {
	        System.out.println("Error al listar detalles de venta: " + e.getMessage());
	    } finally {
	        MySQLConexion8.closeConexion(con);
	    }

	    return detallesVenta;
	}

	
}
