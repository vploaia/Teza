package com.vlad.tickets.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vlad.model.Utilisateur;



@Repository
public class UtilisateurDAOImpl implements UtilisateurDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}


	@Override
	public void addUtilisateur(Utilisateur utilisateur) {
		getCurrentSession().save(utilisateur);
	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) {
		Utilisateur utilisateurToUpdate = getUtilisateur(utilisateur.getId());
		utilisateurToUpdate.setFirstName(utilisateur.getFirstName());
		utilisateurToUpdate.setLastName(utilisateur.getLastName());
		utilisateurToUpdate.setAge(utilisateur.getAge());
	//	studentToUpdate.setProject(utilisateur.getProject());
		getCurrentSession().update(utilisateurToUpdate);
		
	}
	
	@Override
	public Utilisateur getUtilisateur(int id) {
		Utilisateur utilisateur = (Utilisateur) getCurrentSession().get(Utilisateur.class, id);
		return utilisateur;
	}

	@Override
	public void deleteUtilisateur(int id) {
		Utilisateur utilisateur = getUtilisateur(id);
		if (utilisateur != null)
			getCurrentSession().delete(utilisateur);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Utilisateur> getUtilisateurs() {
		return getCurrentSession().createQuery("from Utilisateur").list();
	}


	
}
