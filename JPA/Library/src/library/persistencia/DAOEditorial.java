/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.persistencia;

import java.util.List;
import library.entidades.Editorial;

/**
 *
 * @author tomyv
 */
public class DAOEditorial extends DAO {

    public void crearEditorial(Editorial ed) {
        super.guardar(ed);
    }

    public boolean verificarTitulo(Editorial e) {
        try {
            conectar();
            String sql = "SELECT e FROM Editorial e WHERE e.nombre LIKE :name";
            List<Editorial> editoriales = em.createQuery(sql).setParameter("name", e.getNombre()).getResultList();
            if (editoriales == null) {
                return false;
            } else {
                return true;
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void bajarEditorial(Editorial ed) throws Exception {
        try {
            conectar();
            Editorial e = em.find(Editorial.class, ed.getId());
            if (e == null) {
                System.out.println(ed.getId() + " NO se encuentra en la Base De Datos");
            } else {
                if (e.getAlta()) {
                    e.setAlta(false);
                    super.editar(e);
                    System.out.println("Editorial Bajada");
                } else {
                    System.out.println("Editorial Previamente Bajada");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void subirEditorial(Editorial ed) throws Exception {
        try {
            conectar();
            Editorial e = em.find(Editorial.class, ed.getId());
            if (e == null) {
                System.out.println(ed.getId() + " NO se encuentra en la Base De Datos");
            } else {
                if (!e.getAlta()) {
                    e.setAlta(true);
                    super.editar(e);
                    System.out.println("Editorial Subida");
                } else {
                    System.out.println("Editorial Previamente Subida");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void editarEditorial(Editorial ed) throws Exception {
        try {
            conectar();
            Editorial editorial = em.find(Editorial.class, ed.getId());
            if (editorial == null) {
                System.out.println(ed.getId() + " NO se encuentra en la Base De Datos");
            } else {
                editorial.setNombre(ed.getNombre());
                super.editar(editorial);
                System.out.println("Editorial Editada");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Editorial buscarEditorial(Editorial ed) {
        try {
            conectar();
            Editorial editorial = em.find(Editorial.class, ed.getId());
            if (editorial == null) {
                System.out.println(ed.getId() + " NO se encuentra en la Base De Datos");
            } else {
                System.out.println(editorial.toString());
                return editorial;
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    public List listarEditorial() {
        try {
            conectar();
            String query = "SELECT e FROM Editorial e";
            List<Editorial> liste = em.createQuery(query).getResultList();
            return liste;
        } catch (Exception e) {
            throw e;
        }
    }

    public void buscarEditorialPorNombre(Editorial e) {
        try {
            conectar();
            String query = "SELECT e FROM Editorial e WHERE e.nombre LIKE :NOMBRE";
            List<Editorial> x =  em.createQuery(query).setParameter("NOMBRE", e.getNombre()).getResultList();
            if (x == null) {
                System.out.println("La Editorial no se encuentra en la base de datos");
            } else {
                System.out.println(x.toString());
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void buscarEditorialPorId(Editorial e) {
        try {
            conectar();
            String query = "SELECT e FROM Editorial e WHERE e.id LIKE :id";
            List<Editorial> x =  em.createQuery(query).setParameter("id", e.getId()).getResultList();
            if (x == null) {
                System.out.println("La Editorial no se encuentra en la base de datos");
            } else {
                System.out.println(x.toString());
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
}
