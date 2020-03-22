package net.codejava.fileupload.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public class FileGetDAOImpl implements FileGetDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public FileGetDAOImpl() {
    }

    public FileGetDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void get(GetFile getfile) {
        sessionFactory.getCurrentSession().get(getFile);
    }

}

