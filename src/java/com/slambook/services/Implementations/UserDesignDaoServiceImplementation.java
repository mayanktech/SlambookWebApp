
package com.slambook.services.Implementations;


import com.slambook.repository.Interfaces.UserDesignDaoInterface;
import com.slambook.Entity.UserDesign;
import com.slambook.services.Interfces.UserDesignDaoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDesignDaoServiceImplementation implements UserDesignDaoServiceInterface {


	@Autowired
	private UserDesignDaoInterface userDesignDaoInterface ;


	public UserDesign getUserDesign(int userId){


		return userDesignDaoInterface.getUserDesign(userId);


	}
	public void updateUserDesign(UserDesign userDesign){


		userDesignDaoInterface.updateUserDesign(userDesign);

	}


	public void updateSlambookPagesBackgroundTexture(int userId,int textureId){

		userDesignDaoInterface.updateSlambookPagesBackgroundTexture(userId,textureId);

	}
	public void updateSlambookBackgroundTexture(int userId,int textureId){

		userDesignDaoInterface.updateSlambookBackgroundTexture(userId,textureId);

	}
	public void updateSlambookPagesFontColor(int userId,String colorId){

		userDesignDaoInterface.updateSlambookPagesFontColor(userId,colorId);

	}
	public void updateSlambookHeaderFooterTexture(int userId,int textureId){

		userDesignDaoInterface.updateSlambookHeaderFooterTexture(userId,textureId);

	}




}