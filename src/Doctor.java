public class Doctor {
    private String name;
    private String id;              //doctor licence number : different doctor might have the same name, so we need id here.
                                    //using String here because the id might be too long
    private String gender;
    private String specialty;       //assume specialty is a subset of area which means
                                    //if a doctor is in Dentist area, his specialty could be Oral, Periodontist and so on.
    private String area;            //assume doctor only related with one area for now
    private double  reviewScore;     //0.0 - 5.0
    private int    yearsOfExperience;
    //could have "hospital, price, location, level, age, ... "

    Doctor(){}

    Doctor(String name, String id, String gender, String specialty, String area, double reviewScore, int yearsOfExperience){
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.specialty = specialty;
        this.area = area;
        this.reviewScore = reviewScore;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }

    public String getGender(){
        return gender;
    }

    public String getSpecialty(){
        return specialty;
    }

    public String getArea(){
        return area;
    }

    public double getReviewScore(){
        return reviewScore;
    }

    public int getYearsOfExperience(){
        return yearsOfExperience;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public void setSpecialty(String specialty){
        this.specialty = specialty;
    }

    public void setArea(String area){
        this.area = area;
    }

    public void setReviewScore(double reviewScore){
        this.reviewScore = reviewScore;
    }

    public void setYearsOfExperience(int yearsOfExperience){
        this.yearsOfExperience = yearsOfExperience;
    }
}
