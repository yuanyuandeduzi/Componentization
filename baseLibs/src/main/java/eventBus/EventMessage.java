package eventBus;

public class EventMessage {
    public String account;

    public String getAccount() {
        return account;
    }

    public EventMessage(String account) {
        this.account = account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
