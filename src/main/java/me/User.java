public class User {
    private String username;
    private Client client;

    public User() {
        this.username = "";
        this.client = new Client();
    }

    public User(String username) {
        this.username = username;
        this.client = new Client();
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Client getClient() {
        return this.client;
    }

    public void connectsTo(String ip, int port) {
        this.client.startConnection(ip, port);
    }

    public String sendMessageGetResponse(String msg) {
        return this.client.sendMessageGetResponse(msg);
    }

}
