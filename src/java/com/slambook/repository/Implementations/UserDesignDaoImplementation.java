
package com.slambook.repository.Implementations;

import com.slambook.Entity.UserDesign;
import com.slambook.repository.Interfaces.UserDesignDaoInterface;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDesignDaoImplementation implements UserDesignDaoInterface{

	@Autowired
    private SessionFactory sessionFactory;
    

	@Override
	public UserDesign getUserDesign(int userId){

		Query query = sessionFactory.getCurrentSession().getNamedQuery("UserDesign.getUserDesignStyleSheet");
		query.setInteger("userId",userId);

		return (UserDesign)query.uniqueResult();

	}

	@Override
	public void updateUserDesign(UserDesign userDesign){

		sessionFactory.getCurrentSession().update(userDesign);

	}

	@Override
	public void updateSlambookPagesBackgroundTexture(int userId,int textureId){

		
		UserDesign userDesign =  getUserDesign(userId);
		userDesign.setSlambookPagesBackgroundTexture(textureId);



	}

	@Override
	public void updateSlambookBackgroundTexture(int userId,int textureId){

		UserDesign userDesign =  getUserDesign(userId);
		userDesign.setBackgroundTextture(textureId);


	}

	@Override
	public void updateSlambookPagesFontColor(int userId,String fontId){

		UserDesign userDesign =  getUserDesign(userId);
		userDesign.setSlambookPagesFontColor(fontId);


	}

	@Override
	public void updateSlambookHeaderFooterTexture(int userId,int textureId){

		UserDesign userDesign =  getUserDesign(userId);
		userDesign.setHeaderFooterTextures(textureId);

	}


}