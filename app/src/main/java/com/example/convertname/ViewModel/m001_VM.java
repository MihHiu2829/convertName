package com.example.convertname.ViewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class m001_VM extends ViewModel {
            private final MutableLiveData<String> firstName  = new MutableLiveData<>("");
            private final MutableLiveData<String> lastName = new MutableLiveData<>("") ;
            private final MutableLiveData<Boolean> isEn = new MutableLiveData<>(false) ;

            public void setInfo(String firstName,String lastName,boolean isEN)
            {
                this.firstName.postValue(firstName);
                this.lastName.postValue(lastName);
                this.isEn.postValue(isEN);
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

    public MediatorLiveData<String> fullnameLD()
    {
        MediatorLiveData<String> Mediator = new MediatorLiveData<>();

        Observer<? super Object> handleName = new Observer<Object>() {
            @Override
            public void onChanged(Object s) {
                if(isEn.getValue() != null && isEn.getValue())
                {
                    Mediator.postValue(firstName.getValue()+" " + lastName.getValue());
                }else  {
                    Mediator.postValue(lastName.getValue()+" " + firstName.getValue());
                }
            }
        };

        Mediator.addSource(firstName,handleName);
        Mediator.addSource(lastName,handleName);
        Mediator.addSource(isEn,handleName);

        return Mediator ;
    }
}
