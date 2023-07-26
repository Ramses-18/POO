/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.persistencia;

import java.util.List;
import library.entidades.Cliente;

/**
 *
 * @clihor tomyv
 */
public class DAOCliente extends DAO {

    public void crearCliente(Cliente c) {
        super.guardar(c);
    }

    public void bajarCliente(Cliente c) {
        try {
            conectar();
            Cliente cli = em.find(Cliente.class, c.getId());
            if (cli == null) {
                System.out.println("No existe el Cliente");
            } else {
                if (cli.getAlta()) {
                    cli.setAlta(Boolean.FALSE);
                    editar(cli);
                    System.out.println("Cliente Bajado exitosamente");
                } else {
                    System.out.println("Este Cliente ha sido previamente Bajado");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void subirCliente(Cliente c) {
        try {
            conectar();
            Cliente cli = em.find(Cliente.class, c.getId());
            if (cli == null) {
                System.out.println("No existe el Cliente");
            } else {
                if (!cli.getAlta()) {
                    cli.setAlta(Boolean.TRUE);
                    editar(cli);
                    System.out.println("Cliente Subido exitosamente");
                } else {
                    System.out.println("Este Cliente ha sido previamente Subido");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void editarCliente(Cliente c,Integer op) {
        try {
            conectar();
            Cliente cli = em.find(Cliente.class, c.getId());
            if (cli == null) {
                System.out.println("Cliente no existente");
            } else {
                switch (op) {
                    case 1:
                        cli.setNombre(c.getNombre());
                        break;
                    case 2:
                        cli.setApellido(c.getApellido());
                        break;
                    case 3:
                        cli.setDni(c.getDni());
                        break;
                    case 4:
                        cli.setTelefono(c.getTelefono());
                        break;
                }
                editar(cli);
                System.out.println("Cliente exitosamente Editado");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Cliente buscarCliente(Cliente c) {
        try {
            conectar();
            Cliente Cliente = em.find(Cliente.class, c.getId());
            if (Cliente == null) {
                System.out.println(c.getId() + " NO se encuentra en la Base De Datos");
            } else {
                System.out.println(Cliente.toString());
                return Cliente;
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    public List listarCliente() {
        try {
            conectar();
            String query = "SELECT a FROM Cliente a";
            List<Cliente> lista = em.createQuery(query).getResultList();
            for (Cliente cliente : lista) {
                System.out.println(cliente.toString());
            }
            return lista;
        } catch (Exception e) {
            throw e;
        }
    }

    public void buscarClientePorDni(Cliente c) {
        try {
            conectar();
            String query = "SELECT a FROM Cliente a WHERE a.dni LIKE :dni";
            List<Cliente> x = em.createQuery(query).setParameter("dni", c.getDni()).getResultList();
            if (x == null) {
                System.out.println("El Cliente no se encuentra en la base de datos");
            } else {
                System.out.println(x.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Cliente buscarClientePorId(Cliente c) {
        try {
            conectar();
            String query = "SELECT a FROM Cliente a WHERE a.id LIKE :id";
            Cliente x = (Cliente) em.createQuery(query).setParameter("id", c.getId()).getSingleResult();
            if (x == null) {
                System.out.println("El Cliente no se encuentra en la base de datos");
            } else {
                System.out.println(x.toString());
            }
            return x;
        } catch (Exception e) {
            throw e;
        }
    }

    public void buscarClientePorNombre(Cliente c) {
        try {
            conectar();
            String query = "SELECT a FROM Cliente a WHERE a.nombre LIKE :nombre";
            List<Cliente> x = em.createQuery(query).setParameter("nombre", c.getNombre()).getResultList();
            if (x == null) {
                System.out.println("El Cliente no se encuentra en la base de datos");
            } else {
                System.out.println(x.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void buscarClientePorApellido(Cliente c) {
        try {
            conectar();
            String query = "SELECT a FROM Cliente a WHERE a.apellido LIKE :apellido";
            List<Cliente> x = em.createQuery(query).setParameter("apellido", c.getApellido()).getResultList();
            if (x == null) {
                System.out.println("El Cliente no se encuentra en la base de datos");
            } else {
                for (Cliente f : x) {
                    System.out.println(f.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void buscarClientePorTelefono(Cliente c) {
        try {
            conectar();
            String query = "SELECT a FROM Cliente a WHERE a.telefono LIKE :num";
            List<Cliente> x = em.createQuery(query).setParameter("num", c.getTelefono()).getResultList();
            if (x == null) {
                System.out.println("El Cliente no se encuentra en la base de datos");
            } else {
                System.out.println(x.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
