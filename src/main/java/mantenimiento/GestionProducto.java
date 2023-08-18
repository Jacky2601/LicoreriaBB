package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import interfaces.ProductoInterface;
import model.Producto;
import utils.MySQLConexion8;

public class GestionProducto implements ProductoInterface{

	Connection con = null;
	PreparedStatement pst = null;
	
	
	@Override
	public Producto buscarProductoPorId(int id_producto) {
		Producto producto = null;
        ResultSet rs = null;

        try {
            con = MySQLConexion8.getConexion();
            String sql = "SELECT * FROM tb_productos WHERE id_producto = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, id_producto);

            rs = pst.executeQuery();

            if (rs.next()) {
                producto = new Producto();
                producto.setId_producto(rs.getInt(1));
                producto.setMarca_prod(rs.getString(2));
                producto.setId_categoria(rs.getInt(3));
                producto.setDescripcion(rs.getString(4));
                producto.setPrecio(rs.getDouble(5));
                producto.setStock(rs.getInt(6));
            }

        } catch (Exception e) {
            System.out.println("Error en buscarProductoPorId : " + e.getMessage());
        } finally {
            // Cerrar los recursos adecuadamente en el bloque finally
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar recursos : " + e.getMessage());
            }
            // Cerrar la conexión en un bloque de finally adicional
            MySQLConexion8.closeConexion(con);
        }

        return producto;
    
	}
	
	@Override
	public int agregarProducto(Producto producto) {
		//error -->0
		int rs = 0; 
			
		try {
			con = MySQLConexion8.getConexion();
			String sql = "insert into tb_productos values (?, ?, ?, ?, ?, ?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, producto.getId_producto());
			pst.setString(2, producto.getMarca_prod());
			pst.setInt(3, producto.getId_categoria());
			pst.setString(4, producto.getDescripcion());
			pst.setDouble(5, producto.getPrecio());
			pst.setInt(6, producto.getStock());
			
			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error al agregar el producto : " + e.getMessage());
		}finally {
			MySQLConexion8.closeConexion(con);
		}
		
		return rs;
		
	}

	@Override
	public ArrayList<Producto> listarProducto() {
		
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
	        		+ "WHERE p.estado = 1";
	        pst = con.prepareStatement(sql);

	        // Ejecutar la consulta
	        rs = pst.executeQuery();
	        lista = new ArrayList<Producto>();
	        while (rs.next()) {
	            Producto p = new Producto(
	            			rs.getInt("id_producto"),
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
	public int actualizarProducto(Producto producto) {
			//error -->0
			int rs = 0; 
				
			try {
				con = MySQLConexion8.getConexion();
				String sql = "UPDATE tb_productos SET marca_prod=?, id_categoria=?, descripcion=?, precio=?, stock=? WHERE id_producto=?";
				pst = con.prepareStatement(sql);
				pst.setInt(1, producto.getId_producto());
				pst.setString(2, producto.getMarca_prod());
				pst.setInt(3, producto.getId_categoria());
				pst.setString(4, producto.getDescripcion());
				pst.setDouble(5, producto.getPrecio());
				pst.setInt(6, producto.getStock());
				
				rs = pst.executeUpdate();
				
			} catch (Exception e) {
				System.out.println("Error al actualizar datos del producto : " + e.getMessage());
			}finally {
				MySQLConexion8.closeConexion(con);
			}
				
			return rs;
		
	}

	@Override
	public int eliminarProducto(int id_producto) {
		//error -->0
		int rs = 0; 
		
        try {
        	con = MySQLConexion8.getConexion();
        	String sql = "DELETE FROM productos WHERE id_producto=?";
        	pst = con.prepareStatement(sql);
            pst.setInt(1, id_producto);

        	rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al eliminar el producto : " + e.getMessage());
		}
        
        return rs;
	}

	
	

}
