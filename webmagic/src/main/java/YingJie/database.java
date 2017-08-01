package YingJie;

import BaoTian.entity.person;

import java.sql.*;

/**
 * Created by gray- on 2017/7/26.
 */
public class database {
    private Connection conn = null;
    private Statement stmt = null;

    public database(){
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

    public int add(entity i) throws SQLException{
         String sql ="INSERT INTO tbl_Yingjie( id,  name,  state,  sex,  age,  university,  university_types,  professional," +
                 "  birth,  graduation,  live_place,  native_place,  self_description,  position_type,  expect_salary," +
                 "  expect_place,  expect_position,  summary_intention,  education_experience,  work_experience,  school_rewards,  campus_jobs) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


        PreparedStatement ps = conn.prepareStatement(sql);
        try{
            ps.setString(1, i.getId());
            ps.setString(2, i.getName());
            ps.setString(3, i.getState());
            ps.setString(4, i.getSex());
            ps.setString(5, i.getAge());
            ps.setString(6, i.getUniversity());
            ps.setString(7, i.getUniversity_types());
            ps.setString(8, i.getProfessional());
            ps.setString(9, i.getBirth());
            ps.setString(10,i.getGraduation());
            ps.setString(11,i.getLive_place());
            ps.setString(12,i.getNative_place());
            ps.setString(13,i.getSelf_description());
            ps.setString(14,i.getPosition_type());
            ps.setString(15,i.getExpect_salary());
            ps.setString(16,i.getExpect_place());
            ps.setString(17,i.getExpect_position());
            ps.setString(18,i.getSummary_intention());
            ps.setString(19,i.getEducation_experience());
            ps.setString(20,i.getWork_experience());
            ps.setString(21,i.getSchool_rewards());
            ps.setString(22,i.getCampus_jobs());

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
