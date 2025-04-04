package com.example.Web.services;

import com.example.Web.model.TelephoneBookModel;

import java.util.ArrayList;
import java.util.List;

public class service {

    private static List<TelephoneBookModel> contact;

    static {
        contact = new ArrayList<>();
        contact.add("9988483", "Red");
    }
}
