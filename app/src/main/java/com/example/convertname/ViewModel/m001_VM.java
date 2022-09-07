package com.example.convertname.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class m001_VM extends ViewModel {
            private final MutableLiveData<String> firstName  = new MutableLiveData<>("");
            private final MutableLiveData<String> lastName = new MutableLiveData<>("") ;
            private final MutableLiveData<Boolean> isEn = new MutableLiveData<>(false) ;

            public void setInfo(String firstName,String lastName,boolean isEN)
            {
                this.firstName.postValue(firstName);
                this.isEn.postValue(isEN);
                this.lastName.postValue(lastName);
            }

    public MutableLiveData<Boolean> getIsEn() {
        return isEn;
    }

    public MutableLiveData<String> getFirstName() {
        return firstName;
    }

    public MutableLiveData<String> getLastName() {
        return lastName;
    }
}
