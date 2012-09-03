package au.edu.qut.INB372.AgileProjects.DataModel;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EMFSingleton {
    private static final EntityManagerFactory EMFInstance =
        Persistence.createEntityManagerFactory("transactions-optional");

    private EMFSingleton() {}

    public static EntityManagerFactory get() {
        return EMFInstance;
    }
}