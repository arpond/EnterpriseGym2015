package uk.ac.dundee.team7.eg_website.Store;

public class UserStore {

	private UserProfile up;
	private UserDetails ud;

    public UserStore(UserProfile up, UserDetails ud) {
        this.up = up;
        this.ud = ud;
    }

    public UserProfile getUp() {
        return up;
    }

    public void setUp(UserProfile up) {
        this.up = up;
    }

    public UserDetails getUd() {
        return ud;
    }

    public void setUd(UserDetails ud) {
        this.ud = ud;
    }

}