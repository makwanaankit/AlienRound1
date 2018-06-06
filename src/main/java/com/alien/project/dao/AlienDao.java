package com.alien.project.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import com.alien.project.entity.Alien;

@Component
public class AlienDao {
	@Autowired
	SessionFactory sessionFactory;
	
	
	  private static Comparator<Alien> COMPARATOR = new Comparator<Alien>()
	    {
	    // This is where the sorting happens.
	        public int compare(Alien o1, Alien o2)
	        {
	        	
	        	 if (o1.getMarks() ==o2.getMarks())
	                 return 0;
	             else if (o1.getMarks() >o2.getMarks())
	                 return -1;
	             else
	                 return 1;
	        }
	    };
	
	
	@Transactional
	public boolean insert(Alien alien)
	{
		int index=0;
		Session session=sessionFactory.getCurrentSession();
		Query<Alien> query=session.createQuery("from Alien a ORDER BY a.aid",Alien.class);
		for(Alien a:query.list())
		{
			index=a.getAid();
		}
		alien.setAid(index+1);
		session.save(alien);
		
		return true;
	}
	
	@Transactional
	public List<Alien> getTopAlien()
	{
		Session session =sessionFactory.getCurrentSession();
		Query<Alien> query=session.createQuery("from Alien a where a.age between 10 and 20 AND a.city='Mumbai' ORDER BY a.marks desc",Alien.class).setMaxResults(5);
		Query<Alien> query1=session.createQuery("from Alien a where a.age between 20 and 30 AND a.city='Mumbai' ORDER BY a.marks desc",Alien.class).setMaxResults(5);
		Query<Alien> query2=session.createQuery("from Alien a where a.age between 30 and 60 AND a.city='Mumbai' ORDER BY a.marks desc",Alien.class).setMaxResults(5);
		
		Query<Alien> query3=session.createQuery("from Alien a where a.age between 10 and 20 AND a.city='Delhi' ORDER BY a.marks desc",Alien.class).setMaxResults(5);
		Query<Alien> query4=session.createQuery("from Alien a where a.age between 20 and 30 AND a.city='Delhi' ORDER BY a.marks desc",Alien.class).setMaxResults(5);
		Query<Alien> query5=session.createQuery("from Alien a where a.age between 30 and 60 AND a.city='Delhi' ORDER BY a.marks desc",Alien.class).setMaxResults(5);
		
		Query<Alien> query6=session.createQuery("from Alien a where a.age between 10 and 20 AND a.city='Punjab' ORDER BY a.marks desc",Alien.class).setMaxResults(5);
		Query<Alien> query7=session.createQuery("from Alien a where a.age between 20 and 30 AND a.city='Punjab' ORDER BY a.marks desc",Alien.class).setMaxResults(5);
		Query<Alien> query8=session.createQuery("from Alien a where a.age between 30 and 60 AND a.city='Punjab' ORDER BY a.marks desc",Alien.class).setMaxResults(5);
		
		
			
		List<Alien> lAliens=query.list();
		lAliens.addAll(query1.list());
		lAliens.addAll(query2.list());
		System.out.println(lAliens.size());
		 Collections.sort(lAliens, COMPARATOR);
		 
		 for(int i=lAliens.size()-1;i>4;i--)
		 {
			 lAliens.remove(i);
		 }
		
		 List<Alien>lAliens1=query3.list();
		 lAliens1.addAll(query4.list());
		 lAliens1.addAll(query5.list());
		/*lAliens.addAll(query3.list());	
		lAliens.addAll(query4.list());
		lAliens.addAll(query5.list());
		*/
		
		 Collections.sort(lAliens1, COMPARATOR);
		 lAliens.addAll(lAliens1);
		 
		 
		 for(int i=lAliens.size()-1;i>9;i--)
		 {
			 lAliens.remove(i);
		 }
		 
		 
		 List<Alien>lAliens2=query6.list();
			lAliens2.addAll(query7.list());
			lAliens2.addAll(query8.list());
			 Collections.sort(lAliens2, COMPARATOR);
			 lAliens.addAll(lAliens2);
		 
			 for(int i=lAliens.size()-1;i>14;i--)
			 {
				 lAliens.remove(i);
			 }
			 
		/*%
		lAliens.addAll(query6.list());
		lAliens.addAll(query7.list());
		lAliens.addAll(query8.list());*/
		
		return lAliens;
	}
	
	@Transactional
	public List<Alien> getAllAlien()
	{
		Session session =sessionFactory.getCurrentSession();
		Query<Alien> query=session.createQuery("from Alien",Alien.class);
		
		
		return query.list();
	}
	
}
