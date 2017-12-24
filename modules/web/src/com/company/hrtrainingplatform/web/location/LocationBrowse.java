package com.company.hrtrainingplatform.web.location;

import com.company.hrtrainingplatform.entity.Address;
import com.company.hrtrainingplatform.entity.Location;
import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.gui.components.EntityCombinedScreen;
import com.haulmont.cuba.gui.components.Table;

import javax.inject.Inject;

public class LocationBrowse extends EntityCombinedScreen {

    @Inject
    private Table<Location> table;

  public void onShowMapClick() {
        try {
            Location l = table.getSingleSelected();
            Address a = l.getAddress();
            String url = "http://maps.google.com/?q=" + a.getCountry() + "+" + a.getCity() + "+" + a.getPostalcode() + "+" + a.getStreet() + "+" + a.getNumber();
            showWebPage(url, ParamsMap.of("target", "_blank"));
        }
        catch (NullPointerException e){showNotification("No selection has been made.");}
    }
    
}