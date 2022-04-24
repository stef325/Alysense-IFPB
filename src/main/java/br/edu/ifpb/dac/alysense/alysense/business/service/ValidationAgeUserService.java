package br.edu.ifpb.dac.alysense.alysense.business.service;

import java.time.LocalDate;
import java.time.Period;

public class ValidationAgeUserService {
    
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
}
