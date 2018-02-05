package com.wj.domain;

import java.util.Date;

public class SampleData {
    private int id;
    private Date sampling_time;
    private Date entry_Time;
    private Double sampleData_one;
    private Double sampleData_two;
    private Double sampleData_three;
    private Double sampleData_four;
    private Double sampleData_five;
    private Double average_value;
    private Double variance;
    private Double standard_Deviation;
    private int status;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setSampling_time(Date sampling_time) {
        this.sampling_time = sampling_time;
    }

    public Date getSampling_time() {
        return sampling_time;
    }

    public void setEntry_Time(Date entry_Time) {
        this.entry_Time = entry_Time;
    }

    public Date getEntry_Time() {
        return entry_Time;
    }

    public void setSampleData_one(Double sampleData_one) {
        this.sampleData_one = sampleData_one;
    }

    public Double getSampleData_one() {
        return sampleData_one;
    }

    public void setSampleData_two(Double sampleData_two) {
        this.sampleData_two = sampleData_two;
    }

    public Double getSampleData_two() {
        return sampleData_two;
    }

    public void setSampleData_three(Double sampleData_three) {
        this.sampleData_three = sampleData_three;
    }

    public Double getSampleData_three() {
        return sampleData_three;
    }

    public void setSampleData_four(Double sampleData_four) {
        this.sampleData_four = sampleData_four;
    }

    public Double getSampleData_four() {
        return sampleData_four;
    }

    public void setSampleData_five(Double sampleData_five) {
        this.sampleData_five = sampleData_five;
    }

    public Double getSampleData_five() {
        return sampleData_five;
    }
    public Double getAverage_value() {
        return average_value;
    }

    public void setAverage_value(Double average_value) {
        this.average_value = average_value;
    }

    public Double getVariance() {
        return variance;
    }

    public void setVariance(Double variance) {
        this.variance = variance;
    }
    public Double getStandard_Deviation() {
        return standard_Deviation;
    }

    public void setStandard_Deviation(Double standard_Deviation) {
        this.standard_Deviation = standard_Deviation;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
