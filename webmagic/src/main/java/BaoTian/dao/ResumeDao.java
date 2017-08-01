package BaoTian.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import BaoTian.entity.person;

/**
 * Created by gray- on 2017/7/24.
 */
public class ResumeDao {
    private Connection conn = null;
    private Statement stmt = null;

    public ResumeDao(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/spider?"
                    + "user=root&password=root&useUnicode=true&characterEncoding=UTF8&useSSL=false";
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public int add(person i) throws SQLException{
        String sql ="INSERT INTO tbl_botianrencai(id,name,sex,height,weight,birth,national,marriage,political,identity," +
                "census_register,now_living,working_time,job_type,position_applied,position_applied2,position_applied3," +
                "salary_requirement,location_preference,work_experience,education,school_graduation,time_graduation," +
                "computer_level,foreign_language,foreign_language_level,mandarin,cantonese,kind_professions," +
                "kind_profession2,education_experience,personal_ability,mailing_address) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?);";


        PreparedStatement ps = conn.prepareStatement(sql);
        try{


            ps.setString(1, i.getId());
            ps.setString(2, i.getName());
            ps.setString(3, i.getSex());
            ps.setString(4, i.getHeight());
            ps.setString(5, i.getWeight());
            ps.setString(6, i.getBirth());
            ps.setString(7, i.getNational());
            ps.setString(8, i.getMarriage());
            ps.setString(9, i.getPolitical());
            ps.setString(10, i.getIdentity());
            ps.setString(11, i.getCensus_register());
            ps.setString(12, i.getNow_living());
            ps.setString(13, i.getWorking_time());
            ps.setString(14, i.getJob_type());
            ps.setString(15, i.getPosition_applied());
            ps.setString(16, i.getPosition_applied2());
            ps.setString(17, i.getPosition_applied3());
            ps.setString(18, i.getSalary_requirement());
            ps.setString(19, i.getLocation_preference());
            ps.setString(20, i.getWork_experience());
            ps.setString(21, i.getEducation());
            ps.setString(22, i.getSchool_graduation());
            ps.setString(23, i.getTime_graduation());
            ps.setString(24, i.getComputer_level());
            ps.setString(25, i.getForeign_language());
            ps.setString(26, i.getForeign_language_level());
            ps.setString(27, i.getMandarin());
            ps.setString(28, i.getCantonese());
            ps.setString(29, i.getKind_professions());
            ps.setString(30, i.getKind_profession2());
            ps.setString(31, i.getEducation_experience());
            ps.setString(32, i.getPersonal_ability());
            ps.setString(33, i.getMailing_address());

            return ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            conn.close();
            stmt.close();
            ps.close();
        }
        return -1;
    }

}
