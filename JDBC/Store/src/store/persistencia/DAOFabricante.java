/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.persistencia;

import java.util.List;
import store.entidades.Fabricante;

/**
 *
 * @author tomyv
 */
public class DAOFabricante extends DAO {

    public void crearFabricante(Fabricante a) {
        super.guardar(a);
    }

    public void bajarFabricante(Fabricante a) {
        try {
            conectar();
            Fabricante aut = em.find(Fabricante.class, a.getId());
            if (aut == null) {
                System.out.println("No existe el Fabricante");
            } else {
                if (aut.getAlta()) {
                    aut.setAlta(Boolean.FALSE);
                    editar(aut);
                    System.out.println("Fabricante Bajado exitosamente");
                } else {
                    System.out.println("Este Fabricante ha sido previamente Bajado");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void subirFabricante(Fabricante a) {
        try {
            conectar();
            Fabricante aut = em.find(Fabricante.class, a.getId());
            if (aut == null) {
                System.out.println("No existe el Fabricante");
            } else {
                if (!aut.getAlta()) {
                    aut.setAlta(Boolean.TRUE);
                    editar(aut);
                    System.out.println("Fabricante Subido exitosamente");
                } else {
                    System.out.println("Este Fabricante ha sido previamente Subido");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void editarFabricante(Fabricante a) {
        try {
            conectar();
            Fabricante aut = em.find(Fabricante.class, a.getId());
            if (aut == null) {
                System.out.println("Fabricante no existente");
            } else {
                a.setNombre(a.getNombre());
                editar(aut);
                System.out.println("Fabricante exitosamente Editado");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Fabricante buscarFabricante(Fabricante f, Integer op) {
        try {
            conectar();
            switch (op) {
                case 1:
                    Fabricante fab = em.find(Fabricante.class, f.getId());
                    if (fab == null) {
                        System.out.println(f.getId() + " no se encuentra en la Base De Datos");
                    } else {
                        System.out.println(fab.toString());
                        return fab;
                    }
                    break;
                case 2:
                    String jpsql = "SELECT f FROM Fabricante f WHERE f.nombre LIKE :name";
                    List<Fabricante> x = em.createQuery(jpsql).setParameter("name", f.getNombre()).getResultList();
                    if (x.isEmpty()) {
                        System.out.println(f.getId() + " no se encuentra en la Base De Datos");
                    } else {
                        Fabricante fab2 = x.get(0);
                        System.out.println(fab2.toString());
                        return fab2;
                    }
                    break;
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    public List listarFabricante() {
        try {
            conectar();
            String query = "SELECT a FROM Fabricante a";
            List<Fabricante> lista = em.createQuery(query).getResultList();
            return lista;
        } catch (Exception e) {
            throw e;
        }
    }

    public void buscarFabricantePorNombre(Fabricante a) {
        try {
            conectar();
            String query = "SELECT a FROM Fabricante a WHERE a.nombre LIKE :NOMBRE";
            List<Fabricante> x = em.createQuery(query).setParameter("NOMBRE", a.getNombre()).getResultList();
            if (x == null) {
                System.out.println("El Fabricante no se encuentra en la base de datos");
            } else {
                System.out.println(x.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean buscarFabricantePorId(Fabricante a) {
        try {
            conectar();
            String query = "SELECT a FROM Fabricante a WHERE a.id LIKE :id";
            List<Fabricante> x = em.createQuery(query).setParameter("id", a.getId()).getResultList();
            if (x == null) {
                System.out.println("El Fabricante no se encuentra en la base de datos");
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
