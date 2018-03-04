package realm;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Donal on 02/03/2018.
 */

public class User extends RealmObject {

    @PrimaryKey
    @Required // optional, but recommended.
    private String personID;

    //distance statistics
    private double totalDistance;
    private double runDistance;
    private double swimDistance;
    private double cycleDistance;

    //time statistics
    private double totalTime;
    private double runTime;
    private double swimTime;
    private double cycleTime;

    //Speed
    private double totalAvgSpeed;
    private double runAvgSpeed;
    private double swimAvgSpeed;
    private double cycleAvgSpeed;

    @Ignore
    private int sessionId;

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public double getRunDistance() {
        return runDistance;
    }

    public void setRunDistance(double runDistance) {
        this.runDistance = runDistance;
    }

    public double getSwimDistance() {
        return swimDistance;
    }

    public void setSwimDistance(double swimDistance) {
        this.swimDistance = swimDistance;
    }

    public double getCycleDistance() {
        return cycleDistance;
    }

    public void setCycleDistance(double cycleDistance) {
        this.cycleDistance = cycleDistance;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public double getRunTime() {
        return runTime;
    }

    public void setRunTime(double runTime) {
        this.runTime = runTime;
    }

    public double getSwimTime() {
        return swimTime;
    }

    public void setSwimTime(double swimTime) {
        this.swimTime = swimTime;
    }

    public double getCycleTime() {
        return cycleTime;
    }

    public void setCycleTime(double cycleTime) {
        this.cycleTime = cycleTime;
    }

    public double getTotalAvgSpeed() {
        return totalAvgSpeed;
    }

    public void setTotalAvgSpeed(double totalAvgSpeed) {
        this.totalAvgSpeed = totalAvgSpeed;
    }

    public double getRunAvgSpeed() {
        return runAvgSpeed;
    }

    public void setRunAvgSpeed(double runAvgSpeed) {
        this.runAvgSpeed = runAvgSpeed;
    }

    public double getSwimAvgSpeed() {
        return swimAvgSpeed;
    }

    public void setSwimAvgSpeed(double swimAvgSpeed) {
        this.swimAvgSpeed = swimAvgSpeed;
    }

    public double getCycleAvgSpeed() {
        return cycleAvgSpeed;
    }

    public void setCycleAvgSpeed(double cycleAvgSpeed) {
        this.cycleAvgSpeed = cycleAvgSpeed;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }
}
