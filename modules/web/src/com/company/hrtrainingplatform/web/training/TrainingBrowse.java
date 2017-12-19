package com.company.hrtrainingplatform.web.training;

import com.company.hrtrainingplatform.entity.*;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Table;


import javax.inject.Inject;

public class TrainingBrowse extends AbstractLookup {

  @Inject
  private Table<Training> trainingsTable;

    public void onExcel(Component source) {
    }

}