package com.codetru.project.cica.utils;

import java.util.ArrayList;
import java.util.List;

public class ThreadLocalManager {

    // ThreadLocal variables to hold the lists
    private static ThreadLocal<List<String>> licenseStateList = ThreadLocal.withInitial(ArrayList::new);
    private static ThreadLocal<List<String>> appointmentStatusList = ThreadLocal.withInitial(ArrayList::new);
    private static ThreadLocal<List<String>> licenseCountyList = ThreadLocal.withInitial(ArrayList::new);
    private static ThreadLocal<List<String>> licenseExpDateList = ThreadLocal.withInitial(ArrayList::new);
    private static ThreadLocal<Integer> flag = ThreadLocal.withInitial(() -> 1);
    private static ThreadLocal<Integer> licStateIndex = ThreadLocal.withInitial(() -> 0);
    private static ThreadLocal<Integer> licCountyIndex = ThreadLocal.withInitial(() -> 0);
    private static final ThreadLocal<String> threadLocalFirstName = new ThreadLocal<>();
    private static ThreadLocal<Integer> threadLocalPlanNumber = ThreadLocal.withInitial(() -> 1);

    // Getters
    public static List<String> getLicenseStateList() {
        return licenseStateList.get();
    }

    public static List<String> getAppointmentStatusList() {
        return appointmentStatusList.get();
    }
    
    public static List<String> getLicenseCountyList() {
    	return licenseCountyList.get();
    }

    public static List<String> getLicenseExpDateList() {
    	return licenseCountyList.get();
    }
    
    // Setters
    public static void setLicenseStateList(List<String> list) {
        licenseStateList.set(list);
    }

    public static void setAppointmentStatusList(List<String> list) {
        appointmentStatusList.set(list);
    }
    
    public static void setLicenseCountyList(List<String> list) {
    	licenseCountyList.set(list);
    }
    
    public static void setLicenseExpDateList(List<String> list) {
    	licenseExpDateList.set(list);
    }
    
    public static void setFlag(int value) {
        flag.set(value);
    }

    public static int getFlag() {
        return flag.get();
    }
    
    public static void setLicStateIndex(int value) {
    	licStateIndex.set(value);
    }
    
    public static int getLicStateIndex() {
    	return licStateIndex.get();
    }
    
    public static void setLicCountyIndex(int value) {
    	licCountyIndex.set(value);
    }
    
    public static int getLicCountyIndex() {
    	return licCountyIndex.get();
    }
    
    // Set the string value
    public static void setFirstName(String value) {
    	threadLocalFirstName.set(value);
    }

    // Get the string value
    public static String getFirstName() {
        return threadLocalFirstName.get();
    }
    

    //Set Get for Basic Plan. Standard and Guaranteed
    public static void setPlanNumber(int value) {
    	threadLocalPlanNumber.set(value);
    }
    
    public static int getPlanNumber() {
    	return threadLocalPlanNumber.get();
    }
    
    // Clearing thread-local variables after use
    public static void clear() {
        licenseStateList.remove();
        appointmentStatusList.remove();
        licenseCountyList.remove();
        licenseExpDateList.remove();
        flag.remove();
        licStateIndex.remove();
        licCountyIndex.remove();
        threadLocalFirstName.remove();
        threadLocalPlanNumber.remove();
    }
}
