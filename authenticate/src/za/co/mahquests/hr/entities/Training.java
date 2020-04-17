package za.co.mahquests.hr.entities;

import java.time.LocalDate;

public class Training {
    private LocalDate startDate;
    private LocalDate endDate;
    private String trainingTitle;

    public Training(LocalDate startDate, LocalDate endDate, String trainingTitle){
        this.startDate = startDate;
        this.endDate = endDate;
        this.trainingTitle = trainingTitle;

    }

    public String toString(){
        return "Course Details {" +
                "\nStart date: " + startDate +
                "\nEnd date" + endDate +
                "\nCourse title: " + trainingTitle
                +"\n}";
    }

    public LocalDate getStartDate(){
        return startDate;
    }

    public LocalDate getEndDate(){
        return endDate;
    }

    public String getTrainingTitle(){
        return trainingTitle;
    }

}

