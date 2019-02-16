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
    private  int statTimeSS;
    private  int finishTimeHH;
    private  int finishTimeSS;
    private  int duration;
    private String description;
    private String subject;
    private  int transactions;
    private String type;
    private String component;
}
