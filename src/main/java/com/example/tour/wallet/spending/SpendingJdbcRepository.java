package com.example.tour.wallet.spending;

public class SpendingJdbcRepository {

//    private final JdbcTemplate jdbcTemplate;
//
//    public SpendingRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public void saveSpending(String title, int tag, long amount, String date){
//        String sql = "INSERT INTO WALLET_SPENDING(wallet_spending_title, wallet_spending_tag, wallet_spending_amount, wallet_spending_date) VALUES(?,?)";
//        jdbcTemplate.update(sql, title, tag, amount, date);
//    }
//
//    public List<SpendingResponse> getEntireSpending(){
//        String sql = "SELECT * FORM WALLET_SPENDING";
//        return jdbcTemplate.query(sql,(rs, rowNum) -> {
//            long id = rs.getLong("wallet_spending_id");
//            String title = rs.getString("wallet_spending_title");
//            int tag = rs.getInt("wallet_spending_tag");
//            long amount = rs.getLong("wallet_spending_amount");
//            String date = rs.getString("wallet_spending_date");
//            return new SpendingResponse(id, title, tag, amount, date);
//        });
//    }
//
//    public List<SpendingResponse> getFilteringTagSpending(int tag){
//        String sql = "SELECT * FORM WALLET_SPENDING WHERE wallet_spending_tag";
//        return jdbcTemplate.query(sql,(rs, rowNum) -> {
//            long id = rs.getLong("wallet_spending_id");
//            String title = rs.getString("wallet_spending_title");
//            long amount = rs.getLong("wallet_spending_amount");
//            String date = rs.getString("wallet_spending_date");
//            return new SpendingResponse(id, title, tag, amount, date);
//        });
//    }
//
//    public List<SpendingResponse> getFilteringDateSpending(String date){
//        String sql = "SELECT * FORM WALLET_SPENDING WHERE wallet_spending_date";
//        return jdbcTemplate.query(sql,(rs, rowNum) -> {
//            long id = rs.getLong("wallet_spending_id");
//            String title = rs.getString("wallet_spending_title");
//            long amount = rs.getLong("wallet_spending_amount");
//            int tag = rs.getInt("wallet_spending_tag");
//            return new SpendingResponse(id, title, tag, amount, date);
//        });
//    }
//
//    public boolean isSpendingExist(long id){
//        String readSql = "SELECT * FROM WALLET_SPENDING WHERE wallet_spending_id = ?";
//        return jdbcTemplate.query(readSql, (rs, rowNum)->0, id).isEmpty();
//    }
//
//    public void updateSpending(long id, String title, int tag, long amount, String date){
//        String sql = "UPDATE WALLET_SPENDING SET wallet_spending_title = ?, wallet_spending_tag = ?, " +
//                "wallet_spending_amount = ?,wallet_spending_date = ? WHERE wallet_spending_id = ?";
//        jdbcTemplate.update(sql, title, tag, amount, date, id);
//    }
//
//    public void deleteUser(long id){
//        String sql = "DELETE FROM WALLET_SPENDING WHERE wallet_spending_id = ?";
//        jdbcTemplate.update(sql, id);
//    }

}
