package bg.tu_varna.sit.vino.project_vino_group12.presentation.models;

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
    @Override
    public String toString() {
        return String.format("%s | %s", username_operator, password_operator);}
}
