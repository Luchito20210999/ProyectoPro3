package pe.edu.pucp.proyectopro3.dao.auth;

import pe.edu.pucp.proyectopro3.dao.Persistible;

public interface PersonaDAO<M> extends Persistible<M, Integer> {
    M buscarPorNumDoc(String numDoc);
}
