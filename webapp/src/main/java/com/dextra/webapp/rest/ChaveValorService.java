package com.dextra.webapp.rest;

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dextra.webapp.entity.ChaveValor;
import com.dextra.webapp.vo.ChaveValorVO;

@Stateless
@Path("chave-valor")
public class ChaveValorService {

    @Resource
    SessionContext context;
    
    @PersistenceContext
    private EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("vo")
    public ChaveValorVO page() {
        
        Principal principal = context.getCallerPrincipal();
        String name = principal.getName();

        String jpql = String.format("SELECT c"
                + " FROM %s c"
                + " WHERE c.usuario = :usuario", ChaveValor.class.getSimpleName());
        TypedQuery<ChaveValor> query = this.em.createQuery(jpql, ChaveValor.class);
        List<ChaveValor> values = query.getResultList();
        
        return new ChaveValorVO(name, values);
    }

}
