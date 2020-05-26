package com.sunil.observabledatabindingdemo;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;


public class UserDTO extends BaseObservable {
    private String firstName;
    private String LastName;


    @Bindable
    public String getLastName() {
        return LastName;
    }

    public void setLastName(final String lastName) {
        LastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }
}
