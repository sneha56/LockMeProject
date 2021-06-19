package Phase1.Project.LockMe;

public class UserLockCredentials {
	private String siteName;
	private String userName;
	private String password;
	
	public UserLockCredentials() {}
	
	public UserLockCredentials(String siteName, String loginUser, String userName, String password) 
	{
		this.siteName = siteName;
		this.userName = userName;
		this.password = password;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserLockCredentials [siteName=" + siteName + ", userName=" + userName
				+ ", password=" + password + "]";
	}
	
}
