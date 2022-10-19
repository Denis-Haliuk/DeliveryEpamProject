package org.epam.finalproject.entity;

import java.sql.Date;

public class Delivery {

    private int id;
    private int userId;
    private int directionId;
    private int typeId;
    private int weight;
    private String fullName;
    private long senderPhone;
    private String receiverName;
    private long receiverPhone;
    private String receiverAddress;
    private Date date;
    private int stateId;

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDirectionId() {
        return directionId;
    }

    public void setDirectionId(int directionId) {
        this.directionId = directionId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(long senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public long getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(long receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", userId=" + userId +
                ", directionId=" + directionId +
                ", typeId=" + typeId +
                ", weight=" + weight +
                ", fullName='" + fullName + '\'' +
                ", senderPhone=" + senderPhone +
                ", receiverName='" + receiverName + '\'' +
                ", receiverPhone=" + receiverPhone +
                ", receiverAddress='" + receiverAddress + '\'' +
                '}';
    }
}
