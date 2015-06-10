package biz.retrorocket.conversation;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class NyanNyan implements Serializable{
	
	@Inject
	private Conversation conversation;

	private static final long serialVersionUID = 1L;
	
	private String mem = "My name is Default_Nyan.";
	private int touchedCount = 0;
	
	private static final String REDIRECT_URL = "index2.xhtml?faces-redirect=true";
	
	public String startConversation(){
		if(conversation.isTransient()) {
			conversation.begin();
		}
		mem = "My name is Changed_Nyan.";
		return REDIRECT_URL;
	}
	
	public String endConversation(){
		if(!conversation.isTransient()) {
			conversation.end();
		}
		return REDIRECT_URL;
	}
	
	public String touch(){
		touchedCount++;
		return REDIRECT_URL;
	}

	public String getMem(){
		return mem;
	}
	
	public int getTouchedCount(){
		return touchedCount;
	}
}