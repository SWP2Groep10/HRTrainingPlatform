package com.company.hrtrainingplatform.web.address;

import com.company.hrtrainingplatform.entity.Address;
import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;

public class AddressBrowse extends AbstractLookup {

    @Inject
    private Table<Address> addressesTable;
    @Inject
    private Datasource<Address> addressesDs;

    public void onShowMapClick() {

        try {
            Address a = addressesTable.getSingleSelected();
            String url = "http://maps.google.com/?q=" + a.getCountry() + "+" + a.getCity() + "+" + a.getPostalcode() + "+" + a.getStreet() + "+" + a.getNumber();
            showWebPage(url, ParamsMap.of("target", "_blank"));
        }
        catch (NullPointerException e) {showNotification("No selection has been made.");}
    }
}