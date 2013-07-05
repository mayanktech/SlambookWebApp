
package com.slambook.services.Interfces;
import com.slambook.Entity.UserDesign;

public interface UserDesignDaoServiceInterface{
	
	public UserDesign getUserDesign(int userId);
	public void updateUserDesign(UserDesign userDesign);
	public void updateSlambookPagesBackgroundTexture(int userId,int textureId);
	public void updateSlambookBackgroundTexture(int userId,int textureId);
	public void updateSlambookPagesFontColor(int userId,String colorId);
	public void updateSlambookHeaderFooterTexture(int userId,int textureId);


}