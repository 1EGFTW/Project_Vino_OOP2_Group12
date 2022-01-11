package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

import java.util.Objects;

public class OperatorListViewModel {
    private String username_operator;
    private String password_operator;

    public OperatorListViewModel(String username_operator, String password_operator) {
        this.username_operator = username_operator;
        this.password_operator = password_operator;
    }

    public boolean equals(OperatorListViewModel r) {
        return this.username_operator.equals(r.username_operator)&& this.password_operator.equals(r.password_operator);
    }

    public String getUsername_operator() {
        return username_operator;
    }

    public void setUsername_operator(String username_operator) {
        this.username_operator = username_operator;
    }

    public String getPassword_operator() {
        return password_operator;
    }

    public void setPassword_operator(String password_operator) {
        this.password_operator = password_operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperatorListViewModel that = (OperatorListViewModel) o;
        return Objects.equals(username_operator, that.username_operator) && Objects.equals(password_operator, that.password_operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username_operator, password_operator);
    }

    @Override
    public String toString() {
        return String.format("%s", username_operator);}
}
