package payloads;

public class UserModel {

	public long id;
	public String title;
	public String body;
	public int userId;
	
	public UserModel() {
	}

	public UserModel(String title, String body, int userId) {
		this.title= title;
		this.body= body;
		this.userId= userId;
	 }
	
	public UserModel(long id, String title, String body, int userId) {
		this.id= id;
		this.title= title;
		this.body= body;
		this.userId= userId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	
}
