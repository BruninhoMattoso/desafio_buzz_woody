package com.dextra.webapp.rest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dextra.webapp.entity.Usuario;

@Path("")
public class Hello {

    @PersistenceContext
    private EntityManager em;

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("hello")
    public String hello() {

        String jpql = String.format("SELECT u FROM %s u", Usuario.class.getSimpleName());
        TypedQuery<Usuario> query = this.em.createQuery(jpql, Usuario.class);
        Usuario usuario = query.getResultList().get(0);

        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("<head>");
        //builder.append("\t<title>Ola Usuario\u000d!</title>");
        builder.append("\t<title>Ola " + usuario.getNome() + "</title>");
        builder.append("\t<link href=\"/style/style.css\" rel=\"stylesheet\" type=\"text/css\" />");
        builder.append("</head>");
        builder.append("<body>");
        builder.append("\t<h1>Ola Mundo???</h1>");
        builder.append("</body>");
        builder.append("</html>");

        return builder.toString();
    }

}
