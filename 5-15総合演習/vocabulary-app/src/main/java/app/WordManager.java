package app;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DBManager;

public class WordManager {
    private final DBManager dbm;

    public static final int MAX_RECORDS = 1000;
    private static final int MAX_LEN = 100;

    public enum AddResult { OK, DUPLICATE, INVALID, LIMIT; }

    public WordManager(DBManager dbm) { this.dbm = dbm; }

    private static String norm(String s){ return s==null? "" : s.trim(); }

    private static boolean valid(String en, String ja){
        if(en.isEmpty() || ja.isEmpty()) return false;
        if(en.length() > MAX_LEN || ja.length() > MAX_LEN) return false;
        return en.matches(".*[A-Za-z].*");
    }

    private static boolean exists(Connection c, String en) throws Exception {
        try (var ps = c.prepareStatement("SELECT 1 FROM words WHERE english ILIKE ? LIMIT 1")) {
            ps.setString(1, en);
            try (var rs = ps.executeQuery()) { return rs.next(); }
        }
    }

    private static int count(Connection c) throws Exception {
        try (var st = c.createStatement();
             var rs = st.executeQuery("SELECT COUNT(*) FROM words")) {
            rs.next();
            return rs.getInt(1);
        }
    }

    public AddResult addWord(Word w) throws Exception {
        String en = norm(w.getEnglish()), ja = norm(w.getJapanese());

        // 入力不備
        if (!valid(en, ja)) return AddResult.INVALID;

        try (var conn = dbm.getConnection()) {

            // (2) 上限チェック
            if (count(conn) >= MAX_RECORDS) return AddResult.LIMIT;

            // (3) 重複チェック
            if (exists(conn, en)) return AddResult.DUPLICATE;

            // (4) 登録
            try (var ps = conn.prepareStatement("INSERT INTO words(english,japanese) VALUES(?,?)")) {
                ps.setString(1, en);
                ps.setString(2, ja);
                ps.executeUpdate();
                return AddResult.OK;
            }
        }
    }

    public List<Word> getWords() throws Exception {
        List<Word> list = new ArrayList<>();
        try (var conn = dbm.getConnection();
             var st = conn.createStatement();
             var rs = st.executeQuery("SELECT english, japanese FROM words ORDER BY id")) {
            while (rs.next()) list.add(new Word(rs.getString(1), rs.getString(2)));
        }
        return list;
    }

    public int getWordCount() throws Exception {
        try (var conn = dbm.getConnection();
             var st = conn.createStatement();
             var rs = st.executeQuery("SELECT COUNT(*) FROM words")) {
            rs.next();
            return rs.getInt(1);
        }
    }

    public int deleteWord(String english) throws Exception {
        english = norm(english);
        try (var conn = dbm.getConnection();
             var ps = conn.prepareStatement("DELETE FROM words WHERE english ILIKE ?")) {
            ps.setString(1, english);
            return ps.executeUpdate();
        }
    }

    public int updateWord(String english,String newJa) throws Exception {
        english = norm(english); newJa = norm(newJa);
        if(!valid(english,newJa)) return 0;
        try (var conn = dbm.getConnection();
             var ps = conn.prepareStatement("UPDATE words SET japanese=? WHERE english ILIKE ?")) {
            ps.setString(1,newJa);
            ps.setString(2,english);
            return ps.executeUpdate();
        }
    }
}
