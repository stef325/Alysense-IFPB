package br.edu.ifpb.dac.alysense.alysense.util;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
public class UserValidations {

    public static boolean isAgeEnoughToVote(float expectedAge, LocalDate birthDate){
        LocalDate actualDate = LocalDate.now();
        Period period = Period.between(birthDate, actualDate);

        float age = (float) (period.getYears() + (period.getMonths()*0.01));

        if (age >= expectedAge ) {
            return true;
        }
        else{
            return false;
        }
    }
    
    public static boolean canUse(String product, List<String> userproducts){
        
        if (userproducts.contains(product)){
            return true;
        }
        else{return false;}
    }
}
