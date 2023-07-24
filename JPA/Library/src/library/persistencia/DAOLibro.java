/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.persistencia;

import java.util.List;
import library.entidades.Libro;

/**
 *
 * @author tomyv
 */
public class DAOLibro extends DAO {
    
    public void crearLibro(Libro l) throws Exception {
        try {
            if (l.getAutor() == null) {
                throw new Exception("Indique un Autor");
            }
            if (l.getEditorial() == null) {
                throw new Exception("Indique una Editorial");
            }
            super.guardar(l);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public boolean verificarISBN(Libro l) {
        try {
            conectar();
            Libro lib = em.find(Libro.class, l.getId());
            if (lib == null) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public boolean verificarTitulo(Libro l) {
        try {
            conectar();
            String sql = "SELECT l FROM Libro l WHERE l.titulo LIKE :title";
            List<Libro> libros = em.createQuery(sql).setParameter("title", l.getTitulo()).getResultList();
            if (libros == null) {
                System.out.println("TITULO YA CREADO EN LA BASE DE DATOS");
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void bajarLibro(Libro l) {
        try {
            conectar();
            Libro lib = em.find(Libro.class, l.getId());
            if (lib == null) {
                System.out.println("Libro no Existente en la Base De Datos");
            } else {
                if (lib.getAlta()) {
                    lib.setAlta(false);
                    editar(lib);
                    System.out.println("Libro Bajado Existosamente");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void subirLibro(Libro l) {
        try {
            conectar();
            Libro lib = em.find(Libro.class, l.getId());
            if (lib == null) {
                System.out.println("Libro no Existente en la Base De Datos");
            } else {
                if (!lib.getAlta()) {
                    lib.setAlta(true);
                    editar(lib);
                    System.out.println("Libro Subido Existosamente");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void editeLibro(Libro l, Integer o) {
        try {
            conectar();
            Libro lib = em.find(Libro.class, l.getId());
            if (lib == null) {
                System.out.println("Libro no Existente en la Base De Datos");
            } else {
                switch (o) {
                    case 1:
                        lib.setTitulo(l.getTitulo());
                        break;
                    case 2:
                        lib.setAnio(l.getAnio());
                        break;
                    case 3:
                        lib.setEjemplares(l.getEjemplares());
                        lib.setEjemplaresRestantes(lib.getEjemplares() - lib.getEjemplaresPrestados());
                        break;
                    case 4:
                        lib.setEjemplaresPrestados(l.getEjemplaresPrestados());                     
                        lib.setEjemplaresRestantes(lib.getEjemplares() - lib.getEjemplaresPrestados());
                        break;
                    case 5:
                        lib.setEditorial(l.getEditorial());
                        break;
                    case 6:
                        lib.setAutor(l.getAutor());
                        break;
                }
                editar(lib);
                System.out.println("Libro Editado Existosamente");
            }
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void buscarLibro(Libro l) {
        try {
            conectar();
            Libro lib = em.find(Libro.class, l.getId());
            if (lib == null) {
                System.out.println("No existe ese Libro en La Base De Datos");
            } else {
                System.out.println(lib.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listarLibros() {
        try {
            conectar();
            String sql = "SELECT l FROM Libro l ";
            List<Libro> lib = em.createQuery(sql).getResultList();
            if (lib == null) {
                System.out.println("No se ha guardado ningun Autor en la Base De Datos");
            } else {
                for (Libro aux : lib) {
                    System.out.println(aux.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void buscarLibroPorNombre(Libro l) {
        try {
            conectar();
            String query = "SELECT l FROM Libro l WHERE l.titulo LIKE :titulo";
            List<Libro> x = em.createQuery(query).setParameter("titulo", l.getTitulo()).getResultList();
            if (x == null) {
                System.out.println("El Libro no se encuentra en la base de datos");
            } else {
                System.out.println(x.toString());
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    
     public boolean buscarLibroPorId(Libro l) {
        try {
            conectar();
            String query = "SELECT l FROM Libro l WHERE l.id LIKE :id";
            List<Libro> x =  em.createQuery(query).setParameter("id", l.getId()).getResultList();
            if (x.isEmpty()) {
                System.out.println("El Libro no se encuentra en la base de datos");
                return false;
            } else {
                System.out.println(x.toString());
                return true;
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
    
}
