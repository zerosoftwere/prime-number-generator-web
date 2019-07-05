package me.xerosoft.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class PrimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    @CreationTimestamp
    private Timestamp timestamp;

    @Column
    private Integer start;

    @Column
    private Integer end;

    @Column
    private Integer totalPrimes;

    @Column
    private Double elapsedTime;

    @Column
    private String algorithm;

    public PrimeEntity() { }

    public PrimeEntity(int start, int end, int primes, double elapsedTime, String algorithm) {
        this.start = start;
        this.end = end;
        this.totalPrimes = primes;
        this.elapsedTime = elapsedTime;
        this.algorithm = algorithm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Integer getTotalPrimes() {
        return totalPrimes;
    }

    public void setTotalPrimes(Integer totalPrimes) {
        this.totalPrimes = totalPrimes;
    }

    public Double getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(Double elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }
}
