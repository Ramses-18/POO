/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.persistencia;

import java.util.List;
import library.entidades.Autor;

/**
 *
 * @author tomyv
 */
public class DAOAutor extends DAO {

    public void crearAutor(Autor a) {
        super.guardar(a);
    }

    public boolean verificarNombreAutor(Autor a) {
        try {
            conectar();
            String sql = "SELECT a FROM Autor a WHERE a.nombre LIKE :name";
            List<Autor> autores = em.createQuery(sql).setParameter("name", a.getNombre()).getResultList();
            if (autores == null) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void bajarAutor(Autor a) {
        try {
            conectar();
            Autor aut = em.find(Autor.class, a.getId());
            if (aut == null) {
                System.out.println("No existe el Libro");
            } else {
                if (aut.getAlta()) {
                    aut.setAlta(Boolean.FALSE);
                    editar(aut);
                    System.out.println("Autor Bajado exitosamente");
                } else {
                    System.out.println("Este Autor ha sido previamente Bajado");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void subirAutor(Autor a) {
        try {
            conectar();
            Autor aut = em.find(Autor.class, a.getId());
            if (aut == null) {
                System.out.println("No existe el Libro");
            } else {
                if (!aut.getAlta()) {
                    aut.setAlta(Boolean.TRUE);
                    editar(aut);
                    System.out.println("Autor Subido exitosamente");
                } else {
                    System.out.println("Este Autor ha sido previamente Subido");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void editarAutor(Autor a) {
        try {
            conectar();
            Autor aut = em.find(Autor.class, a.getId());
            if (aut == null) {
                System.out.println("Autor no existente");
            } else {
                aut.setNombre(a.getNombre());
                editar(aut);
                System.out.println("Autor exitosamente Editado");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Autor buscarAutor(Autor a) {
        try {
            conectar();
            Autor autor = em.find(Autor.class, a.getId());
            if (autor == null) {
                System.out.println(a.getId() + " NO se encuentra en la Base De Datos");
            } else {
                System.out.println(autor.toString());
                return autor;
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    public List listarAutor() {
        try {
            conectar();
            String query = "SELECT a FROM Autor a";
            List<Autor> lista = em.createQuery(query).getResultList();
            return lista;
        } catch (Exception e) {
            throw e;
        }
    }

    public void buscarAutorPorNombre(Autor a) {
        try {
            conectar();
            String query = "SELECT a FROM Autor a WHERE a.nombre LIKE :NOMBRE";
            List<Autor> x = em.createQuery(query).setParameter("NOMBRE", a.getNombre()).getResultList();
            if (x == null) {
                System.out.println("El autor no se encuentra en la base de datos");
            } else {
                System.out.println(x.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void buscarAutorPorId(Autor a) {
        try {
            conectar();
            String query = "SELECT a FROM Autor a WHERE a.id LIKE :id";
            List<Autor> x = em.createQuery(query).setParameter("id", a.getId()).getResultList();
            if (x == null) {
                System.out.println("El autor no se encuentra en la base de datos");
            } else {
                System.out.println(x.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
