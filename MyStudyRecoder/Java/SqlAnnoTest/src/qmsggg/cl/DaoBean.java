package qmsggg.cl;

@Table(name = "test_db")
public class DaoBean {

    @Column(value = "_id")
    private String _id;

    @Column(value = "user_name")
    private String userName;

    @Column(value = "passwd")
    private String passwd;

    public DaoBean(String _id, String userName, String passwd) {
        this._id = _id;
        this.userName = userName;
        this.passwd = passwd;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
