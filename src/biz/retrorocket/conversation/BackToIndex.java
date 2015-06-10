package biz.retrorocket.conversation;

import java.io.Serializable;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

@Named
@ConversationScoped
public class BackToIndex implements Serializable{
	public String toIndex(){
		return "index.xhtml?faces-redirect=true";
	}
}
