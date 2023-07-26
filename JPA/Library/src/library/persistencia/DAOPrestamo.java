/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.persistencia;

import java.util.List;
import library.entidades.Prestamo;

/**
 *
 * @author tomyv
 */
public class DAOPrestamo extends DAO {

    public void crearPrestamo(Prestamo p) {
        super.guardar(p);
    }

    public void bajarPrestamo(Prestamo p) {
        try {
            conectar();
            Prestamo pre = em.find(Prestamo.class, p.getId());
            if (pre == null) {
                System.out.println("No existe el Prestamo");
            } else {
                if (pre.getAlta()) {
                    pre.setAlta(Boolean.FALSE);
                    editar(pre);
                    System.out.println("Prestamo Bajado exitosamente");
                } else {
                    System.out.println("Este Prestamo ha sido previamente Bajado");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void subirPrestamo(Prestamo p) {
        try {
            conectar();
            Prestamo pre = em.find(Prestamo.class, p.getId());
            if (pre == null) {
                System.out.println("No existe el Prestamo");
            } else {
                if (!pre.getAlta()) {
                    pre.setAlta(Boolean.TRUE);
                    editar(pre);
                    System.out.println("Prestamo Subido exitosamente");
                } else {
                    System.out.println("Este Prestamo ha sido previamente Subido");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Prestamo buscarPrestamo(Prestamo p) {
        try {
            conectar();
            Prestamo Prestamo = em.find(Prestamo.class, p.getId());
            if (Prestamo == null) {
                System.out.println(p.getId() + " NO se encuentra en la Base De Datos");
            } else {
                System.out.println(Prestamo.toString());
                return Prestamo;
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    public List listarPrestamo() {
        try {
            conectar();
            String query = "SELECT a FROM Prestamo a";
            List<Prestamo> lista = em.createQuery(query).getResultList();
            if (lista == null) {
                System.out.println("No se Cargo ningun prestamos a la Base de Datos");
            } else {
                for (Prestamo aux : lista) {
                    System.out.println(aux.toString());
                }
            }

            return lista;
        } catch (Exception e) {
            throw e;
        }
    }

    public void buscarPrestamoPorId(Prestamo p) {
        try {
            conectar();
            String query = "SELECT a FROM Prestamo a WHERE a.dni LIKE :NOMBRE";
            List<Prestamo> x = em.createQuery(query).setParameter("NOMBRE", p.getId()).getResultList();
            if (x == null) {
                System.out.println("El Prestamo no se encuentra en la base de datos");
            } else {
                System.out.println(x.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List buscarPrestamoPorIdCliente(Prestamo p) {
        try {
            conectar();
            String query = "SELECT a FROM Prestamo a WHERE a.cliente_id LIKE :id";
            List<Prestamo> x = em.createQuery(query).setParameter("id", p.getCliente().getId()).getResultList();
            if (x == null) {
                System.out.println("El Prestamo no se encuentra en la base de datos");
            } else {
                System.out.println(x.toString());
            }
            return x;
        } catch (Exception e) {
            throw e;
        }
    }

    public List buscarPrestamoPorIdLibro(Prestamo p) {
        try {
            conectar();
            String query = "SELECT a FROM Prestamo a WHERE a.libro_isbn LIKE :id";
            List<Prestamo> x = em.createQuery(query).setParameter("id", p.getLibro().getId()).getResultList();
            if (x == null) {
                System.out.println("El Prestamo no se encuentra en la base de datos");
            } else {
                for (Prestamo prestamo : x) {
                    System.out.println(prestamo.toString());
                }
            }
            return x;
        } catch (Exception e) {
            throw e;
        }
    }
    
}
