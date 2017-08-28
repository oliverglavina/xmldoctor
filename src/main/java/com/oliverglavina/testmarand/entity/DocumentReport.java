package com.oliverglavina.testmarand.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by Eyferann on 24. 08. 2017.
 */
@Entity
public class DocumentReport {

    @Id
    @GeneratedValue
    private String id;

    private Timestamp datetime;

    private String doctorId;

    private String error;

    public DocumentReport(){

    }

    public DocumentReport(Timestamp datetime, String doctorId, String error){
        super();
        this.datetime= datetime;
        this.doctorId= doctorId;
        this.error= error;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
