package dbJDBC;



import java.util.List;

public interface ATMsql {
    void save(Account book);
    void update(int id, Account book);
    void deleteById(int id);
    Account findById(int id);
    List<Account> findAll();

}
