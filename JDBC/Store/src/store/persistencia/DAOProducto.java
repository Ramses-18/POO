/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.persistencia;

import java.util.List;
import javax.persistence.Query;
import store.entidades.Producto;

/**
 *
 * @author tomyv
 */
public class DAOProducto extends DAO {
    
    public void crearProducto(Producto a) {
        super.guardar(a);
    }

    public boolean verificarMismoProducto(Producto p) {
        try {
            conectar();
            String jpql = "SELECT a FROM Producto a WHERE a.nombre LIKE :name AND a.id_fabricante LIKE :precio";            
            Query query = em.createQuery(jpql);
            query.setParameter("precio",p.getPrecio());
            query.setParameter("name", p.getNombre());
            List<Producto> productos = query.getResultList();
            if (productos == null) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void bajarProducto(Producto a) {
        try {
            conectar();
            Producto producto = em.find(Producto.class, a.getId());
            if (producto == null) {
                System.out.println("No existe el Producto");
            } else {
                if (producto.getAlta()) {
                    producto.setAlta(Boolean.FALSE);
                    editar(producto);
                    System.out.println("Producto Bajado exitosamente");
                } else {
                    System.out.println("Este Producto ha sido previamente Bajado");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void subirProducto(Producto a) {
        try {
            conectar();
            Producto producto = em.find(Producto.class, a.getId());
            if (producto == null) {
                System.out.println("No existe el Producto");
            } else {
                if (!producto.getAlta()) {
                    producto.setAlta(Boolean.TRUE);
                    editar(producto);
                    System.out.println("Producto Subido exitosamente");
                } else {
                    System.out.println("Este Producto ha sido previamente Subido");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void editarProducto(Producto p, Integer op) {
        try {
            conectar();
            Producto producto = em.find(Producto.class, p.getId());
            if (producto == null) {
                System.out.println("Producto no existente");
            } else {
                switch (op) {
                    case 1:
                        producto.setNombre(p.getNombre());
                        break;
                    case 2:
                        producto.setPrecio(p.getPrecio());
                        break;
                    case 3:
                        producto.setFabricante(p.getFabricante());
                }
                editar(producto);
                System.out.println("Producto exitosamente Editado");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Producto buscarProducto(Producto a) {
        try {
            conectar();
            Producto producto = em.find(Producto.class, a.getId());
            if (producto == null) {
                System.out.println("Producto no encontrado en la Base De Datos");
            } else {
                System.out.println(producto.toString());
                return producto;
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    public List listarProducto() {
        try {
            conectar();
            String query = "SELECT a FROM Producto a";
            List<Producto> productos = em.createQuery(query).getResultList();
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public void buscarProductoPorNombre(Producto a) {
        try {
            conectar();
            String query = "SELECT a FROM Producto a WHERE a.nombre LIKE :NOMBRE";
            List<Producto> productos = em.createQuery(query).setParameter("NOMBRE", a.getNombre()).getResultList();
            if (productos == null) {
                System.out.println("El Producto no se encuentra en la base de datos");
            } else {
                System.out.println(productos.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean buscarProductoPorId(Producto a) {
        try {
            conectar();
            String query = "SELECT a FROM Producto a WHERE a.id LIKE :id";
            List<Producto> x = em.createQuery(query).setParameter("id", a.getId()).getResultList();
            if (x == null) {
                System.out.println("El Producto no se encuentra en la base de datos");
                return false;
            } else {
                System.out.println(x.toString());
                return true;
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
