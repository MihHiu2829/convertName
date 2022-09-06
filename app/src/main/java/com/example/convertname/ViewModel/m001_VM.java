package com.example.convertname.ViewModel;

import androidx.lifecycle.ViewModel;

public class m001_VM extends ViewModel {
            private String fullName ;
            private String lastName ;
            private boolean isEN ;

            public void setInfo(String firstName,String lastName,boolean isEN)
            {
                this.fullName = fullName;
                this.isEN = isEN ;
                this.lastName = lastName  ;
            }



}
