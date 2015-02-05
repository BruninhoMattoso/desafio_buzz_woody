package com.dextra.webapp.context;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.dextra.webapp.rest.Resources;

@ApplicationPath("")
public class RootApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();

        classes.add(Resources.class);

        return classes;
    }

}
