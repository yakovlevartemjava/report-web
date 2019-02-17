package ru.itpark.reportweb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Incident {
    private int id;
    private int clientId;
    private String data;
    private int startTimeHH;
    private  int startTimeMM;
    private  int finishTimeHH;
    private  int finishTimeMM;
    private  int duration;
    private String description;
    private String subject;
    private  int transactions;
}
