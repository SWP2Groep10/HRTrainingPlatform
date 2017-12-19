package com.company.hrtrainingplatform.web.training;

import com.company.hrtrainingplatform.entity.Location;
import com.company.hrtrainingplatform.entity.Training;
import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Table;

import javax.inject.Inject;

public class TrainingBrowse extends AbstractLookup {

  @Inject
  private Table<Training> trainingsTable;


    public void onExcel(Component source) {
    }



    public void onShowLocationClick() {
        Training t = trainingsTable.getSingleSelected();
        trainingsTable.setEnabled(true);
       // String url = "http://maps.google.com/?q=" + t.getAddress().getCountry() + "+" + a.getAddress().getCity() + "+" + a.getAddress().getStreet() + "+" + a.getAddress().getNumber();
        String url = "http://maps.google.com/?q=" + t.getLocation().getLocationName();
        showWebPage(url, ParamsMap.of("target", "_blank"));
    }

}