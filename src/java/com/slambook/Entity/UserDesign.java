package com.slambook.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
@Entity
@NamedQueries({

	@NamedQuery(name="UserDesign.getUserDesignStyleSheet",query="FROM UserDesign userDesign WHERE userDesign.userInfo.userId = :userId"),
	@NamedQuery(name="UserDesign.getFriendsDesignStyleSheet",query="FROM UserDesign userDesign WHERE userDesign.userInfo.userId = :friendId")

})
public class UserDesign implements Serializable{

	
	@Id
	@GeneratedValue
	private int designId;

	private int backgroundTextture;
	private int slambookPagesBackgroundTexture;
	private String slambookPagesFontColor;
	private int headerFooterTextures;

	@OneToOne
        @JoinColumn(name="userId")
	private UserInfo userInfo;

	public UserDesign(){


	}

	public void setDesignId(int designId){

		this.designId =  designId;
	}

	public int getDesignId(){

		return designId;
	}

	public void setBackgroundTextture(int textureCode){

		this.backgroundTextture = textureCode;
	}

	public int getBackgroundTexture(){

		return backgroundTextture;
	}

	public void setSlambookPagesBackgroundTexture(int textureCode){

		this.slambookPagesBackgroundTexture = textureCode;
	}

	public int getSlabookPagesBackgroundTexture(){

		return slambookPagesBackgroundTexture;
	}

	public void setSlambookPagesFontColor(String fontCode){

		this.slambookPagesFontColor = fontCode;
	}

	public String getSlambookPagesFontColor(){

		return slambookPagesFontColor;
	}

	public void setHeaderFooterTextures(int textureCode){

		this.headerFooterTextures =  textureCode;
	}

	public int getHeaderFooterTextures(){

		return headerFooterTextures;
	}

	public void setUserInfo(UserInfo userInfo){

		this.userInfo = userInfo;

	}

	public UserInfo getUserInfo(){


		return userInfo;

	}



}