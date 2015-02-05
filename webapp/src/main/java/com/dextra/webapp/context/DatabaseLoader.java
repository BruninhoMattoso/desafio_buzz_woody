package com.dextra.webapp.context;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.transaction.UserTransaction;

import com.dextra.webapp.entity.Usuario;

@WebListener
public class DatabaseLoader implements ServletContextListener {
    
    private static final boolean MOCK = "TRUE".equals(System.getProperty("mock"));

    @PersistenceContext
    private EntityManager em;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        if (MOCK) {
            UserTransaction transaction = TransactionContainer.get();
            try {
                transaction.begin();
                this.load();
                transaction.commit();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // do nothing
    }

    public void load() {

        Usuario usuario = new Usuario();
        usuario.setNome("estag2014");
        usuario.setSenha("estag2014");
        this.em.persist(usuario);

    }

}
