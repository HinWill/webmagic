package YingJie;

/**
 * Created by gray- on 2017/7/26.
 */
public class entity {
    private String id;
    private String name;
    private String state;
    private String sex;
    private String age;
    private String university;
    private String university_types;
    private String professional;
    private String birth;
    private String graduation;
    private String live_place;
    private String native_place;
    private String self_description;
    private String position_type;
    private String expect_salary;
    private String expect_place;
    private String expect_position;
    private String summary_intention;
    private String education_experience;
    private String work_experience;
    private String school_rewards;
    private String campus_jobs;


    public entity(String id, String name, String state, String sex, String age, String university, String university_types, String professional, String birth, String graduation, String live_place, String native_place, String self_description, String position_type, String expect_salary, String expect_place, String expect_position, String summary_intention, String education_experience, String work_experience, String school_rewards, String campus_jobs) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.sex = sex;
        this.age = age;
        this.university = university;
        this.university_types = university_types;
        this.professional = professional;
        this.birth = birth;
        this.graduation = graduation;
        this.live_place = live_place;
        this.native_place = native_place;
        this.self_description = self_description;
        this.position_type = position_type;
        this.expect_salary = expect_salary;
        this.expect_place = expect_place;
        this.expect_position = expect_position;
        this.summary_intention = summary_intention;
        this.education_experience = education_experience;
        this.work_experience = work_experience;
        this.school_rewards = school_rewards;
        this.campus_jobs = campus_jobs;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getUniversity_types() {
        return university_types;
    }

    public void setUniversity_types(String university_types) {
        this.university_types = university_types;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }

    public String getLive_place() {
        return live_place;
    }

    public void setLive_place(String live_place) {
        this.live_place = live_place;
    }

    public String getNative_place() {
        return native_place;
    }

    public void setNative_place(String native_place) {
        this.native_place = native_place;
    }

    public String getSelf_description() {
        return self_description;
    }

    public void setSelf_description(String self_description) {
        this.self_description = self_description;
    }

    public String getPosition_type() {
        return position_type;
    }

    public void setPosition_type(String position_type) {
        this.position_type = position_type;
    }

    public String getExpect_salary() {
        return expect_salary;
    }

    public void setExpect_salary(String expect_salary) {
        this.expect_salary = expect_salary;
    }

    public String getExpect_place() {
        return expect_place;
    }

    public void setExpect_place(String expect_place) {
        this.expect_place = expect_place;
    }

    public String getExpect_position() {
        return expect_position;
    }

    public void setExpect_position(String expect_position) {
        this.expect_position = expect_position;
    }

    public String getSummary_intention() {
        return summary_intention;
    }

    public void setSummary_intention(String summary_intention) {
        this.summary_intention = summary_intention;
    }

    public String getEducation_experience() {
        return education_experience;
    }

    public void setEducation_experience(String education_experience) {
        this.education_experience = education_experience;
    }

    public String getWork_experience() {
        return work_experience;
    }

    public void setWork_experience(String work_experience) {
        this.work_experience = work_experience;
    }

    public String getSchool_rewards() {
        return school_rewards;
    }

    public void setSchool_rewards(String school_rewards) {
        this.school_rewards = school_rewards;
    }

    public String getCampus_jobs() {
        return campus_jobs;
    }

    public void setCampus_jobs(String campus_jobs) {
        this.campus_jobs = campus_jobs;
    }

    @Override
    public String toString() {
        return "entity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", university='" + university + '\'' +
                ", university_types='" + university_types + '\'' +
                ", professional='" + professional + '\'' +
                ", birth='" + birth + '\'' +
                ", graduation='" + graduation + '\'' +
                ", live_place='" + live_place + '\'' +
                ", native_place='" + native_place + '\'' +
                ", self_description='" + self_description + '\'' +
                ", position_type='" + position_type + '\'' +
                ", expect_salary='" + expect_salary + '\'' +
                ", expect_place='" + expect_place + '\'' +
                ", expect_position='" + expect_position + '\'' +
                ", summary_intention='" + summary_intention + '\'' +
                ", education_experience='" + education_experience + '\'' +
                ", work_experience='" + work_experience + '\'' +
                ", school_rewards='" + school_rewards + '\'' +
                ", campus_jobs='" + campus_jobs + '\'' +
                '}';
    }
}
