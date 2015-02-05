package com.dextra.webapp.context;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.UserTransaction;

class TransactionContainer {

    private static final TransactionContainer SINGLETON = new TransactionContainer();

    private final UserTransaction transaction;

    private TransactionContainer() {
        this.transaction = buildUserTransaction();
    }

    public static UserTransaction get() {
        return SINGLETON.transaction;
    }

    private UserTransaction buildUserTransaction() {
        try {
            InitialContext ic = new InitialContext();
            return (UserTransaction) ic.lookup("java:comp/UserTransaction");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

}
