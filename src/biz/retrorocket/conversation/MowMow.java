package biz.retrorocket.conversation;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class MowMow implements Serializable{
	
	@Inject
	private Conversation conversation;

	private static final long serialVersionUID = 1L;
	
	private String mem = "My name is Default_Mow.";
	private int touchedCount = 0;
	
	private static final String REDIRECT_URL = "index2.xhtml?faces-redirect=true";
	
	public String startConversation(){
		//��b���J�n���Ă��Ȃ�
		if(conversation.isTransient()) {
			conversation.begin();
		}
		mem = "My name is Changed_Mow.";
		return REDIRECT_URL;
	}
	
	public String endConversation(){
		//��b���J�n���Ă���
		if(!conversation.isTransient()) {
			conversation.end();
		}
		//���O�̓f�t�H���g�ɖ߂��Ă���͂��c
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
