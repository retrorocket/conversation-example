package biz.retrorocket.conversation;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class WanWan implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int touchedCount = 0;
	
	private static final String REDIRECT_URL = "index2.xhtml?faces-redirect=true";
		
	public String touch(){
		touchedCount++;
		return REDIRECT_URL;
	}
	
	public int getTouchedCount(){
		return touchedCount;
	}
}