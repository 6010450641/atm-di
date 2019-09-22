package dbJDBC;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ATMImp implements ATMsql {
    private JdbcTemplate jdbcTemplate;

    public ATMImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void save(Account book) {
        String query = "INSERT INTO Account (id, name, price) VALUES (?, ?, ?);";
        Object[] data = new Object[]
                { book.getId(), book.getName(), book.getBalance() };
        jdbcTemplate.update(query, data);



    }

    public void update(int id, Account book) {
        String query = "USDATE Account SET price = '"+book.getBalance()+"' WHERE id= '"+id+"'";
        Object[] data = new Object[]{book.getId(),book.getName(),book.getBalance()};

    }

    public void deleteById(int id) {
        String query = "DELETE FROM Account WHERE id = '"+id+"'";

    }

    public Account findById(int id) {
        String query = "SELECT * FROM Account WHERE id = " + id;
        Account account = jdbcTemplate.queryForObject(query, new AccountRowMapper());
        return account;

    }

    public List<Account> findAll() {
        String query = "SELECT * FROM Account";
        List<Account> accounts = jdbcTemplate.query(query, new AccountRowMapper());
        return accounts;

    }
    class AccountRowMapper implements RowMapper<Account> {
        public Account mapRow(ResultSet rs, int rowNum)
                throws SQLException {
            Account book = new Account(rs.getString("id"),
                    rs.getString("name"),
                    rs.getDouble("price"));
            return book;
        }
    }

}
