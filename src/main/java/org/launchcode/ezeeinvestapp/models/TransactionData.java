package org.launchcode.ezeeinvestapp.models;

import java.util.ArrayList;


public class TransactionData {


    public static ArrayList<Transaction> findByColumnAndValue(String column, String value, Iterable<Transaction> allJobs) {

        ArrayList<Transaction> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<Transaction>) allJobs;
        }

        if (column.equals("all")){
            results = findByValue(value, allJobs);
            return results;
        }
        for (Transaction transaction : allJobs) {

            String aValue = getFieldValue(transaction, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(transaction);
            }
        }

        return results;
    }

    public static String getFieldValue(Transaction transaction, String fieldName){
        String theValue;
        if (fieldName.equals("name")){
            theValue = transaction.getName();
        } else if (fieldName.equals("client")){
            theValue = transaction.getClient().toString();
        } else {
            theValue = transaction.getSkills().toString();
        }

        return theValue;
    }


    public static ArrayList<Transaction> findByValue(String value, Iterable<Transaction> allJobs) {
        String lower_val = value.toLowerCase();

        ArrayList<Transaction> results = new ArrayList<>();

        for (Transaction transaction : allJobs) {

            if (transaction.getName().toLowerCase().contains(lower_val)) {
                results.add(transaction);
            } else if (transaction.getClient().toString().toLowerCase().contains(lower_val)) {
                results.add(transaction);
            } else if (transaction.getSkills().toString().toLowerCase().contains(lower_val)) {
                results.add(transaction);
            } else if (transaction.toString().toLowerCase().contains(lower_val)) {
                results.add(transaction);
            }

        }

        return results;
    }


}

