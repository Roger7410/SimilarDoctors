//Given a doctor, provides a list of similar doctors, in a prioritized order.

/*** Test data is stored in a HashTable instead of a Database for now.
 *   The <key,value> pair of the HashTable is <id,Doctor>
 *   Assume similar means doctors with same specialty.
 *   The similar doctor list contains the given doctor.
 *   Assume the prioritized order is only base on the review score and name.
 */
/***
 * Additional note.
 * When users want to find the similar doctors, they care about the locations, price, their experience and so on.
 * We can add buttons for users so they can add limit to the search similar functions and sorted by any aspect they
 * care about mostly, secondly, thirdly.
 * We can also collect the data based on the type of different users' prefer to improve our similar system match accurate.
 */
import java.util.*;

public class FindSimilar {

    //When the user click the button "Similar", assume the front-end will pass the id of that doctor to back-end.
    public ArrayList<Doctor> findSimilar(String id, Hashtable<String,Doctor> doctors){
        ArrayList<Doctor> similarDoctors = new ArrayList<>();

        //if the id is invalid, return an empty list and a remind message for now
        if(!doctors.containsKey(id)){
            System.out.println("The given id is invalid, please try again.");
            return similarDoctors;
        }

        //get the given doctor and the target specialty
        Doctor currentDoctor = doctors.get(id);
        String targetSpecialty = currentDoctor.getSpecialty();

        //travel the data 'doctors' to find out who's specialty is same with the given doctor.
        Enumeration<Doctor> doctorEnumeration = doctors.elements();
        while(doctorEnumeration.hasMoreElements()) {
            Doctor doctor = doctorEnumeration.nextElement();
            //we can change conditions by the define of what similar means
            if(doctor.getSpecialty().equals(targetSpecialty)){
                similarDoctors.add(doctor);
            }
        }

        //sort the priority based by the review score and name from A-Z
        //we can also sort by the doctor's level, distance, ...
        Collections.sort(similarDoctors, new Comparator<Doctor>() {
            @Override
            public int compare(Doctor d1, Doctor d2) {
                //sort by review score first  ---  in descending order (4.3 > 4.2 > 4.1)
                double score1 = d1.getReviewScore();
                double score2 = d2.getReviewScore();
                if(score1 != score2){
                    if(score2 > score1) return 1;
                    else return -1;
                    //return (int)((score2 - score1)*10);
                }else{//sort by name  ---  in A->Z order (A > B > Z)
                    return d1.getName().compareTo(d2.getName());
                }
            }
        });

        return similarDoctors;
    }

}
