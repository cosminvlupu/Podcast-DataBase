package controllers;

import entities.Podcast;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PodcastController {

    public ArrayList<Podcast> getRangePodcasts(int idStart, int idEnd) throws SQLException {
        ArrayList<Podcast> podcasts = new ArrayList<Podcast>();
        Connection conn = null;
        int ret_code;

        try {
            //Load and register Oracle driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //Establish a connection

            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "student", "student1");

            String podcastsSql = "SELECT * FROM (SELECT c.podcast_id, c.title, c.description, c.genre, c.published_date, row_number() over (ORDER BY c.podcast_id ASC) line_number FROM PODCASTS c) WHERE line_number BETWEEN " + idStart + " AND " + idEnd + "  ORDER BY line_number";
            PreparedStatement st = conn.prepareStatement(podcastsSql);
            //  st.setInt(1, idStart);
            // st.setInt(2, idEnd);

            System.out.println("ceva" + st.toString());
            ResultSet rset = st.executeQuery(podcastsSql);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
            while (rset.next()){

                podcasts.add(new Podcast(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getDate(5) ));
            }

            rset.close();
            st.close();

        } catch (SQLException e) {ret_code = e.getErrorCode();
            System.err.println(ret_code + e.getMessage()); conn.close();}
        catch (ClassNotFoundException var2) {
            System.out.println("Exceptie:  " + var2);
        }


        return podcasts.isEmpty() ? null : podcasts;
    }
}
