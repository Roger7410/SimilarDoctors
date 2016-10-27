import java.util.ArrayList;
import java.util.Hashtable;

public class UnitTests {
    //Doctor: name, id, gender, specialty, area, reviewScore, yearsOfExperience
    private Hashtable<String,Doctor> testData;

    private void createTestData(){
        testData = new Hashtable<>();
        //for same specialty with different review score
        testData.put("1111", new Doctor("Tom","1111","male","Echocardiographer","Cardiologist",4.1,5));
        testData.put("1112", new Doctor("Jack","1112","male","Echocardiographer","Cardiologist",4.2,2));
        testData.put("1113", new Doctor("Peter","1113","male","Echocardiographer","Cardiologist",4.3,2));
        testData.put("1114", new Doctor("Jenny","1114","female","Echocardiographer","Cardiologist",4.4,5));
        testData.put("1115", new Doctor("Mike","1115","male","Nuclear","Cardiologist",4.5,2));
        testData.put("1116", new Doctor("Sophie","1116","female","Periodontist","Dentist",4.6,2));

        //for same specialty same review score(some of them) with different name
        testData.put("0001", new Doctor("Rachel","0001","female","Oral","Dentist",4.1,6));
        testData.put("0002", new Doctor("Monica","0002","female","Oral","Dentist",4.3,4));
        testData.put("0003", new Doctor("Phoebe","0003","female","Oral","Dentist",4.3,3));
        testData.put("0004", new Doctor("Joey","0004","male","Oral","Dentist",4.3,5));
        testData.put("0005", new Doctor("Chandler","0005","male","Oral","Dentist",4.5,2));
        testData.put("0006", new Doctor("Ross","0006","male","Periodontist","Dentist",4.6,2));

        //for same specialty same review score with same name
        testData.put("2221", new Doctor("Siwei","2221","male","Orthodontist","Dentist",4.1,6));
        testData.put("2222", new Doctor("Siwei","2222","male","Orthodontist","Dentist",4.1,4));
        testData.put("2223", new Doctor("Siwei","2223","male","Orthodontist","Dentist",4.1,2));

        //testData.put("123",new Doctor());
    }

    /***
     * Test for doctors with same specialty and different review scores.
     * The out put list order should be Jenny -> Peter -> Jack -> Tom.
     */
    private void test1(){
        FindSimilar f = new FindSimilar();
        ArrayList<Doctor> doctors = f.findSimilar("1112",testData);
        //check the order and the size
        if(     doctors.get(0).getName().equals("Jenny") &&
                doctors.get(1).getName().equals("Peter") &&
                doctors.get(2).getName().equals("Jack") &&
                doctors.get(3).getName().equals("Tom") &&
                doctors.size() == 4){
            System.out.println("Test1 pass.");
        }else{
            System.out.println("Test1 fail");
        }
    }

    /***
     * Test for doctors with same specialty and same review scores(some of them) with different names.
     * The out put list order should be Chandler -> Joey -> Monica -> Phoebe -> Rachel.
     */
    private void test2(){
        FindSimilar f = new FindSimilar();
        ArrayList<Doctor> doctors = f.findSimilar("0002",testData);
        //check the order and the size
        if(     doctors.get(0).getName().equals("Chandler") &&
                doctors.get(1).getName().equals("Joey") &&
                doctors.get(2).getName().equals("Monica") &&
                doctors.get(3).getName().equals("Phoebe") &&
                doctors.get(4).getName().equals("Rachel") &&
                doctors.size()==5){
            System.out.println("Test2 pass.");
        }else{
            System.out.println("Test2 fail");
        }
    }

    /***
     * Test for doctors with same specialty and same review scores with same names.
     * The out put list order should be Siwei -> Siwei -> Siwei.
     */
    private void test3(){
        FindSimilar f = new FindSimilar();
        ArrayList<Doctor> doctors = f.findSimilar("2222",testData);
        //check the order and the size
        if(     doctors.get(0).getName().equals("Siwei") &&
                doctors.get(1).getName().equals("Siwei") &&
                doctors.get(2).getName().equals("Siwei") &&
                doctors.size()==3){
            System.out.println("Test3 pass.");
        }else{
            System.out.println("Test3 fail");
        }
    }

    /*** for debug
     * for(Doctor doctor : doctors){
     * System.out.println(doctor.getName());
     * }
     */

    public static void main(String[] args) {
        UnitTests tests = new UnitTests();
        tests.createTestData();
        tests.test1();
        tests.test2();
        tests.test3();
    }
}
